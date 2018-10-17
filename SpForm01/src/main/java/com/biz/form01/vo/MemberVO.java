/**
 * 
 */
/**
 * @author callor
 *
 */
package com.biz.form01.vo;

// VO : Value Object
// DTO : Data Transfer Object
// DO : Data Object
public class MemberVO {
	
	private String username ;
	private String telno ;
	private String addr ;
	private String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "MemberVO [username=" + username + ", telno=" + telno + ", addr=" + addr + ", email=" + email + "]";
	}
	
	
	
	
	
}