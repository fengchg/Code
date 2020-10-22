package com.maro.common.print.xprinter.printable;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.maro.common.print.api.Converter;
import com.maro.common.print.api.DeviceSetting;
import com.maro.common.print.api.content.convertable.Font;
import com.maro.common.print.api.content.convertable.Font.FontSize;
import com.maro.common.print.api.content.printable.Line;
import com.maro.common.print.api.content.printable.Row;
import com.maro.common.print.api.content.printable.Table;
import com.maro.common.print.api.exception.PrinterException;
import com.maro.common.print.xprinter.ESCPOSCode;
import com.maro.common.print.xprinter.util.BytesBuffer;
import com.maro.common.print.xprinter.util.StringUtil;

/**
 * 表格转换器
 */
public class TableConverter extends Converter<Table> {

	private static final Line black_line = Line.SOLID_THICK;
	private static final Line dot_line = Line.DOT_THIN;
	private static final Line head_line = Line.DOT_THICK;

	@Override
	public byte[] toBytes(DeviceSetting setting) throws PrinterException {

		List<String> headers = getConvertable().getHeaders();
		List<Integer> columnWidths = getConvertable().getColumnWidths();
		List<Boolean> alignRights = getConvertable().getAlignRights();
		List<Row> rows = getConvertable().getRows();

		// 计算制表位置
		byte[] hPoint = checkCellWidth(headers, columnWidths, StringUtil.getCharEachLine(setting));
		BytesBuffer out = new BytesBuffer();

		out.write(getConverterKit().fromConverter(black_line, setting));// 画一条黑实线

		// 设置表头字体
		Font textStyle = new Font(FontSize.Small, true, false);
		out.write(getConverterKit().fromConverter(textStyle, setting));
		// 设置制表位置
		out.write(ESCPOSCode.SET_TABLE_CELL_POSITION(hPoint));
		out.write(createHeaderBytes(headers, columnWidths, alignRights, setting));// 写入表头内容
		out.write(ESCPOSCode.CANCLE_TABLE_CELL_POSITION_SETTING());// 取消表格位置设置
		out.write(getConverterKit().fromConverter(head_line, setting));// 画一条表头线

		// 设置表体字体
		textStyle = new Font(FontSize.Small, false, false);
		out.write(getConverterKit().fromConverter(textStyle, setting));
		// 设置制表位置
		out.write(ESCPOSCode.SET_TABLE_CELL_POSITION(hPoint));
		out.write(creatBodyBytes(rows, columnWidths, alignRights, setting));// 写入表格内容
		out.write(ESCPOSCode.CANCLE_TABLE_CELL_POSITION_SETTING());// 取消表格内容设置

		out.write(getConverterKit().fromConverter(black_line, setting));// 画一条黑实线

		return out.toByteArray();
	}

	/**
	 * 写入表头内容
	 * 
	 * @param headers
	 * @param columnWidths
	 * @param alignRights
	 * @param setting
	 * @return
	 * @throws PrinterException
	 */
	private byte[] createHeaderBytes(List<String> headers, List<Integer> columnWidths, List<Boolean> alignRights, DeviceSetting setting) throws PrinterException {
		BytesBuffer out = new BytesBuffer();
		MultipleRow content = new MultipleRow(headers, columnWidths);
		List<Object[]> one_rows = content.toRows(alignRights);
		out(out, one_rows, columnWidths, alignRights, setting);
		return out.toByteArray();
	}

	/**
	 * 写入表体内容
	 * 
	 * @param rows
	 * @param columnWidths
	 * @param alignRights
	 * @param setting
	 * @return
	 * @throws PrinterException
	 */
	private byte[] creatBodyBytes(List<Row> rows, List<Integer> columnWidths, List<Boolean> alignRights, DeviceSetting setting) throws PrinterException {
		BytesBuffer out = new BytesBuffer();
		for (Row a_row : rows) {
			if (a_row.equals(Table.LINE_ROW)) {
				out.write(getConverterKit().fromConverter(dot_line, setting));
				continue;
			}
			MultipleRow content = new MultipleRow(a_row.getTd(), columnWidths);
			List<Object[]> one_rows = content.toRows(alignRights);
			out(out, one_rows, columnWidths, alignRights, setting);
		}

		return out.toByteArray();
	}

