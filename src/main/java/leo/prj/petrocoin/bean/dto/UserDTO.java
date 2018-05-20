package leo.prj.petrocoin.bean.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import leo.prj.petrocoin.common.CommonConstant;

public class UserDTO {
	private long id;
	private String mobile;
	private String bankCode;
	private String fullName;
	private String password;
	private String email;
	private String phone;
	private String nation;
	private boolean isActive;
	private boolean isDelete;
	private String bankName;
	private String bankAccount;
	private String bankAccountName;

	private Date createdDate;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date updatedDate;

	public UserDTO() {
		this.id = -1;
		this.mobile = CommonConstant.EMPTY;
		this.bankCode = CommonConstant.EMPTY;
		this.fullName = CommonConstant.EMPTY;
		this.password = CommonConstant.EMPTY;
		this.email = CommonConstant.EMPTY;
		this.phone = CommonConstant.EMPTY;
		this.nation = CommonConstant.EMPTY;
		this.isActive = false;
		this.isDelete = false;
		this.bankName = CommonConstant.EMPTY;
		this.bankAccount = CommonConstant.EMPTY;
		this.bankAccountName = CommonConstant.EMPTY;
		this.createdDate = new Date();
		this.updatedDate = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public long getCreatedDate() {
		return createdDate.getTime();
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getUpdatedDate() {
		return updatedDate.getTime();
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
