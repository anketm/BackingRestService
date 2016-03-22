package com.example.bean;

public class Response {
	String responseCode;
	String response;
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "Response [responseCode=" + responseCode + ", response=" + response + "]";
	}	
}
