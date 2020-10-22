package com.maro.common.print.api.content.convertable;

import com.maro.common.print.api.content.Convertable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 文本，可以设置文本的格式
 */
@XmlRootElement(name="texts")
public class Text implements Convertable {
	@XmlElement(name="text")
	private String text;
	private Font font;

	public Text(){
		super();
	}
	/**
	 * 用默认字体构造一个文本对象
	 * 
	 * @param text
	 */
	public Text(String text) {
		this(text, Font.DEFAULT);
	}

	/**
	 * 用指定字体构造一个文本对象
	 * 
	 * @param text
	 * @param font
	 */
	public Text(String text, Font font) {
		this.text = text;
		this.font = font;
	}

	public String getText() {
		return text;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font textStyle) {
		this.font = textStyle;
	}

}
