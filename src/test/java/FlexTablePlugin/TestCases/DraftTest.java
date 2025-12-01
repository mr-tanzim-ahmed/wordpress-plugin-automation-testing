package FlexTablePlugin.TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DraftTest extends BaseTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties = new Properties();
        //user.dir -->> project home directory
        String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
