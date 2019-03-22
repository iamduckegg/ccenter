package com.xljt.entity;

import java.io.Serializable;

/**
 * 车辆信息PO
 * @author ZX
 */
public class CallCar implements	Serializable{
	
	private static final long serialVersionUID = 7277034760295074936L;
	/**主键*/
	private int id;
	/** 车牌号 */
	private String callNumber;
	/** 车架号 */
	private String vin;
	/** 发动机编号 */
	private String engineNumber;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCallNumber() {
		return callNumber;
	}
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getEngineNumber() {
		return engineNumber;
	}
	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}
	
}
