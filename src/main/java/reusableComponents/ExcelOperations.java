package reusableComponents;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ExcelOperations {

    String filePath;
    Sheet sh;

    public ExcelOperations(String sheetName) {
        String filePath = null;
        try {
            filePath = System.getProperty("user.dir") + PropertiesOperations.getPropertyValueByKey("testDataLocation");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Open File - Workbook
        File testDataFile = new File(filePath);
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(testDataFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        sh = wb.getSheet(sheetName);
    }
    //Get Test data from Test data sheet in Hashmap based on row number
    public HashMap<String, String> getTestDataInMap(int rowNum) {
        //Read data row by row and put it in map
        HashMap<String, String> hm = new HashMap<String, String>();

        for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
            sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
            hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString());
        }

        return hm;
    }
    //Get row count
    public int getRowCount() {
        return sh.getLastRowNum();
    }
    //Get column count
    public int getColCount() {
        return sh.getRow(0).getLastCellNum();
    }
}
