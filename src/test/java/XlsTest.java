import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Konstantin Fedorov on 01.08.2021.
 */
public class XlsTest {
    @Test
    void XlsDocx() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("xls_file.xls");

        HSSFWorkbook wb = new HSSFWorkbook(stream);
        HSSFSheet sheet = wb.getSheetAt(1);
        Assertions.assertEquals("Александрова Ксения Евгеньевна", sheet.getRow(2).getCell(1).getStringCellValue());
    }
}
