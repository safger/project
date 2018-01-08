package com.sn.common;

import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UUIDCreater {

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	public static String test() {
		return "12312";
	}

	public static void main(String[] args) throws Exception {
		System.out.println(TimeUtils.addDay(new Date(),1));
	}
}