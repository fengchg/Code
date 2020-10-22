package com.maro.common.print.xprinter.convertable;

import com.maro.common.print.api.Converter;
import com.maro.common.print.api.DeviceSetting;
import com.maro.common.print.api.content.convertable.Font;
import com.maro.common.print.xprinter.ESCPOSCode;
import com.maro.common.print.xprinter.util.BytesBuffer;

/**
 * 文档格式
 */
public class FontConverter extends Converter<Font> {

	@Override
	protected byte[] toBytes(DeviceSetting deviceSetting) {

		boolean font_bold = getConvertable().isBold();
		boolean under_line = getConvertable().isUnderline();
		Font.FontSize fontSize = getConvertable().getFontSize();

		BytesBuffer out = new BytesBuffer();

		if (font_bold) {
			out.write(ESCPOSCode.ESC_SET_BOLD);
		} else {
			out.write(ESCPOSCode.ESC_CANCEL_BOLD);
		}

		if (under_line) {
			out.write(ESCPOSCode.FS_SET_UNDERLINE);
		} else {
			out.write(ESCPOSCode.FS_CANCEL_UNDERLINE);
		}

		if (fontSize == Font.FontSize.Big) {
			out.write(ESCPOSCode.ESC_FONT_SIZE_BIG);
		} else if (fontSize == Font.FontSize.Small) {
			out.write(ESCPOSCode.ESC_FONT_SIZE_MIN);
		} else {
			out.write(ESCPOSCode.ESC_FONT_SIZE_MID);
		}

		return out.toByteArray();

	}
}
