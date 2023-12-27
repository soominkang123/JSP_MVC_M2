package users;

import lombok.Data;

@Data
public class UsersDTO { // 제일먼저 테이블을 만들어야함
	
	private String id ;
	private String password;
	private String name;
	private String role;

}
