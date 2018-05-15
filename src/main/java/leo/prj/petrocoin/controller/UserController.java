package leo.prj.petrocoin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.petro_coin.petro_coin.petro_coin.user.UserImpl;
import com.company.petro_coin.petro_coin.petro_coin.user.UserManager;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserManager users;

	@PostMapping("/create")
	public String createUser() {
		users.persist(new UserImpl().setId(1).setFullName("giang"));
		return "Create success";
	}
}
