package com.phone.model.dto;

public class Phone {

	private int serialNumber;
	private String model;
	private int price;
	private String description;
	@Override
	public String toString() {
		return "Phone [serialNumber=" + serialNumber + ", model=" + model + ", price=" + price + ", description="
				+ description + "]";
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Phone(int serialNumber, String model, int price, String description) {
		this.serialNumber = serialNumber;
		this.model = model;
		this.price = price;
		this.description = description;
	}
	public Phone() {
	}
	
	
}
