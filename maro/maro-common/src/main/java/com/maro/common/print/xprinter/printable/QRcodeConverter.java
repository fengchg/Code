package com.maro.common.print.xprinter.printable;

import com.maro.common.print.api.Converter;
import com.maro.common.print.api.DeviceSetting;
import com.maro.common.print.api.content.printable.Image;
import com.maro.common.print.api.content.printable.QRcode;
import com.maro.common.print.api.exception.PrinterException;
import com.maro.common.print.xprinter.util.BytesBuffer;
import com.maro.common.print.xprinter.util.ImageCreater;

/**
 * 二维码转换器
 */
public class QRcodeConverter extends Converter<QRcode> {

	@Override
	public byte[] toBytes(DeviceSetting deviceSetting) throws PrinterException {

		String content = getConvertable().getContent();
		int marginTop = getConvertable().getMarginTop();
		int marginBottom = getConvertable().getMarginBottom();
		int width = getConvertable().getWidth();
		if (0 == width) {
			width = deviceSetting.getDrawablePixel();
		}

		Image image = ImageCreater.creatQRcodeImage(content, width);
		image.setMarginTop(marginTop);
		image.setMarginBottom(marginBottom);

		BytesBuffer out = new BytesBuffer();
		out.write(getConverterKit().fromConverter(image, deviceSetting)); // 该指令有打印功能
		return out.toByteArray();

	}
}
