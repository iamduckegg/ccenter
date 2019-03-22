package com.xljt.entity;

/**
 * 合同管理字典表
 * @author ZX
 */
public class MDicEntity {
	
	private int id;         //主键
	private String columnId;   //字段id
	private String columnName; //字段名称
	private String codeId;     //编码id
	private String codeName;   //编码名称
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColumnId() {
		return columnId;
	}
	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getCodeId() {
		return codeId;
	}
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	
}
