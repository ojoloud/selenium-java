package extend.util;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ExcelWrapper {
    public static final String DATAFILE = new File("src/main/resources/workbook.xlxs").getAbsolutePath();
    public static XSSFWorkbook workbook;
    public static HashMap<String, ArrayList<String>> table = new HashMap<>();
    public static final Logger logger = LoggerFactory.getLogger(ExcelWrapper.class);
    public ExcelWrapper() {
    }

    public static void init() {
        try {
            workbook = new XSSFWorkbook(new FileInputStream(DATAFILE));
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Row iRow = rowIterator.next();
                int firstCol = iRow.getFirstCellNum();
                int lastCol = iRow.getLastCellNum();
                ArrayList<String> k = new ArrayList<>();
                for (int i = firstCol + 1; i < lastCol + 1; i++) {
                    k.add(iRow.getCell(i).getStringCellValue());
                }
                table.put(iRow.getCell(firstCol).getStringCellValue(), k);
            }
        } catch (IOException e) {
            logger.error("Exception occurred:  {} ", e);
        } catch (NullPointerException e) {
            logger.error("Exception occurred:  {} ", e);
        }
    }

}
