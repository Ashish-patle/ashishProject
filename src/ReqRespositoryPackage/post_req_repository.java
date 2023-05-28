package ReqRespositoryPackage;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeTest;

import CommonFunctionPackage.Utility_Common_Function;

public class post_req_repository {
	@BeforeTest
	public static String baseURI () {
		String baseURI = "https://reqres.in/";
		return baseURI;
	}
	public static String resource() {
		String resource = "/api/users";
		return resource;
	}
	public static String requestBody1() throws IOException
	{
		ArrayList<String> data = Utility_Common_Function.readdataexcel("Post_Test_Data","Post_TC_1");
		String req_name = data.get(1);
		String req_job = data.get(2);
		String requestBody = "{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return requestBody;
		
		
	}
	public static String requestBody2() throws IOException
	{
		ArrayList<String> data = Utility_Common_Function.readdataexcel("Post_Test_Data","Post_TC_2");
		String req_name = data.get(1);
		String req_job = data.get(2);
		String requestBody = "{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return requestBody;
	}
	public static String requestBody3() throws IOException
	{
		ArrayList<String> data = Utility_Common_Function.readdataexcel("Post_Test_Data","Post_TC_3");
		String req_name = data.get(1);
		String req_job = data.get(2);
		String requestBody = "{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return requestBody;
}
	public static String requestBody4() throws IOException
	{
		ArrayList<String> data = Utility_Common_Function.readdataexcel("Post_Test_Data","Post_TC_4");
		String req_name = data.get(1);
		String req_job = data.get(2);
		String requestBody = "{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return requestBody;
}
}


