package Member2;

import java.sql.Date;

import lombok.Data;
@Data
public class Member2DTO {

	
	
	private String id;
	private String password;
	private String phone;
	private String email;
	private Date regdate;
	private String addr;
	private String role;

	
}
