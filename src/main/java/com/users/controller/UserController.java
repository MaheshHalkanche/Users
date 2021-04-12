package com.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.model.Users;
import com.users.service.UsersService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UsersService service;

	@PostMapping("/adduser")
	public ResponseEntity<String> addUser(@RequestBody Users users) {
		Users s = service.getUsers(users.getId());
		if (s == null) {
			service.addUsers(users);
			return new ResponseEntity<>("Success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody Users users) {
		Users s = service.getUsers(users.getId());
		if (s != null) {
			service.updateUsers(users);
			return new ResponseEntity<>("Success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getUsers{id}")
	public ResponseEntity<Users> getUser(@PathVariable int id) {
		Users s = service.getUsers(id);
		if (s != null) {
			return new ResponseEntity<Users>(s, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getUsers")
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> s = service.getUsers();
		if (s != null) {
			return new ResponseEntity<List<Users>>(s, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteUsers/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "id") int id) {
		Users s = service.getUsers(id);
		if (s != null) {
			service.deleteUsers(id);
			return new ResponseEntity<>("Success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
