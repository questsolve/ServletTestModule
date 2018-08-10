package com.kosmo.member;

public class MemberVO {

	private int memberSeq;
	private String id;
	private String pw;
	private String name;
	private String roll;
	private String regdate;
	
	public MemberVO() {
		System.out.println(this.getClass().getSimpleName()+" Created");
	}
	
	
	
	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}



	@Override
	public String toString() {
		return "MemberVO [memberSeq=" + memberSeq + ", id=" + id + ", pw=" + pw + ", name=" + name + ", roll=" + roll
				+ ", regdate=" + regdate + "]";
	}

	

}