	/**
	 * 内容输出，这里将自动对内容进行调整，以符合标准的单元格输出
	 * 
	 * @param out
	 * @param rows
	 *            一系列行内容
	 * @param
	 * @param columnWidths
	 * @param alignRights
	 * @param setting
	 * @throws PrinterException
	 */
	private void out(BytesBuffer out, List<Object[]> rows, List<Integer> columnWidths, List<Boolean> alignRights, DeviceSetting setting) throws PrinterException {
		int cell_num = columnWidths.size(); // 单元格个数
		for (Object[] row : rows) {
			for (int i = 0; i < cell_num; i++) {
				Object cell = row[i];
				String string_cell = String.valueOf(cell);
				// 这里进行右对齐内容的处理(左侧填充空格)
				if (null != alignRights && alignRights.get(i)) {
					string_cell = StringUtil.fillLeft2GBKLength(string_cell, ' ', columnWidths.get(i));
				}
				// 写入单元格内容
				try {
					out.write(string_cell.getBytes(setting.getCharset()));
				} catch (UnsupportedEncodingException e) {
					throw new PrinterException(e);
				}
				// 单元格写入后的操作
				if (i == cell_num - 1) {
					out.write(ESCPOSCode.LF);
				}
				// 如果内容小于单元格宽度则跳到下一格
				else if (StringUtil.lengthOfGBK(string_cell) < columnWidths.get(i)) {
					out.write(ESCPOSCode.HT);
				}
			}
		}
	}

	/**
	 * 此类将超出单元格长度的内容进行自动换行变换
	 */
	private class MultipleRow {
		// 松散的单元格
		private ArrayList<Object[]> cells = new ArrayList<Object[]>();
		// 行高（自动换行后的行数）
		private int rowHeight = 1;
		// 各单元格宽度
		private List<Integer> columnWidths;

		/**
		 * 构造
		 * 
		 * @param row
		 *            行内容
		 * @param columnWidths
		 *            各单元格宽度
		 */
		private MultipleRow(List<String> row, List<Integer> columnWidths) {
			this.columnWidths = columnWidths;
			setRow(row);
		}

		/**
		 * 这里将单元格内容进行自动换行处理，但出来的结果是松散的，各单元格的行数不一致
		 */
		private void setRow(List<String> row) {
			for (int i = 0; i < row.size(); i++) {
				String cell = String.valueOf(row.get(i));
				ArrayList<String> ss = new ArrayList<String>();
				do {
					// 如果内容超出列宽度则需要进行换行换行处理
					if (cell.length() >= columnWidths.get(i)) {
						String s;
						if (i == 0) {
							s = StringUtil.toGBKLength(cell, columnWidths.get(i));
							ss.add(s);
						} else {
							// 从第2列开始在内容前面加一个空格，以隔开两列的内容
							s = StringUtil.toGBKLength(cell, columnWidths.get(i) - 1);
							ss.add(" " + s);
						}
						cell = cell.substring(s.length());
					} else {
						if (i == 0) {
							ss.add(cell);
						} else {
							ss.add(" " + cell);
						}
						cell = "";
					}
				} while (cell.length() > 0);
				cells.add(ss.toArray(new String[0]));
				// 得出最大的行数
				if (rowHeight < ss.size())
					rowHeight = ss.size();
			}
		}

		/**
		 * 这里是将松散单元格变成一致行数的单元格，无内容的单元格使用“ ”填充
		 * 
		 * @param alignRights
		 * @return
		 */
		private List<Object[]> toRows(List<Boolean> alignRights) {
			List<Object[]> rows = new LinkedList<Object[]>();
			for (int a = 0; a < rowHeight; a++) {
				Object[] row = new Object[cells.size()];
				for (int i = 0; i < row.length; i++) {
					row[i] = " ";
				}
				rows.add(row);
			}
			for (int i = 0; i < cells.size(); i++) {
				Object[] cell_rows = cells.get(i);
				for (int j = 0; j < cell_rows.length; j++) {
					rows.get(j)[i] = cell_rows[j];
				}
			}
			return rows;
		}
	}

	/**
	 * 检查表格每列的位置
	 *
	 * @param headers
	 * @param columnWidths
	 * @param charEachLine
	 */
	private byte[] checkCellWidth(List<String> headers, List<Integer> columnWidths, int charEachLine) {
		int whole_length = 0;
		byte[] h_position = new byte[headers.size()];
		for (int i = 0; i < headers.size(); i++) {
			whole_length += columnWidths.get(i);
			h_position[i] = (byte) whole_length;
		}
		if (whole_length > charEachLine) {
			throw new RuntimeException("The whole length of the headers is longer than the width of this printer device!");
		}

		return h_position;
	}

}
