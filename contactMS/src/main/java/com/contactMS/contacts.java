package com.contactMS;

public class contacts {

	private Long cid;
	private String cname;
	private String email;
	private Long id;
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public contacts(Long cid, String cname, String email, Long id) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.id = id;
	}
	
}
