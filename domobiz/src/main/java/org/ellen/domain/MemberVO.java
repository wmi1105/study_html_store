package org.ellen.domain;

import java.sql.Timestamp;

/**
 * @author Ellen
 *
 */
public class MemberVO {

	private int mno;
	private String id;
	private String password;
	private String name;
	private String email;
	private String phoneNum;

	private Timestamp REGDATE;

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Timestamp getREGDATE() {
		return REGDATE;
	}

	public void setREGDATE(Timestamp rEGDATE) {
		REGDATE = rEGDATE;
	}

	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", id=" + id + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", phoneNum=" + phoneNum + ", REGDATE=" + REGDATE + "]";
	}

	
}
