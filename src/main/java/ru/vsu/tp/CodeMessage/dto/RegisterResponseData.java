package ru.vsu.tp.CodeMessage.dto;

public class RegisterResponseData {

	private String message;

	public RegisterResponseData() {
	}

	private RegisterResponseData(String message) {
		this.message = message;
	}

	public static RegisterResponseData ok() {
		return new RegisterResponseData("OK");
	}

	public static RegisterResponseData fromException(IllegalArgumentException e) {
		return new RegisterResponseData(e.getMessage());
	}

	public String getMessage() {
		return message;
	}
}
