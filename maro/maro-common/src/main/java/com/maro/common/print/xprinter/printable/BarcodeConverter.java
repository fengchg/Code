package com.maro.common.print.xprinter.printable;

import com.maro.common.print.api.Converter;
import com.maro.common.print.api.DeviceSetting;
import com.maro.common.print.api.content.printable.Barcode;
import com.maro.common.print.api.content.printable.Image;
import com.maro.common.print.api.exception.PrinterException;
import com.maro.common.print.xprinter.WPConsts;
import com.maro.common.print.xprinter.util.BytesBuffer;
import com.maro.common.print.xprinter.util.ImageCreater;

/**
 * 条形码转换器
 */
public class BarcodeConverter extends Converter<Barcode> {

	@Override
	public byte[] toBytes(DeviceSetting deviceSetting) throws PrinterException {

		String content = getConvertable().getContent();
		int marginTop = getConvertable().getMarginTop();
		int marginBottom = getConvertable().getMarginBottom();
		int height = getConvertable().getHeight();
		if (0 == height) {
			height = WPConsts.DEFAULT_BARCODE_HEIGHT;
		}

		Image image = ImageCreater.creatBarcodeImage(deviceSetting.getDrawablePixel(), height, content);
		image.setMarginTop(marginTop);
		image.setMarginBottom(marginBottom);

		BytesBuffer out = new BytesBuffer();
		out.write(getConverterKit().fromConverter(image, deviceSetting));
		return out.toByteArray();
	}
}
