package com.sh.start.bankAccount;

import java.util.Date;

public class BankAccountDTO {
	private Long account;
	private String userName;
	private Long bookNum;
	private Date accountDate;
	
	public Long getAccount() {
		return account;
	}
	public void setAccount(Long account) {
		this.account = account;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	
		//private date ACCOUNTDATE
	


}
