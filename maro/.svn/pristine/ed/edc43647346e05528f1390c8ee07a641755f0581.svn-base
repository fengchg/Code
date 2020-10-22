package com.maro.common.print.xprinter.printable;

import com.maro.common.print.api.Converter;
import com.maro.common.print.api.DeviceSetting;
import com.maro.common.print.api.content.printable.CutPage;
import com.maro.common.print.xprinter.ESCPOSCode;
import com.maro.common.print.xprinter.util.BytesBuffer;

/**
 * 切纸转换器
 */
public class CutPageConverter extends Converter<CutPage> {

	public byte[] toBytes(DeviceSetting deviceSetting) {
		BytesBuffer out = new BytesBuffer();
		out.write(ESCPOSCode.ESC_FORWARD_LINE(4));
		out.write(ESCPOSCode.ESC_CUTPAPER);
		return out.toByteArray();
	}

}
