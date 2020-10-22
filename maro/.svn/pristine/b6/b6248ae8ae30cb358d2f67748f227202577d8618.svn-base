package com.maro.common.print.api.content.printable;

import com.maro.common.print.api.content.Doucument;
import com.maro.common.print.api.content.Printable;
import com.maro.common.print.api.content.convertable.Font;

import javax.xml.bind.annotation.*;

/**
 * 打印key=value型的文档，有紧凑和分离两种排列方式，如：<br/>
 * 紧凑型排列方式：
 * 
 * <pre>
 * |name: yaoming      |
 * |address: BeiJing   |
 * |         chaoyang  |
 * </pre>
 * 
 * 分离型排列方式：
 * 
 * <pre>
 * |name        yaoming|
 * |address            |
 * |   BeiJing ChaoYang|
 * </pre>
 * 
 * 输出完成后自动换新行
 */
@XmlRootElement(name="keyvalue")
public class KeyValue implements Printable {
	private boolean outter;
	@XmlElement(name = "key")
	private String key;
	@XmlElement(name = "value")
	private String value;
	private Font font;
	@XmlElement(name = "font")
	public Font getFont() {
		return font;
	}
	public void setFont(Font textStyle) {
		this.font = textStyle;
	}

	public KeyValue(){
		super();
	}
	/**
	 * 构造一个KeyValue项，紧凑排列
	 * 
	 * @param key
	 *            靠左的文本
	 * @param value
	 *            靠右的文本
	 */
	public KeyValue(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * 构造一个KeyValue项
	 * 
	 * @param key
	 *            靠左的文本
	 * @param value
	 *            靠右的文本
	 * @param outter
	 *            是否靠两端排列
	 */
	public KeyValue(String key, String value, boolean outter) {
		super();
		this.key = key;
		this.value = value;
		this.outter = outter;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public boolean isOutter() {
		return outter;
	}

	public void setOutter(boolean outter) {
		this.outter = outter;
	}

}
