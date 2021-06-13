package ai.vijai.iam.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.vijai.iam.domain.BeneficiaryUserSDO;
import ai.vijai.iam.entity.User;
import ai.vijai.iam.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService  userService;
	
	@GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/user/payee/{id}")
	public BeneficiaryUserSDO getUserPayee(@PathVariable Long id) {
		return userService.getUserWithPayee(id);
	}
}
