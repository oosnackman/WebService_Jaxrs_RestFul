package com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.entity.Car;
import com.entity.User;

/**
 * Description:
 * 
 * @author MarkLin
 * @Date:2019年10月31日下午3:22:55
 * @Remarks:
 */

public class UserServiceImpl implements IUserService {

	private User User1;
	private User User2;
	private User User3;
	private User User4;
	private Map db;
	private List<User> listUsers;
	{
		// 這邊就演示WebService , 就不連資料庫 , 建立假資料
		db = new HashMap<Integer, User>();
		listUsers=new ArrayList<User>();
		Car car1 = new Car(2001, "BMW", 1500000.0);
		Car car2 = new Car(2003, "Mercedes Benz", 1200000.0);
		Car car3 = new Car(2004, "BMWX5", 4000000.0);
		Car car4 = new Car(2005, "G-Class", 2000000.0);
		Car car5 = new Car(2006, "Toyota", 60000.0);
		Car car6 = new Car(2007, "Mazda", 800000.0);
		Car car7 = new Car(2008, "Lexus", 1000000.0);

		User1 = new User(1, "柯文哲", "台北");
		List<Car> cars1 = new ArrayList<Car>();
		cars1.add(car1);
		User1.setCars(cars1);
		db.put(1, User1);

		User2 = new User(2, "馬英九", "台北");
		List<Car> cars2 = new ArrayList<Car>();
		cars2.add(car2);
		cars2.add(car3);
		User2.setCars(cars2);
		db.put(2, User2);

		User3 = new User(3, "郭台銘", "板橋");
		List<Car> cars3 = new ArrayList<Car>();
		cars3.add(car1);
		cars3.add(car2);
		cars3.add(car3);
		cars3.add(car4);
		cars3.add(car5);
		cars3.add(car6);
		cars3.add(car7);
		User3.setCars(cars3);
		db.put(3, User3);

		User4 = new User(4, "韓國瑜", "高雄");
		List<Car> cars4 = new ArrayList<Car>();
		cars4.add(car5);
		cars4.add(car6);
		cars4.add(car7);
		User4.setCars(cars4);
		db.put(4, User4);

		listUsers.add(User1);
		listUsers.add(User2);
		listUsers.add(User3);
		listUsers.add(User4);
	
	}
	

	@Override
	public void saveUser(User user) {
		System.out.println("saveUser...:"+user.getId());
		db.put(user.getId(), user);
		listUsers.add(user);
	}

	@Override
	public void updateUser(User user) {
		System.out.println("updateUser...:"+user.getId());
		
		listUsers.remove(db.get(user.getId()));
		db.remove(user.getId());
		
		db.put(user.getId(), user);
		listUsers.add(user);
		
	}

	@Override
	public List<User> findAllUsers() {
		System.out.println("findAllUsers...");
		return listUsers;
	}

	@Override
	public User findAllById(int id) {

		System.out.println("findAllById...");

		User user = null;
		if (id != 0) {
			user = (User) db.get(id);
		}

		return user;
	}

	@DELETE
	@Path("/user/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	@Override
	public void deleteUser(@PathParam("id") int id) {
		System.out.println("deleteUser...");
		listUsers.remove(db.get(id));
		db.remove(id);
		
	}

}
