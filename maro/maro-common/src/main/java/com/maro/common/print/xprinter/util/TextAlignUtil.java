package com.maro.common.print.xprinter.util;

import com.maro.common.print.api.content.printable.Section.TextAlign;
import com.maro.common.print.xprinter.ESCPOSCode;

public class TextAlignUtil {

	public static byte[] toBytes(TextAlign align) {
		BytesBuffer out = new BytesBuffer();

		if (align == TextAlign.Center) {
			out.write(ESCPOSCode.ESC_ALIGN_CENTER);
		} else if (align == TextAlign.Right) {
			out.write(ESCPOSCode.ESC_ALIGN_RIGHT);
		} else {
			out.write(ESCPOSCode.ESC_ALIGN_LEFT);
		}
		return out.toByteArray();
	}

}
