package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import com.entity.Car;
import com.entity.User;

/**
 * Description:演示一下模擬"客戶端"的RestFul風格,基本Code下,沒很拘謹
 * @author MarkLin
 * @Date:2019年11月4日下午2:01:19
 * @Remarks:
 */
public class userClient {

	public static void main(String[] args)  {

	}

	/**
	 * Description:查詢
	 * 
	 * @author MarkLin
	 * @Date:2019年11月2日下午9:22:30
	 * @Remarks: 
	 */
	@Test
	public void RestFul_Get()  {

		WebClient webClient = WebClient
				.create("http://localhost:8080/WebService_Jaxrs_RestFul/services/userService/rscenter/user/");


		int statusCode =0;
		String errMsg=null;
		try {
			webClient
			.path(10)
			.accept(MediaType.APPLICATION_JSON)
			.type(MediaType.APPLICATION_JSON)
			.get();

			statusCode = webClient.getResponse().getStatus();

			if (statusCode == 200) {

				BufferedReader rd = new BufferedReader(
						new InputStreamReader((InputStream) webClient.getResponse().getEntity()));

				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}

				System.out.println("Result:"+result.toString());

			} else {
	
			    errMsg ="遠端Service錯誤異常,statusCode="+statusCode;
				
			}
		} catch (IOException e) {
			errMsg+=e.toString();
			e.printStackTrace();
		}
		
