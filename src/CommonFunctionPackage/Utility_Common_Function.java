package CommonFunctionPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class Utility_Common_Function {
	@AfterTest
	public static void evidencefilecreater(String filename,String requestBody,String responseBody) throws IOException
	{
		File newfile = new File("C:\\Users\\HP\\OneDrive\\Desktop\\" +filename+".txt");
		System.out.println("new txt file created to record request and response of API :" +newfile.getName());
		
		FileWriter datawrite = new FileWriter(newfile);
		datawrite.write("request body:"+requestBody+"\n\n");// \n enter button
		datawrite.write("response body :" +responseBody);
		datawrite.close();
		System.out.println("request body and response body are saved in : " +newfile.getName());
		
	}
		public static ArrayList<String> readdataexcel(String sheetname,String testcasename) throws IOException
	{
		ArrayList<String> ArrayData = new ArrayList<String>();
		
		//step1: create the object of File input stream
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\API_TEST_DATA.xlsx");
		
		//step2: access the excel file 
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
				//step3: access the sheet name
				int countofsheet = workbook.getNumberOfSheets();
				for (int i=0;i<countofsheet;i++)
				{
					String filesheetname=workbook.getSheetName(i);
					if(filesheetname.equalsIgnoreCase(sheetname)) 
					{
						//step4: access the row from where the data is suppose to fetch
						XSSFSheet sheet = workbook.getSheetAt(i);
						Iterator<Row> rows = sheet.iterator();
						while(rows.hasNext()) 
						{
							Row r1=rows.next();
							if(r1.getCell(0).getStringCellValue().equalsIgnoreCase(testcasename))
							{
							
							Iterator<Cell> cellvalues=r1.cellIterator();
							while(cellvalues.hasNext()) {
							String testdata=cellvalues.next().getStringCellValue();
							ArrayData.add(testdata);
							}
						}
					}
				}
			}
	workbook.close();
	return ArrayData;
	}
	}			





