package com.maro.common.print.xprinter.printable;

import com.maro.common.print.api.Converter;
import com.maro.common.print.api.DeviceSetting;
import com.maro.common.print.api.content.printable.BlankRow;
import com.maro.common.print.xprinter.ESCPOSCode;

/**
 * 空行转换器
 */
public class BlankRowConverter extends Converter<BlankRow> {

	@Override
	public byte[] toBytes(DeviceSetting deviceSetting) {
		return ESCPOSCode.ESC_FORWARD_LINE(getConvertable().getLineNumber());
	}

}
