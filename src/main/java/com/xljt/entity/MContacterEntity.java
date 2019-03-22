package com.xljt.entity;

/**
 * 联系人表
 * @author ZX
 */
public class MContacterEntity {
	
	private String contacterId;    //联系人id
	private String contacterName;  //联系人姓名
	private String phone;           //电话
	private String site;            //地址
	private String email;           //邮箱
	private String createDate;     //创建时间
	private String updateDate;     //修改时间
	public String getContacterId() {
		return contacterId;
	}
	public void setContacterId(String contacterId) {
		this.contacterId = contacterId;
	}
	public String getContacterName() {
		return contacterName;
	}
	public void setContacterName(String contacterName) {
		this.contacterName = contacterName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
}
