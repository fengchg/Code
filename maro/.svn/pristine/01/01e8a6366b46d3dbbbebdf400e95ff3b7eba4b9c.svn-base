package com.maro.common.print.xprinter.convertable;

import java.io.UnsupportedEncodingException;

import com.maro.common.print.api.Converter;
import com.maro.common.print.api.DeviceSetting;
import com.maro.common.print.api.content.convertable.Font;
import com.maro.common.print.api.content.convertable.Text;
import com.maro.common.print.api.exception.PrinterException;
import com.maro.common.print.xprinter.util.BytesBuffer;

/**
 * 文本转换器
 */
public class TextConverter extends Converter<Text> {

	@Override
	protected byte[] toBytes(DeviceSetting setting) throws PrinterException {
		Font font = getConvertable().getFont();
		String content = getConvertable().getText();
		BytesBuffer out = new BytesBuffer();
		out.write(getConverterKit().fromConverter(font, setting));
		try {
			out.write(content.getBytes(setting.getCharset()));
		} catch (UnsupportedEncodingException e) {
			throw new PrinterException(e);
		}
		return out.toByteArray();
	}
}
