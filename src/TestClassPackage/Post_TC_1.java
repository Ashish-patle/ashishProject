package TestClassPackage;

import java.io.IOException;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import CommonFunctionPackage.Post_Common_Function;
import CommonFunctionPackage.Utility_Common_Function;
import io.restassured.path.json.JsonPath;


public class Post_TC_1 {
	@Test
	public static void execute() throws IOException
	{
		for(int i=0; i<5; i++)
		{
			
		int statusCode = Post_Common_Function.statusCode(ReqRespositoryPackage.post_req_repository.baseURI(),ReqRespositoryPackage.post_req_repository.resource(),ReqRespositoryPackage.post_req_repository.requestBody1());
		if(statusCode==201) {
		System.out.println("status code is " +statusCode);
		
		
		String responseBody =  Post_Common_Function.responseBody(ReqRespositoryPackage.post_req_repository.baseURI(),ReqRespositoryPackage.post_req_repository.resource(),ReqRespositoryPackage.post_req_repository.requestBody1());
		Post_TC_1.validator(responseBody, statusCode);
		Utility_Common_Function.evidencefilecreater("Ashu",ReqRespositoryPackage.post_req_repository.requestBody1() , responseBody);

		System.out.println("response body is " +responseBody);
		break;
		
		}				
		else
		{
			System.out.println("incorrect status Code found hence retrying the api");
		}
		
		}
		
	}
	public static void validator(String responseBody,int statusCode)throws IOException {
	System.out.println(ReqRespositoryPackage.post_req_repository.requestBody1());
	
		//parse the request and response body
	
		JsonPath jspr = new JsonPath(ReqRespositoryPackage.post_req_repository.requestBody1());
		String req_name = jspr.getString("name");
		String req_job = jspr.getString("job");
		System.out.println(req_name);
		System.out.println(req_job);
		
		JsonPath jsp = new JsonPath(responseBody);
		String res_name = jsp.getString("name");
		String res_job  = jsp.getString("job");
		String res_id   = jsp.getString("id");
		String res_createdAt = jsp.getString("createdAt");
		System.out.println(res_name);
		System.out.println(res_job);
		System.out.println(res_id);
		System.out.println(res_createdAt);
		
		// generate new date
		String expectedDate = res_createdAt.substring(0,10);
		String currentDate  = LocalDate.now().toString();
		
		//validate the response body
		Assert.assertEquals(statusCode, 201);
		Assert.assertEquals(req_name,res_name);
		Assert.assertEquals(req_job,res_job);
		Assert.assertEquals(expectedDate,currentDate);
		Assert.assertNotNull(res_id);
		
	}

}






