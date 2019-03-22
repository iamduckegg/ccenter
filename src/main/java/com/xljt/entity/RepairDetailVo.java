package com.xljt.entity;

import java.io.Serializable;

/**
 * 维修明细PO
 * @author ZX
 */
public class RepairDetailVo implements Serializable{
	
	private static final long serialVersionUID = -5933895073822847709L;
	/**工单id*/
	private String ticketId;
	/**配件名称*/
	private String partsName;
	/**单价*/
	private String unitPrice;
	/**数量*/
	private String partsNumber;
	/**配件金额*/
	private String partsAmount;
	/**工时费*/
	private String manHourPrice;
	/**总金额*/
	private int amount;
	/**是否三包*/
	private String isFreeRepair;
	/**备注*/
	private String remark;
	/**行数*/
	private int rowId;
	
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getPartsName() {
		return partsName;
	}
	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getPartsNumber() {
		return partsNumber;
	}
	public void setPartsNumber(String partsNumber) {
		this.partsNumber = partsNumber;
	}
	public String getPartsAmount() {
		return partsAmount;
	}
	public void setPartsAmount(String partsAmount) {
		this.partsAmount = partsAmount;
	}
	public String getManHourPrice() {
		return manHourPrice;
	}
	public void setManHourPrice(String manHourPrice) {
		this.manHourPrice = manHourPrice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getIsFreeRepair() {
		return isFreeRepair;
	}
	public void setIsFreeRepair(String isFreeRepair) {
		this.isFreeRepair = isFreeRepair;
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
		return "RepairDetailVo [ticketId=" + ticketId + ", partsName=" + partsName + ", unitPrice=" + unitPrice
				+ ", partsNumber=" + partsNumber + ", partsAmount=" + partsAmount + ", manHourPrice=" + manHourPrice
				+ ", amount=" + amount + ", isFreeRepair=" + isFreeRepair + ", remark=" + remark + ", rowId=" + rowId
				+ "]";
	}
}
