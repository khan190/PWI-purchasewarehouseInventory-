package com.esw.pwi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_attribute")
public class ItemAttribute { 
	private Integer attributeId;
	private Integer itemId;
	private String attributeName;
	private String attributeValue;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attributeId")
	public Integer getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}
	
	@Column(name = "itemId")
	public Integer getItemId() {
		return itemId;
	}
	
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	@Column(name = "attributeName")
	public String getAttributeName() {
		return attributeName;
	}
	
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	
	@Column(name = "attributeValue")
	public String getAttributeValue() {
		return attributeValue;
	}
	
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}		
	
}
