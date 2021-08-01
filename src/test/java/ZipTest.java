import net.lingala.zip4j.ZipFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konstantin Fedorov on 01.08.2021.
 */
public class ZipTest {

    @Test
    void zipTest() throws IOException {
        String extractFolder = "build/tmp";
        String fileName = "zip-file";
        ZipFile zipFile = new ZipFile(new File("src/test/resources/" + fileName + ".zip"));
        zipFile.setPassword("123".toCharArray());
        zipFile.extractAll(extractFolder);

        FileReader fileReader = new FileReader(extractFolder + "/" + fileName + "/sample.txt");
        List<String> results = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(fileReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                results.add(line);
            }
        }
        Assertions.assertEquals("Thanks!", results.get(4));
    }
}
