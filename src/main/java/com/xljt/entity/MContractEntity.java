package com.xljt.entity;

public class MContractEntity {

	private int contractId;                //合同id
	private String contractNum;               //合同编号
	private String contractType;              //合同类型
	private String clientId;                  //甲方(客户id)
	private String clientContacterId;         //联系人id
	private String secondParty;               //乙方
	private String secondPartyContacterName;  //乙方联系人姓名
	private String secondPartyContacterPhone; //乙方联系方式
	private String signatureDate;             //签订日期
	private String startDate;                 //生效日期
	private String endDate;                   //截止日期
	private int money;                     //合同金额
	private int prepayMoney;               //合同预付款
	private int cashPledge;                //押金金额
	private String paymentMethod;             //付款方式
	private String createDate;                //创建时间
	private String updateDate;                //修改时间
	
	public int getContractId() {
		return contractId;
	}
	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
	public String getContractNum() {
		return contractNum;
	}
	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientContacterId() {
		return clientContacterId;
	}
	public void setClientContacterId(String clientContacterId) {
		this.clientContacterId = clientContacterId;
	}
	public String getSecondParty() {
		return secondParty;
	}
	public void setSecondParty(String secondParty) {
		this.secondParty = secondParty;
	}
	public String getSecondPartyContacterName() {
		return secondPartyContacterName;
	}
	public void setSecondPartyContacterName(String secondPartyContacterName) {
		this.secondPartyContacterName = secondPartyContacterName;
	}
	public String getSecondPartyContacterPhone() {
		return secondPartyContacterPhone;
	}
	public void setSecondPartyContacterPhone(String secondPartyContacterPhone) {
		this.secondPartyContacterPhone = secondPartyContacterPhone;
	}
	public String getSignatureDate() {
		return signatureDate;
	}
	public void setSignatureDate(String signatureDate) {
		this.signatureDate = signatureDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getPrepayMoney() {
		return prepayMoney;
	}
	public void setPrepayMoney(int prepayMoney) {
		this.prepayMoney = prepayMoney;
	}
	public int getCashPledge() {
		return cashPledge;
	}
	public void setCashPledge(int cashPledge) {
		this.cashPledge = cashPledge;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
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
