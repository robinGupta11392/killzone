package com.mycompany.web.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtils {
	// protected Logger log = Logger.getLogger(LogUtils.class.getName());

	public void print(String message) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.S");
		System.out.println(sdf.format(date) + "	: " + message);
	}

}
