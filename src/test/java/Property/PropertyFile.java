package Property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

    public FileInputStream file;
    public Properties property;

    public PropertyFile(String nume) {
        loadFile(nume);
    }
    public void loadFile(String nume){
        property = new Properties();
        try {
            file = new FileInputStream("src/test/resources/InputData/"+ nume +".properties");
            property.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getValueByKey(String key){
        return property.getProperty(key);
    }
}
