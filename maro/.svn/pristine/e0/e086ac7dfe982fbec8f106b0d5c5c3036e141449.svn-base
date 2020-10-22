package com.maro.common.print.xprinter.printable;

import com.maro.common.print.api.Converter;
import com.maro.common.print.api.DeviceSetting;
import com.maro.common.print.api.content.printable.Image;
import com.maro.common.print.api.content.printable.Line;
import com.maro.common.print.api.exception.PrinterException;
import com.maro.common.print.xprinter.util.BytesBuffer;
import com.maro.common.print.xprinter.util.ImageCreater;

/**
 * 横线转换器
 */
public class LineConverter extends Converter<Line> {

	@Override
	public byte[] toBytes(DeviceSetting deviceSetting) throws PrinterException {

		int width = deviceSetting.getDrawablePixel();
		int hegiht = getConvertable().getHeight();
		boolean dotted = getConvertable().isDotted();

		Image image = ImageCreater.createLine(width, hegiht, dotted);
		image.setMarginTop(0);
		image.setMarginBottom(5*8);

		BytesBuffer out = new BytesBuffer();
		out.write(getConverterKit().fromConverter(image, deviceSetting));
		return out.toByteArray();

	}
}
