package ui_automation.utilities;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class ExcelUtility {
    private static final Logger logger = LogManager.getLogger(ExcelUtility.class);
    private static XSSFWorkbook workBook;
    private static XSSFSheet workSheet;
    private static XSSFRow row;
    private static XSSFCell cell;

    public static void setExcelFile(String Path, String SheetName) throws Exception {
        try {
            FileInputStream inputStream = new FileInputStream(Path);
            workBook = new XSSFWorkbook(inputStream);
            workSheet = workBook.getSheet(SheetName);
            logger.info("Successfully connected to excel file!");
        } catch (Exception e) {
            logger.error("OOOOPPPSSS! Excel connection failed! Check your System!");
            throw (e);
        }
    }

    public static String getCellDataAsString(int RowNum, int ColNum) throws Exception {
        try {
            cell = workSheet.getRow(RowNum).getCell(ColNum);
            if (cell == null) {
                return "";  // Return an empty string if the cell is null
            }
            return cell.getStringCellValue();
        } catch (Exception e) {
            throw (e);
        }
    }
}
