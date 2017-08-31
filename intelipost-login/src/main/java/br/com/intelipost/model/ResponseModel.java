package br.com.intelipost.model;

public class ResponseModel {

	private String message;
	private String page;
	
	public ResponseModel() {
		this.page = "login/index";
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
}
