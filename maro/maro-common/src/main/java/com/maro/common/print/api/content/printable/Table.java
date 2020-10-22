package com.maro.common.print.api.content.printable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.maro.common.print.api.content.Printable;
import com.maro.common.print.api.exception.PrintException;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 表格<br/>
 * 表格从第2列开始，每列之前都会增加一个空格位，也就是说这些列的实际可用宽度会少一个字条位置。 <br/>
 * 如：{10,10,10}的列宽设置，而列的实际可用字符位置数为：{10,9,9} <br/>
 * 输出完成后自动换新行
 */
@XmlRootElement
public class Table implements Printable {

	/** 表头内容 */
	private List<String> headers=new ArrayList<>();

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

	/**
	 * 构造一个表格
	 * 
	 * @param headers
	 *            表头
	 * @param columnWidths
	 *            列宽
	 */
	public Table(List<String> headers, List<Integer> columnWidths) {
		this.headers = headers;
		this.columnWidths = columnWidths;
	}

	public Table(){
		super();
	}
	/**
	 * 构造一个表格
	 * 
	 * @param headers
	 *            表头
	 * @param columnWidths
	 *            表头
	 * @param alignRights
	 *            列对齐
	 */
	public Table(List<String> headers, List<Integer> columnWidths, List<Boolean> alignRights) {
		if (headers.size() != columnWidths.size() || headers.size() != alignRights.size()) {
			throw new PrintException("The number of headers & cellWidths & alignRights must be equal!");
		}
		this.headers = headers;
		this.columnWidths = columnWidths;
		this.alignRights = alignRights;
	}
	@XmlElementWrapper(name = "headers")
	@XmlElement(name="header")
	public List<String> getHeaders() {
		return headers;
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
