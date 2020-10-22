package com.maro.common.print.api.content.printable;

import com.maro.common.print.api.content.Printable;
import com.maro.common.print.api.exception.PrintException;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
public class NolineTable implements Printable {

	/** 每个单元格的宽度（字符数），中文算两个，英文算一个 */
	private List<Integer> columnWidths= new ArrayList<>();

	/** 是否靠右打印，默认为靠左打印 */
	private List<Boolean> alignRights= new ArrayList<>();

	/** 行内容 */
	private List<Row> rows = new LinkedList<Row>();

	/**
	 * 线行
	 */
	public static final List<String> LINE_ROW = new ArrayList<String>(){{add("-"); }};

	public NolineTable(){
		super();
	}
	/**
	 * 构造一个表格
	 *            表头
	 * @param columnWidths
	 *            表头
	 * @param alignRights
	 *            列对齐
	 */
	public NolineTable( List<Integer> columnWidths, List<Boolean> alignRights) {
		if ( columnWidths.size() != alignRights.size()) {
			throw new PrintException("The number of headers & cellWidths & alignRights must be equal!");
		}
		this.columnWidths = columnWidths;
		this.alignRights = alignRights;
	}
	@XmlElementWrapper(name = "cws")
	@XmlElement(name="cw")
	public List<Integer> getColumnWidths() {
		return columnWidths;
	}
	@XmlElementWrapper(name = "ars")
	@XmlElement(name="ar")
	public List<Boolean> getAlignRights() {
		return alignRights;
	}

	public boolean addOneRow(Row lineRow) {
		return rows.add(lineRow);
	}

	public boolean addManyRows(List<Row> many_rows) {
		return rows.addAll(many_rows);
	}

	@XmlElementWrapper(name="rows")
	@XmlElement(name="row")
	public List<Row> getRows() {
		return rows;
	}
}