		if(errMsg!=null)
			System.out.println("errMsg:"+errMsg);
		
		
		
//		重購打開註解也能運行		
//		// 1.類似打開柳覽器概念
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//
//		// 2.目標網址
//		HttpGet httpGet = new HttpGet(
//				"http://localhost:8080/WebService_Jaxrs_RestFul/services/userService/rscenter/user/1");
//
//		// 3.執行
//		HttpResponse httpResponse = httpClient.execute(httpGet);
//
//		int statusCode = httpResponse.getStatusLine().getStatusCode();
//
//		if (statusCode == 200) {
//			HttpEntity httpEntity = httpResponse.getEntity();
//
//			String resutl = EntityUtils.toString(httpEntity, "UTF-8");
//
//			System.out.println("resutl:" + resutl);
//			EntityUtils.consume(httpEntity);
//		} else {
//
//			System.out.println("錯誤資訊:" + httpResponse.getStatusLine());
//		}
//
//		httpClient.close();

	}

	/**
	 * Description:查詢全部
	 * 
	 * @author MarkLin
	 * @Date:2019年11月4日下午12:42:20
	 * @Remarks:
	 */
	@Test
	public void RestFul_GetAll() throws ClientProtocolException, IOException {

		WebClient webClient = WebClient
				.create("http://localhost:8080/WebService_Jaxrs_RestFul/services/userService/rscenter/user/");


		int statusCode =0;
		String errMsg=null;
		try {
			webClient
			.accept(MediaType.APPLICATION_JSON)
			.type(MediaType.APPLICATION_JSON)
			.get();

			statusCode = webClient.getResponse().getStatus();

			if (statusCode == 200) {

				BufferedReader rd = new BufferedReader(
						new InputStreamReader((InputStream) webClient.getResponse().getEntity()));

				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}

				System.out.println("Result:"+result.toString());

			} else {
	
			    errMsg ="遠端Service錯誤異常,statusCode="+statusCode;
				
			}
		} catch (IOException e) {
			errMsg+=e.toString();
			e.printStackTrace();
		}
		
		if(errMsg!=null)
			System.out.println("errMsg:"+errMsg);
	}

	/**
	 * Description:新增
	 * 
	 * @author MarkLin
	 * @Date:2019年11月4日上午11:35:18
	 * @Remarks:
	 */
	@Test
	public void RestFul_Post() {

		WebClient webClient = WebClient
				.create("http://localhost:8080/WebService_Jaxrs_RestFul/services/userService/rscenter/user");

		Car car = new Car(2008, "Lexus", 1000000.0);
		User user = new User(10, "學姊", "桃園");
		List<Car> cars = new ArrayList<Car>();
		cars.add(car);
		user.setCars(cars);
		
		int statusCode =0;
		String errMsg=null;
		try {
			webClient
			.type(MediaType.APPLICATION_JSON)
			.post(user);

			statusCode = webClient.getResponse().getStatus();

			if(statusCode ==204){
	
			  System.out.println("執行成功...!");
				
			} 
			else {
			    errMsg ="遠端Service錯誤異常,statusCode="+statusCode;
			}
		} catch (Exception e) {
			errMsg+=e.toString();
			e.printStackTrace();
		}
		
		if(errMsg!=null)
			System.out.println("errMsg:"+errMsg);
		
		
		

//		// 1.類似打開柳覽器概念
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//
//		// 2.目標網址
//		HttpPost httpPost = new HttpPost(
//				"http://localhost:8080/WebService_Jaxrs_RestFul/services/userService/rscenter/user");
//
//		httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
//		
//		//3.建立Json資料
//		Car car = new Car(2008, "Lexus", 1000000.0);
//		User user = new User(10, "學姊", "桃園");
//		List<Car> cars=new ArrayList<Car>();
//		cars.add(car);
//		user.setCars(cars);
//		
//		JSONObject json = new JSONObject(user);
//		System.out.println(json.toString());
//		//解決中文亂碼問題
//        StringEntity jsonEntity = new StringEntity(json.toString(), "UTF-8");
//        //jsonEntity.setContentEncoding("UTF-8");
//       // jsonEntity.setContentType("application/json");
//      
//        HttpEntity httpEntit2y= new SerializableEntity((Serializable) user);
//		httpPost.setEntity(httpEntit2y);

//		// 3.執行
//		HttpResponse httpResponse = httpClient.execute(httpPost);
//
//		int statusCode = httpResponse.getStatusLine().getStatusCode();
//
//		if (statusCode == 200) {
//			HttpEntity httpEntity = httpResponse.getEntity();
//
//			String resutl = EntityUtils.toString(httpEntity, "UTF-8");
//
//			System.out.println("resutl:" + resutl);
//			EntityUtils.consume(httpEntity);
//		} else {
//
//			System.out.println("錯誤資訊:" + httpResponse.getStatusLine());
//		}
//
//		httpClient.close();
	}

	/**
	 * Description:刪除
	 * 
	 * @author MarkLin
	 * @Date:2019年11月4日上午11:37:10
	 * @Remarks:
	 */
	@Test
	public void RestFul_Delete() {

		WebClient webClient = WebClient
				.create("http://localhost:8080/WebService_Jaxrs_RestFul/services/userService/rscenter/user/");
		
		int statusCode =0;
		String errMsg=null;
		try {
			webClient.path("10")
			.accept(MediaType.APPLICATION_JSON)
			.type(MediaType.APPLICATION_JSON)
			.delete();

			statusCode = webClient.getResponse().getStatus();

			if(statusCode ==204){
	
			  System.out.println("執行成功...!");
				
			} 
			else {
			    errMsg ="遠端Service錯誤異常,statusCode="+statusCode;
			}
		} catch (Exception e) {
			errMsg+=e.toString();
			e.printStackTrace();
		}
		
		if(errMsg!=null)
			System.out.println("errMsg:"+errMsg);



	}

	/**
	 * Description:修改
	 * 
	 * @author MarkLin
	 * @Date:2019年11月4日下午1:00:08
	 * @Remarks:
	 */
	@Test
	public void RestFul_Put() {

		WebClient webClient = WebClient
				.create("http://localhost:8080/WebService_Jaxrs_RestFul/services/userService/rscenter/user");
		
		
		Car car = new Car(2008, "Lexus", 1000000.0);
		User user = new User(1, "柯文哲2.0", "高雄");
		List<Car> cars = new ArrayList<Car>();
		cars.add(car);
		user.setCars(cars);
		
		int statusCode =0;
		String errMsg=null;
		try {

			webClient
			.accept(MediaType.APPLICATION_JSON)
			.type(MediaType.APPLICATION_JSON)
			.put(user);
			

			statusCode = webClient.getResponse().getStatus();

			if(statusCode ==204){
	
			  System.out.println("執行成功...!");
				
			} 
			else {
			    errMsg ="遠端Service錯誤異常,statusCode="+statusCode;
			}
		} catch (Exception e) {
			errMsg+=e.toString();
			e.printStackTrace();
		}
		
		if(errMsg!=null)
			System.out.println("errMsg:"+errMsg);
		
	}

}
