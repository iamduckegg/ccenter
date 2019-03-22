package com.xljt.entity;

import java.io.Serializable;

/**
 * 字典表PO 
 * @author ZX
 */
public class DicVo implements Serializable{
	
	private static final long serialVersionUID = 6836501218485418822L;
	/**主键*/
	private int id;
	/** 编码 */
	private String code;
	/** 编码名称 */
	private String codeName;
	/** 编码类别 */
	private String codeType;
	/** 类别名称 */
	private String typeName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
