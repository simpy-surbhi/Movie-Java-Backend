package com.ezshare.MovieAPI.DTO;

public class TokenDTO {
	
	private String access_token;
	private String expires_in;
	private String refresh_expires_in;
	private String refresh_token;
	private String token_type;
	private String id_token;
	private String session_state;
	
	public TokenDTO() {
		// TODO Auto-generated constructor stub
	}

	public TokenDTO(String access_token, String expires_in, String refresh_expires_in, String refresh_token,
			String token_type, String id_token, String session_state) {
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.refresh_expires_in = refresh_expires_in;
		this.refresh_token = refresh_token;
		this.token_type = token_type;
		this.id_token = id_token;
		this.session_state = session_state;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_expires_in() {
		return refresh_expires_in;
	}

	public void setRefresh_expires_in(String refresh_expires_in) {
		this.refresh_expires_in = refresh_expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getId_token() {
		return id_token;
	}

	public void setId_token(String id_token) {
		this.id_token = id_token;
	}

	public String getSession_state() {
		return session_state;
	}

	public void setSession_state(String session_state) {
		this.session_state = session_state;
	}
}
