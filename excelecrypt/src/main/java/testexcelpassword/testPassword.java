package testexcelpassword;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class testPassword {

	  

	  //Instance method with parameters: add(int x, int y).
	  //Returns the sum of inputs x and y.
	  public static String add(String arg0, String arg1) throws FileNotFoundException, IOException, InvalidFormatException, GeneralSecurityException {
		  
	            // Creating a xlsxfile object with specific file path
		  File xlsxFile = new File("/users/ravisingh/protected_updated.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile);
		  //XSSFWorkbook workbook = new XSSFWorkbook();
          // Creating workbook
			/*
			 * 
			 * 
			 * // Creating sheet XSSFSheet sheet = workbook.createSheet("Employee Records");
			 * 
			 * // Creating header of the sheet XSSFRow header = sheet.createRow(0);
			 * 
			 * // Creating cell and setting the cell value
			 * header.createCell(0).setCellValue("Employee Id");
			 * header.createCell(1).setCellValue("Employee Name");
			 * header.createCell(2).setCellValue("Age");
			 * header.createCell(3).setCellValue("Email ID");
			 * header.createCell(4).setCellValue("Salary");
			 * 
			 * // Creating the 1st row to insert employee record XSSFRow row1 =
			 * sheet.createRow(1);
			 * 
			 * // Inserting 1st employee record row1.createCell(0).setCellValue("101");
			 * row1.createCell(1).setCellValue("John william");
			 * row1.createCell(2).setCellValue("30");
			 * row1.createCell(3).setCellValue("william.john@gmail.com");
			 * row1.createCell(4).setCellValue("15000$");
			 * 
			 * // Creating the 2nd row XSSFRow row2 = sheet.createRow(2);
			 * 
			 * // Inserting 2nd employee record row2.createCell(0).setCellValue("102");
			 * row2.createCell(1).setCellValue("Harsh singh");
			 * row2.createCell(2).setCellValue("35");
			 * row2.createCell(3).setCellValue("harsh.singh@gmail.com");
			 * row2.createCell(4).setCellValue("20000$");
			 * 
			 * // Write the workbook data to a file FileOutputStream fos = new
			 * FileOutputStream(xlsxFile); workbook.write(fos); fos.close();
			 * workbook.close();
			 */
             
          
	            
	 
	            // Protecting the excel file
	             POIFSFileSystem fs = new POIFSFileSystem() ;
	 
	                EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
	                Encryptor encryptor = info.getEncryptor();
	 
	                // Setting the password 'javacodepoint'
	                encryptor.confirmPassword("javacodepoint");
	 
	                /* Read in an existing OOXML file and write to encrypted output stream
	                 * don't forget to close the output stream otherwise the padding bytes
	                 * aren't added
	                                 */
	                OPCPackage opc = OPCPackage.open(xlsxFile, PackageAccess.READ_WRITE);
	                        OutputStream os = encryptor.getDataStream(fs);
	                    opc.save(os);
	                
	 
	                // Write out the encrypted version
	               FileOutputStream fos1 = new FileOutputStream(xlsxFile) ;
	               workbook.write(fos1);
	               fs.writeFilesystem(fos1);
	               fos1.close();
	           
	               
	                    
	 
	            System.out.println("Protected Excel(.xlsx) file has been created successfully.");
	 
	       
		return arg0;
	  }
	}