package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Description:
 * 
 * @author MarkLin
 * @Date:2019年10月30日下午4:32:06
 * @Remarks:
 */
@XmlRootElement(name = "User")
public class User {
	private int id;
	private String userName;
	private String city;
	private List<Car> cars = new ArrayList();

	public User() {
	}

	public User(int id, String userName, String city) {
		super();
		this.id = id;
		this.userName = userName;
		this.city = city;
		this.cars = cars;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", city=" + city + ", cars=" + cars + "]";
	}

}
