package com.cts.model;

import java.sql.Date;

public class Medicine {
private int id;
private String name;
private String type;
private String unitValue;
private String unit;
private int unitPrice;
private Date expDate;
private String stockStatus;

public Medicine() {
	super();
}

public Medicine(int id, String name, String type, String unitValue, String unit, int unitPrice, Date expDate,
		String stockStatus) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.unitValue = unitValue;
	this.unit = unit;
	this.unitPrice = unitPrice;
	this.expDate = expDate;
	this.stockStatus = stockStatus;
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getUnitValue() {
	return unitValue;
}
public void setUnitValue(String unitValue) {
	this.unitValue = unitValue;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public int getUnitPrice() {
	return unitPrice;
}
public void setUnitPrice(int unitPrice) {
	this.unitPrice = unitPrice;
}
public Date getExpDate() {
	return expDate;
}
public void setExpDate(Date expDate) {
	this.expDate = expDate;
}
public String getStockStatus() {
	return stockStatus;
}
public void setStockStatus(String stockStatus) {
	this.stockStatus = stockStatus;
}


}
