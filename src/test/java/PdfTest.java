import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Konstantin Fedorov on 01.08.2021.
 */
public class PdfTest {
    @Test
    void pdfTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("pdf-file.pdf");

        try (PDDocument document = PDDocument.load(stream)) {
            if (!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();
                String pdfFileInText = tStripper.getText(document);
                String[] lines = pdfFileInText.split("\\r?\\n");
                Assertions.assertEquals("PDF INFO & TEST FILE", lines[1]);
            }
        }
    }
}
