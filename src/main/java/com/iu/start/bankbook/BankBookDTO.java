package com.iu.start.bankbook;

public class BankBookDTO {
	private long BOOKNUM;
	private String BOOKNAME;
	private double BOOKRATE;
	private int BOOKSALE;
	
	public long getBOOKNUM() {
		return BOOKNUM;
	}
	public void setBOOKNUM(long bOOKNUM) {
		BOOKNUM = bOOKNUM;
	}
	public String getBOOKNAME() {
		return BOOKNAME;
	}
	public void setBOOKNAME(String bOOKNAME) {
		BOOKNAME = bOOKNAME;
	}
	public double getBOOKRATE() {
		return BOOKRATE;
	}
	public void setBOOKRATE(double bOOKRATE) {
		BOOKRATE = bOOKRATE;
	}
	public int getBOOKSALE() {
		return BOOKSALE;
	}
	public void setBOOKSALE(int bOOKSALE) {
		BOOKSALE = bOOKSALE;
	}

	
}
