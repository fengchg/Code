package com.maro.common.print.xprinter;

import com.maro.common.print.api.BasePrinter;
import com.maro.common.print.api.Connection;
import com.maro.common.print.api.ConverterKit;
import com.maro.common.print.api.DeviceSetting;

import java.io.IOException;

/**
 * 该设备型号为WP-T630，58MM型，点位密度为 8点/mm 支持接口中的各项打印命令，支持的编码为gbk,每行可打印汉字数量为16个，英文32个
 * 
 */

public class WTPrinter extends BasePrinter {

	@Override
	protected ConverterKit generateConvert() {
		return new WPConverterKit();
	}

	@Override
	protected DeviceSetting generateDeviceSetting(String paramString) {
		return new DeviceSetting(paramString, 70 * 8, "gbk");
	}

	@Override
	protected void checkConnection(Connection connection) throws IOException {
		connection.write(ESCPOSCode.STATUS);
	}

	@Override
	protected void beforPrint(Connection connection) throws IOException {
		connection.write(ESCPOSCode.RESET);
	}

	@Override
	protected void afterPrint(Connection connection) throws IOException {
		connection.write(ESCPOSCode.BEL);
	}

}
