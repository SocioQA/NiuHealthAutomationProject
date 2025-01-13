package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parameterization {
	
	public static String parameterizationMethod(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException
	{
	
	FileInputStream testFile= new FileInputStream("C:\\Users\\91738\\eclipse-workspace\\Spotsaver\\src\\test\\resources\\TestData.xlsx");
	String testData= WorkbookFactory
			.create(testFile)
			.getSheet(sheetname)
			.getRow(row)
			.getCell(cell)
			.getStringCellValue();
	
	return testData;

	}
}
