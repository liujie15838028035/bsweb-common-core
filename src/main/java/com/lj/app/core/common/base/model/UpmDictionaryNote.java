package com.lj.app.core.common.base.model;


public class UpmDictionaryNote extends BaseModel{
	
	private java.lang.Integer id;
	private String typeCode;
	private String typeDesc;

	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setTypeCode(String value) {
		this.typeCode = value;
	}
	
	public String getTypeCode() {
		return this.typeCode;
	}
	public void setTypeDesc(String value) {
		this.typeDesc = value;
	}
	
	public String getTypeDesc() {
		return this.typeDesc;
	}
}
