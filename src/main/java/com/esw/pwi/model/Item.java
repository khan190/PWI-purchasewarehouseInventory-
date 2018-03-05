package com.esw.pwi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item { 
	private Integer itemId;
	private Integer warehouseId;
	private Integer brandId;
	private String itemName;
	private String itemType;
	private Long inStockQty;
	private Long availableQty;
	private Long inTransitQty;
	private Long moq;
	private Long qpb;
	private Long reorderPoint;
	private Date createDate;
	private Date updateDate;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itemId")
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	@Column(name = "warehouseId")
	public Integer getWarehouseId() {
		return warehouseId;
	}
	
	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}
	
	@Column(name = "brandId")
	public Integer getBrandId() {
		return brandId;
	}
	
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	
	@Column(name = "itemName")
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	@Column(name = "itemType")
	public String getItemType() {
		return itemType;
	}
	
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	@Column(name = "inStockQty")
	public Long getInStockQty() {
		return inStockQty;
	}
	
	public void setInStockQty(Long inStockQty) {
		this.inStockQty = inStockQty;
	}
	
	@Column(name = "availableQty")
	public Long getAvailableQty() {
		return availableQty;
	}
	
	public void setAvailableQty(Long availableQty) {
		this.availableQty = availableQty;
	}
	
	@Column(name = "inTransitQty")
	public Long getInTransitQty() {
		return inTransitQty;
	}
	
	public void setInTransitQty(Long inTransitQty) {
		this.inTransitQty = inTransitQty;
	}
	
	@Column(name = "moq")
	public Long getMoq() {
		return moq;
	}
	
	public void setMoq(Long moq) {
		this.moq = moq;
	}
	
	@Column(name = "qpb")
	public Long getQpb() {
		return qpb;
	}
	
	public void setQpb(Long qpb) {
		this.qpb = qpb;
	}
	
	@Column(name = "reorderPoint")
	public Long getReorderPoint() {
		return reorderPoint;
	}
	
	public void setReorderPoint(Long reorderPoint) {
		this.reorderPoint = reorderPoint;
	}
	
	@Column(name = "createDate")
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Column(name = "updateDate")
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
}
