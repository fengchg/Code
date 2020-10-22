package com.maro.common.print.xprinter;

import java.util.Set;

import com.maro.common.print.api.Converter;
import com.maro.common.print.api.ConverterKit;
import com.maro.common.print.xprinter.convertable.FontConverter;
import com.maro.common.print.xprinter.convertable.TextConverter;
import com.maro.common.print.xprinter.printable.*;

public class WPConverterKit extends ConverterKit {

	@Override
	public void registConverter(Set<Class<? extends Converter<?>>> set) {
		set.add(BarcodeConverter.class);
		set.add(LineSpaceConverter.class);
		set.add(CutPageConverter.class);
		set.add(BlankRowConverter.class);
		set.add(KeyValueConverter.class);
		set.add(ImageConverter.class);
		set.add(LineConverter.class);
		set.add(QRcodeConverter.class);
		set.add(TextConverter.class);
		set.add(TableConverter.class);
		set.add(NolineTableConverter.class);
		set.add(SectionConverter.class);
		set.add(FontConverter.class);
	}

	@Override
	public boolean noMatchConverterException() {
		return true;
	}

}