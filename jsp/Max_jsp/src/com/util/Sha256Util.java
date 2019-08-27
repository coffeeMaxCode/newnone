package com.util;

import java.security.MessageDigest;

public class Sha256Util {
	public static String appllySha256(String user){
		try {
			// java api를 활용하여 256비트 암호화 처리
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(user.getBytes("UTF-8"));
			// 16진수로 값을 변경하여 담을 변수 선언
			StringBuffer hexString = new StringBuffer();
			for(int i=0;i<hash.length;i++) {
				/*  10진수를 16진수로 바꾸어 주는 메소드
					0xff : 10진수로 255 의미							*/
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
