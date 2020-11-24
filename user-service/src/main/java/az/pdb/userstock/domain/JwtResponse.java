package az.pdb.userstock.domain;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -399776991754800405L;
	private final String token;

	public JwtResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}
}