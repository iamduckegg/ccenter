package com.xljt.common;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * 认证信息
 * @author ZX
 */
public class Basic {
	
	public static String LISTURL = "https://www.bangwo8.com/api/v1/tickets.json?updated_order=desc&per_page=100";
	public static String DETAILURL = "https://www.bangwo8.com/api/v1/tickets/2751235_v2.json ";
	
	private static String user = "xlzenith";
	private static String password = "XLJT@2106";
	private static String authString = user + ":" + password;
	private static byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
	private String authStringEnc = new String(authEncBytes);
	
	public String getAuthStringEnc() {
		return authStringEnc;
	}
	public void setAuthStringEnc(String authStringEnc) {
		this.authStringEnc = authStringEnc;
	}
    
	
}
