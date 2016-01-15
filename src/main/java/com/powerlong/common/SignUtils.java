package com.powerlong.common;

import sun.misc.BASE64Encoder;

import java.util.Arrays;
import java.util.Random;

public class SignUtils {
	
	
	public static String genRandomNum(int pwd_len) {
		final int maxNum = 36;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，

			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}
	
	
	/**
	 * 对签名字符串数组排序
	 * @param str
	 * @return
	 */
	public static String sort(String[] str) {
		String mystr = "";
		Arrays.sort(str);
		for (String s : str) {
			mystr += s;
		}
		return mystr;
	}
	
	
	/**
	 * 生成数字签名
	 * @param time
	 * @param nonce
	 * @return
	 */
	public static String generateSign(String time,String nonce){
		
		String key = SystemSetting.getInstance().getKey();
		
		String signing = key+","+time+","+nonce;
		
		String[] strArry = signing.split(",");
		
		signing = sort(strArry);
		
		BASE64Encoder base64 = new BASE64Encoder();

		//String sign = base64.encode(SHA1.getHmacSHA1(signing, key));//数字加密签名
		
		return null;
		
	}

}
