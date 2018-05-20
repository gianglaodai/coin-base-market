package leo.prj.petrocoin.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leo.prj.petrocoin.bean.dto.LoginBean;
import leo.prj.petrocoin.bean.dto.UserDTO;
import leo.prj.petrocoin.db.petro_coin.petro_coin.user.User;
import leo.prj.petrocoin.db.petro_coin.petro_coin.user.UserManager;
import leo.prj.petrocoin.service.converter.UserConverter;

@Service
public class UserService {
	@Autowired
	private UserConverter userConverter;

	private Function<User, UserDTO> mapper = user -> this.userConverter.createUser(user);

	@Autowired
	private UserManager users;

	public UserDTO create(UserDTO user) {
		return this.userConverter.createUser(this.users.persist(this.userConverter.createDatabaseUser(user)));
	}

	public UserDTO update(UserDTO user) {
		return this.userConverter.createUser(this.users.update(this.userConverter.createUpdateDatabaseUser(user)));
	}

	public Optional<UserDTO> read(long id) {

		final Optional<User> foundedUser = this.users.stream().filter(User.ID.equal(id)).findFirst();
		if (foundedUser.isPresent()) {
			return Optional.of(this.userConverter.createUser(foundedUser.get()));
		}
		return Optional.empty();
	}

	public void delete(long id) {
		this.users.stream().filter(User.ID.equal(id)).forEach(this.users.remover());
	}

	public List<UserDTO> getAll() {
		return this.users.stream().map(mapper).collect(Collectors.toList());
	}

	public Optional<UserDTO> login(LoginBean loginBean) {
		return this.users.stream().filter(User.EMAIL.equal(loginBean.getEmail()))
				.filter(User.PASSWORD.equal(loginBean.getPassword())).map(mapper).findFirst();
	}

}
