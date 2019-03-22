package com.xljt.entity;

import java.io.Serializable;

/**
 * 维修信息表PO
 * @author ZX
 */
public class CallServicerVo implements Serializable{

	private static final long serialVersionUID = -1393183161067626871L;
	/** 工单id*/
	private String ticketId;
	/** 派单人*/
	private String servicerUserId;
	/** 派修日期*/
	private String beginRepairDate;
	/** 修理日期*/
	private String finishRepairDate;
	/** 维修人员*/
	private String repairUserName;
	/** 维修地点*/
	private String repairSite;
	/** 维修单位*/
	private String repairCompany;
	/** 故障检测*/
	private String faultDetection;
	
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getServiceUserId() {
		return servicerUserId;
	}
	public void setServiceUserId(String serviceUserId) {
		this.servicerUserId = serviceUserId;
	}
	public String getBeginRepairDate() {
		return beginRepairDate;
	}
	public void setBeginRepairDate(String beginRepairDate) {
		this.beginRepairDate = beginRepairDate;
	}
	public String getFinishRepairDate() {
		return finishRepairDate;
	}
	public void setFinishRepairDate(String finishRepairDate) {
		this.finishRepairDate = finishRepairDate;
	}
	public String getRepairUserName() {
		return repairUserName;
	}
	public void setRepairUserName(String repairUserName) {
		this.repairUserName = repairUserName;
	}
	public String getRepairSite() {
		return repairSite;
	}
	public void setRepairSite(String repairSite) {
		this.repairSite = repairSite;
	}
	public String getRepairCompany() {
		return repairCompany;
	}
	public void setRepairCompany(String repairCompany) {
		this.repairCompany = repairCompany;
	}
	public String getFaultDetection() {
		return faultDetection;
	}
	public void setFaultDetection(String faultDetection) {
		this.faultDetection = faultDetection;
	}

}
