package com.yc.hilo.util;

import com.yc.hilo.biz.BizException;

public class Utils {
	public static void checkNull(Object value,String msg) throws BizException {
		if(value == null ) {
			throw new BizException(msg);
		}
		if( value instanceof String ) {
			String svalue = (String)value;
			if(svalue.trim().isEmpty()) {
				throw new BizException(msg);
			}
		}
	}
}
