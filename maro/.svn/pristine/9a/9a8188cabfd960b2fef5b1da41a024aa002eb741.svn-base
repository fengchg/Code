package com.maro.common.print.xprinter.printable;

import java.util.List;

import com.maro.common.print.api.Converter;
import com.maro.common.print.api.DeviceSetting;
import com.maro.common.print.api.content.Convertable;
import com.maro.common.print.api.content.convertable.Text;
import com.maro.common.print.api.content.printable.Section;
import com.maro.common.print.api.content.printable.Section.TextAlign;
import com.maro.common.print.api.exception.PrinterException;
import com.maro.common.print.xprinter.ESCPOSCode;
import com.maro.common.print.xprinter.util.BytesBuffer;
import com.maro.common.print.xprinter.util.TextAlignUtil;

/**
 * 打印文字段落命令
 */
public class SectionConverter extends Converter<Section> {

	@Override
	public byte[] toBytes(DeviceSetting deviceSetting) throws PrinterException {
		List<Text> contents = getConvertable().getConvertables();
		TextAlign align = getConvertable().getTextAlign();
		BytesBuffer out = new BytesBuffer();
		out.write(TextAlignUtil.toBytes(align));
		for (Text text : contents) {
			out.write(getConverterKit().fromConverter(text, deviceSetting));
		}
		out.write(ESCPOSCode.LF);
		return out.toByteArray();
	}
}
