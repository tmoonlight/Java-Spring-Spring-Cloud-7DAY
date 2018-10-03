package com.cyyz.spt.platform.common.util;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Random;

public class SHA1Util {

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5","6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++){
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0){
			n += 256;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			if (charsetname == null || "".equals(charsetname)){
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			}	
			else{
				resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
			}
				
		} catch (Exception exception) {
				
		}
		return resultString;
	}
	
	public static String getNonce() {
		Random random = new Random();
		return encode(String.valueOf(random.nextInt(10000)), "UTF-8");
	}
	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}
	
	/**
	 * 用SHA1算法生成安全签名
	 * @param appid 账户
	 * @param timestamp 时间戳
	 * @param nonce 随机字符串
	 * @return 安全签名
	 * @throws Exception
	 */
	public static String getSHA1NoMsg(String appid, String timestamp, String nonce,String pwd) throws Exception{
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(appid).append(timestamp).append(nonce).append(pwd);
			String str = sb.toString();
			// SHA1签名生成
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 用SHA1算法生成安全签名
	 * @param appid 账户
	 * @param timestamp 时间戳
	 * @param nonce 随机字符串
	 * @param msg 签名内容 
	 * @return 安全签名
	 * @throws Exception
	 */
	public static String getSHA1(String appid, String timestamp, String nonce, String msg,String pwd) throws Exception{
		try {
			String[] array = null;
			StringBuffer sb = new StringBuffer();
			array = new String[] { appid, timestamp, nonce, msg };
			// 字符串排序
			Arrays.sort(array);
			for (int i = 0; i < 4; i++) {
				sb.append(array[i]);
			}
			sb.append(pwd);
			String str = sb.toString();
			// SHA1签名生成
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args){
		try {
			String text = getSHA1NoMsg("3100001","201806011111","adXsdfersfaafsf","ZxFZnq8JNH4ovunW4Xu67xc5PcgddYLx");
			System.out.println(text);

		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
