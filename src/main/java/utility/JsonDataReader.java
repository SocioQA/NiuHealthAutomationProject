package utility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonDataReader {

    public JSONObject getJsonData(String filePath) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;

        FileReader reader = null;
        try {
            // Initialize FileReader with the provided file path
            reader = new FileReader(filePath);
            // Parse the JSON file and cast it to JSONObject. When using the JSON.parse() on a JSON derived from an array, the method will return a JavaScript array
            jsonObject = (JSONObject) jsonParser.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Ensure the reader is closed
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        // Return the parsed JSONObject
        return jsonObject;
    }
}
