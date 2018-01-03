package com.jack.test;

import java.io.File;
import java.io.IOException;

import com.jack.test.util.Utils;

public abstract class BaseTest {
	private String description;
	protected static void log(Object msg) {
		System.out.println(msg);
	}
	protected static void logError(Object msg) {
		System.err.println(msg);
	}
	protected static String readText(File file) throws IOException{
		return Utils.readText(file);
	}
	public String getDescription() {
		return description;
	}
	void setDescription(String description) {
		this.description = description;
	}
}
