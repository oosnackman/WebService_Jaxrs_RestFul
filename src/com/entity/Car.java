package com.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Description:
 * 
 * @author MarkLin
 * @Date:2019年10月31日下午2:36:51
 * @Remarks:
 */
@XmlRootElement(name = "Car")
public class Car {

	private int id;
	private String brand;
	private Double price;

	public Car() {

	}
	

	public Car(int id, String brand, Double price) {
	
		this.id = id;
		this.brand = brand;
		this.price = price;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", price=" + price + "]";
	}

}
