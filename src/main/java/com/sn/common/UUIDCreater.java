package com.sn.common;

import com.sn.controller.system.CompetenceManager;

import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.*;

public class UUIDCreater {

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	public static String test() {
		return "12312";
	}

	public static void main(String[] args) throws Exception {
	}
}