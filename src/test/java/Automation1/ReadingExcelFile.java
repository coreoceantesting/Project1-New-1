package Automation1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelFile {
    public static void main (String [] args) throws IOException{
    {
        String ExcelPath =".\\DataFiles\\visitors.xlsx";  //Set Excel Sheet Ppath

        
        FileInputStream inputstream = new FileInputStream(ExcelPath);
        try (XSSFWorkbook workbook = new XSSFWorkbook(inputstream)) {
            XSSFSheet index = workbook.getSheetAt(0); //For GetIndex
            //XSSFSheet Sheet = workbook.getSheet("Sheet1"); //For Get Sheet

            int rows=index.getLastRowNum();
            int cols=index.getRow(1).getLastCellNum();

            for(int r=0; r<=rows; r++)
            {
                XSSFRow row=index.getRow(r);
                for(int c=0; c<cols; c++)
                {
                    XSSFCell cell = row.getCell(c);
                    switch (cell.getCellType()) {
                        case STRING: System.out.println(cell.getStringCellValue());
                        break;
                        case NUMERIC: System.out.println(cell.getNumericCellValue());
                        break;
                        case BOOLEAN: System.out.println(cell.getBooleanCellValue());
                        break;
                        
                    }
                    System.out.print("  | ");
                }
                System.out.println();
            }
        }
   }
}
}
