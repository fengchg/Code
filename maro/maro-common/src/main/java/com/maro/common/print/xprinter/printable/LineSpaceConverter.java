package com.maro.common.print.xprinter.printable;

import com.maro.common.print.api.Converter;
import com.maro.common.print.api.DeviceSetting;
import com.maro.common.print.api.content.printable.LineSpace;
import com.maro.common.print.api.exception.PrinterException;
import com.maro.common.print.xprinter.ESCPOSCode;
import com.maro.common.print.xprinter.util.BytesBuffer;

/**
 * Created by alpha on 2018-10-9.
 */
public class LineSpaceConverter extends Converter<LineSpace> {

    @Override
    public byte[] toBytes(DeviceSetting deviceSetting) throws PrinterException {
        BytesBuffer out = new BytesBuffer();
        out.write(ESCPOSCode.ESC_LINE_SPACE);
        return out.toByteArray();
    }
}
