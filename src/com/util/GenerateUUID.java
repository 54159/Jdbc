package com.util;

import java.util.UUID;

public class GenerateUUID {
public static String getUUID() {
		
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}

	public static void main(String[] args) {
		System.out.println(GenerateUUID.getUUID());
	}
}
