package leo.prj.petrocoin.service.converter;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Component;

import leo.prj.petrocoin.bean.dto.UserDTO;
import leo.prj.petrocoin.common.CommonConstant;
import leo.prj.petrocoin.db.petro_coin.petro_coin.user.User;
import leo.prj.petrocoin.db.petro_coin.petro_coin.user.UserImpl;

@Component
public class UserConverter {
	public User createDatabaseUser(UserDTO user) {
		return new UserImpl().setBankAccount(user.getBankAccount()).setBankAccountName(user.getBankAccountName())
				.setBankCode(user.getBankCode()).setBankName(user.getBankName())
				.setCreatedDate(new Timestamp(user.getCreatedDate().getTime())).setFullName(user.getFullName())
				.setIsActive(user.isActive() ? 1 : 0).setIsDelete(user.isDelete() ? 1 : 0).setMobile(user.getMobile())
				.setNation(user.getNation()).setPassword(user.getPassword()).setPhone(user.getPhone())
				.setUpdatedDate(new Timestamp(user.getUpdatedDate().getTime()));
	}

	public User createUpdateDatabaseUser(leo.prj.petrocoin.bean.dto.UserDTO user) {
		return this.createDatabaseUser(user).setId(user.getId());
	}

	public UserDTO createUser(User user) {
		final UserDTO userBean = new UserDTO();
		userBean.setActive(user.getIsActive().getAsInt() == 0 ? false : true);
		userBean.setBankAccount(user.getBankAccount().orElse(CommonConstant.EMPTY));
		userBean.setBankAccountName(user.getBankAccountName().orElse(CommonConstant.EMPTY));
		userBean.setBankCode(user.getBankCode().orElse(CommonConstant.EMPTY));
		userBean.setBankName(user.getBankName().orElse(CommonConstant.EMPTY));
		userBean.setCreatedDate(user.getCreatedDate().orElse(new Timestamp(new Date().getTime())));
		userBean.setDelete(user.getIsDelete().getAsInt() == 0 ? false : true);
		userBean.setEmail(user.getEmail().orElse(CommonConstant.EMPTY));
		userBean.setFullName(user.getFullName().orElse(CommonConstant.EMPTY));
		userBean.setId(user.getId());
		userBean.setMobile(user.getMobile().orElse(CommonConstant.EMPTY));
		userBean.setNation(user.getNation().orElse(CommonConstant.EMPTY));
		userBean.setPassword(user.getPassword().orElse(CommonConstant.EMPTY));
		userBean.setPhone(user.getPhone().orElse(CommonConstant.EMPTY));
		userBean.setUpdatedDate(user.getUpdatedDate().orElse(new Timestamp(new Date().getTime())));
		return userBean;
	}
}
