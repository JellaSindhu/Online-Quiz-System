package com.quizapp.model;

	import lombok.Data;
	import lombok.RequiredArgsConstructor;

	@Data
	@RequiredArgsConstructor
	public class Response {
	    private Integer id;
	    private String response;
		public Object getResponse() {
			// TODO Auto-generated method stub
			return null;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public void setResponse(String response) {
			this.response = response;
		}
		
	}

