package com.xljt.entity;

import java.io.Serializable;

/**
 * 基础信息表PO
 * @author ZX
 */
public class CallBasicVo implements Serializable{

	private static final long serialVersionUID = 2548804377404976268L;
	/** 工单id */
	private String ticketId;
	/** 工单编号*/
	private String ticketNum;
	/** 客户名称*/
	private String clientName;
	/** 联系电话*/
	private String phone;
	/** 车牌号*/
	private String carNumber;
	/** 车型*/
	private String carType;
	/** 行驶里程*/
	private String mileage;
	/** 故障地点 */
	private String faultSite;
	/** 故障类型 */
	private String faultType;
	/** 报修时间 */
	private String callDate;
	/** 故障描述*/
	private String faultDescribe;
	/** 客户要求 */
	private String clientClaim;
	/** 处理结果*/
	private String disposeResult;
	/** 修复意见*/
	private String opinion;
	/** 验收结果*/
	private String checkResult;
	/** 创建时间*/
	private String createDate;
	/** 更新时间*/
	private String updateDate;
	/** 工单状态*/
	private String ticketStatus;
	/** 标题*/
	private String subject;
	/** 优先级*/
	private String priorityLevel;
	/** 客服id*/
	private String servicerUserId;
	/** 工单模板id*/
	private String ticketTemplateId;
	/**	开始日期 */
	private String startDate;
	/**	结束日期 */
	private String endDate;
	
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getFaultSite() {
		return faultSite;
	}
	public void setFaultSite(String faultSite) {
		this.faultSite = faultSite;
	}
	public String getFaultType() {
		return faultType;
	}
	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}
	public String getCallDate() {
		return callDate;
	}
	public void setCallDate(String callDate) {
		this.callDate = callDate;
	}
	public String getFaultDescribe() {
		return faultDescribe;
	}
	public void setFaultDescribe(String faultDescribe) {
		this.faultDescribe = faultDescribe;
	}
	public String getClientClaim() {
		return clientClaim;
	}
	public void setClientClaim(String clientClaim) {
		this.clientClaim = clientClaim;
	}
	public String getDisposeResult() {
		return disposeResult;
	}
	public void setDisposeResult(String disposeResult) {
		this.disposeResult = disposeResult;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
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
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPriorityLevel() {
		return priorityLevel;
	}
	public void setPriorityLevel(String priorityLevel) {
		this.priorityLevel = priorityLevel;
	}
	public String getServicerUserId() {
		return servicerUserId;
	}
	public void setServicerUserId(String servicerUserId) {
		this.servicerUserId = servicerUserId;
	}
	public String getTicketTemplateId() {
		return ticketTemplateId;
	}
	public void setTicketTemplateId(String ticketTemplateId) {
		this.ticketTemplateId = ticketTemplateId;
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

}
