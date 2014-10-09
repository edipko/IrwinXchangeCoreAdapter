package com.spotonresponse.beans;

public class IrwinToken {
	private String token;
	private long expires;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getExpires() {
		return expires;
	}

	public void setExpires(long expires) {
		this.expires = expires;
	}

}
