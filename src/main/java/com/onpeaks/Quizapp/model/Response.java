package com.onpeaks.Quizapp.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Response {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	private int id;
	private String response;
	@Override
	public String toString() {
		return "Response [id=" + id + ", response=" + response + "]";
	}
	public Response(int id, String response) {
		super();
		this.id = id;
		this.response = response;
	}
} 
