package com.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.model.Users;
import com.users.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	@Override
	public Users addUsers(Users users) {
		// TODO Auto-generated method stub
		return usersRepository.save(users);
	}

	@Override
	public Users getUsers(int id) {
		// TODO Auto-generated method stub
		Optional<Users> t = usersRepository.findById(id);
		if(t.isPresent()) {
			return t.get();
		}
		return null;
	}

	@Override
	public Users updateUsers(Users tasks) {
		// TODO Auto-generated method stub
		return  usersRepository.save(tasks);
	}

	@Override
	public void deleteUsers(int id) {
		// TODO Auto-generated method stub
		usersRepository.deleteById(id);
		
	}

	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

}
