package dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReaderDataProvider {


    public static void main(String[] args) throws IOException {
        getTestData();
    }

    private static final String EXCEL_PATH = System.getProperty("user.dir") + "/src/test/java/resources/config/credentials.xlsx";
   

    //convert the List<Map<String, Object>> to Object[][] before returning it.
    @DataProvider(name = "excelData")
    public static Object[][] getTestData() throws IOException {
        List<Map<String, Object>> testData = getExcelData(); // dataReadExcel() returns List<Map<String, Object>>

        Object[][] dataArray = new Object[testData.size()][1];//no of rows data[map1,map2..] and only one column
        for (int i = 0; i < testData.size(); i++) {
            Map<String, Object> dataMap = testData.get(i);
            dataArray[i][0] = dataMap;//acces data from array like [0][0],[1][0]...
        }

        return dataArray;
    }
   
  
    public static List<Map<String, Object>> getExcelData() throws IOException {
        List<Map<String, Object>> testData = new ArrayList<>(); // will store list of map1.map2 ...

        FileInputStream input = new FileInputStream(EXCEL_PATH);
        Workbook wb = new XSSFWorkbook(input);
        Sheet sheet = wb.getSheetAt(0);

        Map<String, Object> rowDataMap;
        Iterator<Row> rowIterator = sheet.iterator();
        Row headerRow = rowIterator.next();
        while (rowIterator.hasNext()) {//for row 
            Row dataRow = rowIterator.next();
            Iterator<Cell> cellIterator = dataRow.cellIterator();
            rowDataMap = new HashMap<>();
            while (cellIterator.hasNext()) {//for each row and its cell
                Cell cell = cellIterator.next();
                String header = headerRow.getCell(cell.getColumnIndex()).getStringCellValue();
                String value = cell.getStringCellValue();
                rowDataMap.put(header, value);
            }
            testData.add(rowDataMap);
            

        }
        wb.close();
        return testData;

    }

}
