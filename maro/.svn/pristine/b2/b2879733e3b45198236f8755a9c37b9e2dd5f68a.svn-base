package com.maro.common.print.xprinter.printable;

import java.io.UnsupportedEncodingException;

import com.maro.common.print.api.Converter;
import com.maro.common.print.api.DeviceSetting;
import com.maro.common.print.api.content.convertable.Font;
import com.maro.common.print.api.content.printable.KeyValue;
import com.maro.common.print.api.exception.PrinterException;
import com.maro.common.print.xprinter.ESCPOSCode;
import com.maro.common.print.xprinter.util.BytesBuffer;
import com.maro.common.print.xprinter.util.StringUtil;

/**
 * KeyValue转换器
 */
public class KeyValueConverter extends Converter<KeyValue> {

	@Override
	public byte[] toBytes(DeviceSetting setting) throws PrinterException {
		Font font = getConvertable().getFont();
		String key = getConvertable().getKey();
		String value = getConvertable().getValue();
		BytesBuffer out = new BytesBuffer();
		try {
			if(font!=null)
				out.write(getConverterKit().fromConverter(font, setting));
			else
				out.write(getConverterKit().fromConverter(Font.DEFAULT, setting));
			String str = key + " " + value;
			if (getConvertable().isOutter()) {
				if (StringUtil.lengthOfGBK(str) >= StringUtil.getCharEachLine(setting)) {
					out.write(ESCPOSCode.ESC_ALIGN_RIGHT);
					out.write(str.getBytes(setting.getCharset()));
				} else {
					out.write(ESCPOSCode.ESC_ALIGN_LEFT);
					out.write((key + StringUtil.fillLeft2GBKLength(value, ' ', StringUtil.getCharEachLine(setting) - StringUtil.lengthOfGBK(key))).getBytes(setting.getCharset()));
				}
			} else {
				out.write(ESCPOSCode.ESC_ALIGN_LEFT);
				if (StringUtil.lengthOfGBK(key + value) <= StringUtil.getCharEachLine(setting)) {
					out.write(str.getBytes(setting.getCharset()));
				} else {
					int leftblanknum = StringUtil.lengthOfGBK(key + " ");
					String line = StringUtil.toGBKLengthNoAdd(str, StringUtil.getCharEachLine(setting));
					out.write(StringUtil.toGBKLength(line, StringUtil.getCharEachLine(setting)).getBytes(setting.getCharset()));
					do {
						str = str.substring(line.length());
						if (str.isEmpty()) {
							break;
						}
						line = StringUtil.toGBKLengthNoAdd(str, StringUtil.getCharEachLine(setting) - leftblanknum);
						out.write(StringUtil.toGBKLengthNoAdd(repeatBlank(leftblanknum) + line, StringUtil.getCharEachLine(setting)).getBytes(setting.getCharset()));
					} while (true);
				}
			}
			out.write(ESCPOSCode.LF);
			return out.toByteArray();
		} catch (UnsupportedEncodingException e) {
			throw new PrinterException(e);
		}
	}

	private String repeatBlank(int n) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			sb.append(' ');
		}
		return sb.toString();
	}
}
