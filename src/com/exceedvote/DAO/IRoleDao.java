package com.exceedvote.DAO;

import com.exceedvote.jpa.Role;

public interface IRoleDao {
	public void save(Role role);
	public Role[] findAll();
	public Role findRole(String name);
}
