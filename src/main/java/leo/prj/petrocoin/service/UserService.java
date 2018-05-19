package leo.prj.petrocoin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leo.prj.petrocoin.bean.dto.UserDTO;
import leo.prj.petrocoin.db.petro_coin.petro_coin.user.User;
import leo.prj.petrocoin.db.petro_coin.petro_coin.user.UserManager;
import leo.prj.petrocoin.service.converter.UserConverter;

@Service
public class UserService {
	@Autowired
	private UserConverter userConverter;

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
}
