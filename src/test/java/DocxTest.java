import org.junit.jupiter.api.Assertions;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

/**
 * Created by Konstantin Fedorov on 01.08.2021.
 */
public class DocxTest {
    @Test
    void testDocx() throws Docx4JException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("docx-file.docx");
        WordprocessingMLPackage wordprocessingMLPackage = WordprocessingMLPackage.load(stream);
        Assertions.assertEquals("First line", wordprocessingMLPackage.getMainDocumentPart().getContent().get(0).toString());
    }
}
