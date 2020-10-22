package com.maro.common.print.api;

import com.maro.common.print.api.content.Doucument;
import com.maro.common.print.api.exception.PrinterException;

public interface IPrinter {

	public void print(Doucument content) throws PrinterException;

}
