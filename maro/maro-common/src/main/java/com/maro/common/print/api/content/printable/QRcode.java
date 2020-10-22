package com.maro.common.print.api.content.printable;

import com.maro.common.print.api.content.Printable;

/**
 * 二维码<br/>
 * 输出完成后自动换新行
 */
public class QRcode implements Printable {


	/** 上文间距(像素) */
	private int marginTop;
	/** 下文间距(像素) */
	private int marginBottom;

	/** 内容 */
	private String content;

	/** 宽度(像素) */
	private Integer width;

	/**
	 * 构造一个二维码
	 * 
	 * @param content
	 *            二维码内容
	 * @param width
	 *            图片宽度(像素)
	 */
	public QRcode(String content, int width) {
		this.content = content;
		this.width = width;
	}

	/**
	 * 构造一个二维码
	 * 
	 * @param content
	 *            二维码内容
	 * @param width
	 *            图片宽度(像素)
	 * @param marginTop
	 * marginBottom
	 *            上下文间距(像素)
	 */
	public QRcode(String content, int width, int marginTop,int marginBottom) {
		this.content = content;
		this.width = width;
		this.marginTop = marginTop;
		this.marginBottom = marginBottom;
	}

	/**
	 * 构造一个二维码，使用默认宽度
	 * 
	 * @param content
	 *            二维码内容
	 */
	public QRcode(String content) {
		this.content = content;
		this.width = 0;
	}

	public String getContent() {
		return content;
	}

	public Integer getWidth() {
		return width;
	}


	public int getMarginTop() {
		return marginTop;
	}

	public void setMarginTop(int marginTop) {
		this.marginTop = marginTop;
	}

	public int getMarginBottom() {
		return marginBottom;
	}

	public void setMarginBottom(int marginBottom) {
		this.marginBottom = marginBottom;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}
}
