package com.xljt.entity;

import java.io.Serializable;

/**
 * 救援明细PO
 * @author ZX
 */
public class RescueDetailVo implements Serializable{

	private static final long serialVersionUID = 7463781086520027287L;
	/** 工单id */
	private String ticketId;
	/** 类别*/
	private String rescueType;
	/** 起始点*/
	private String rescueSite;
	/** 终点 */
	private String rescueEnd;
	/** 公里数*/
	private String kilometre;
	/** 单价*/
	private String unitPrice;
	/** 其他费用 */
	private String otherCost;
	/** 总金额*/
	private int amount;
	/** 备注*/
	private String remark;
	/** 行数*/
	private int rowId;
	
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getRescueType() {
		return rescueType;
	}
	public void setRescueType(String rescueType) {
		this.rescueType = rescueType;
	}
	public String getRescueSite() {
		return rescueSite;
	}
	public void setRescueSite(String rescueSite) {
		this.rescueSite = rescueSite;
	}
	public String getRescueEnd() {
		return rescueEnd;
	}
	public void setRescueEnd(String rescueEnd) {
		this.rescueEnd = rescueEnd;
	}
	public String getKilometre() {
		return kilometre;
	}
	public void setKilometre(String kilometre) {
		this.kilometre = kilometre;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getOtherCost() {
		return otherCost;
	}
	public void setOtherCost(String otherCost) {
		this.otherCost = otherCost;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getRowId() {
		return rowId;
	}
	public void setRowId(int rowId) {
		this.rowId = rowId;
	}
	@Override
	public String toString() {
		return "RescueDetailVo [ticketId=" + ticketId + ", rescueType=" + rescueType + ", rescueSite=" + rescueSite
				+ ", rescueEnd=" + rescueEnd + ", kilometre=" + kilometre + ", unitPrice=" + unitPrice + ", otherCost="
				+ otherCost + ", amount=" + amount + ", remark=" + remark + ", rowId=" + rowId + "]";
	}
	
}
