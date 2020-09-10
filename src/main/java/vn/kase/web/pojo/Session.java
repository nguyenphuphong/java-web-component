package vn.kase.web.pojo;

public class Session {
	private String email;
	private Integer roleId;

	public boolean isAdministrator() {
		return roleId == 5;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
