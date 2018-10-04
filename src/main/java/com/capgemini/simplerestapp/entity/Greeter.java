package com.capgemini.simplerestapp.entity;

public class Greeter {

	private String title;
	private String message;

	public Greeter() {
		super();
	}

	public Greeter(String title, String message) {
		super();
		this.title = title;
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Greeter [title=" + title + ", message=" + message + "]";
	}

}
