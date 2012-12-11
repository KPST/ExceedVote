package com.exceedvote.DAO;

import com.exceedvote.entity.Role;

public interface IRoleDao {
	public void save(Role role);
	public Role[] findAll();
	public Role findRole(int id);
	public Role findRole(String name);
	public void delete(int id);
	public Role[] findNormalRole();
}
