package com.xljt.entity;

/**
 * 库存记录表
 * @author ZX
 */
public class MInventoryHisEntity {
	
	private int inventoryId;    //库存记录id
	private String carNumber;      //车牌号
	private String inventoryState; //库存状态变更类型
	private String updateDate;     //库存状态变更日期
	private String beforeUser;     //库存状态变更前所属
	private String afterUser;      //库存状态变更后所属
	
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getInventoryState() {
		return inventoryState;
	}
	public void setInventoryState(String inventoryState) {
		this.inventoryState = inventoryState;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getBeforeUser() {
		return beforeUser;
	}
	public void setBeforeUser(String beforeUser) {
		this.beforeUser = beforeUser;
	}
	public String getAfterUser() {
		return afterUser;
	}
	public void setAfterUser(String afterUser) {
		this.afterUser = afterUser;
	}
	
	
}
