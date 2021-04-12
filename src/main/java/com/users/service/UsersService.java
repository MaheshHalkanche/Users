package com.users.service;

import java.util.List;

import com.users.model.Users;

public interface UsersService {
	public Users addUsers(Users users);
	public Users getUsers(int id);
	public Users updateUsers(Users users);
	public void deleteUsers(int id);
	public List<Users> getUsers();
}
