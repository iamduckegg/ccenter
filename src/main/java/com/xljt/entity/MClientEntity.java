package com.xljt.entity;

import java.io.Serializable;

/**
 * 客户表
 * @author ZX
 */
public class MClientEntity implements Serializable {
	
	private static final long serialVersionUID = -3450600800658796648L;
	private int clientId;   //客户id
	private String clientName; //客户名称
	private String clientNum;  //编号
	private String site;        //地址
	private String clientType; //客户类型
	private String cardNum;    //证件号码
	private String createDate; //创建时间
	private String updateDate; //修改时间
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientNum() {
		return clientNum;
	}
	public void setClientNum(String clientNum) {
		this.clientNum = clientNum;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
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
