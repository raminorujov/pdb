package az.pdb.userstock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest implements Serializable {
	private static final long serialVersionUID = -2513211736883510318L;
	private String username;
	private String password;
}