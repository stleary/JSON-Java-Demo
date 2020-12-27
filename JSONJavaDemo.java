import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONJavaDemo {

    public static String jsonObjectString = "{ \"key1\":\"abc\", \"key2\":42, \"key3\":true, \"key4\": [1,2,3] }";

    public static String jsonArrayString = "[ { \"key1\":\"abc\", \"key2\":42, \"key3\":true }, [1,2,3] ]";

    /**
     * Build a JSONObject from a string
     * 
     * @param str valid JSON document
     */
    private void jsonObjectFromString(String str) {
        JSONObject jsonObject = new JSONObject(str);
        System.out.println("JSONObject from string:");
        System.out.println(jsonObject.toString());
    }

    /**
     * Build a JSONArray from a string
     * 
     * @param str valid JSON document
     */
    private void jsonArrayFromString(String str) {
        JSONArray jsonArray = new JSONArray(str);
        System.out.println("JSONArray from string:");
        System.out.println(jsonArray.toString());
    }

    /**
     * Build a JSONObject using the API to add JSON elements
     */
    private void buildJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", "abc");
        jsonObject.put("key2", 42);
        jsonObject.put("key3", true);
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(1);
        jsonArray.put(2);
        jsonArray.put(3);
        jsonObject.put("key4", jsonArray);
        System.out.println("Build JSONObject:");
        System.out.println(jsonObject.toString());
    }

    /**
     * Build a JSONArray using the API to add JSON elements
     */
    private void buildJSONArray() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", "abc");
        jsonObject.put("key2", 42);
        jsonObject.put("key3", true);
        jsonArray.put(jsonObject);
        JSONArray jsonArrayNested = new JSONArray();
        jsonArrayNested.put(1);
        jsonArrayNested.put(2);
        jsonArrayNested.put(3);
        jsonArray.put(jsonArrayNested);
        System.out.println("Build JSONArray:");
        System.out.println(jsonArray.toString());
    }

    /**
     * Build a JSONObject from a Reader object
     * 
     * @param str the input string
     */
    private void jsonObjectFromReader(String str) {
        Reader stringReader = new StringReader(str);
        BufferedReader reader = new BufferedReader(stringReader);
        JSONObject jsonObject = new JSONObject(new JSONTokener(reader));
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSONObject from reader:");
        System.out.println(jsonObject.toString());
    }

    /**
     * Build a JSONObject from a Reader object
     * 
     * @param str the input string
     */
    private void jsonArrayFromReader(String str) {
        Reader stringReader = new StringReader(str);
        BufferedReader reader = new BufferedReader(stringReader);
        JSONArray jsonArray = new JSONArray(new JSONTokener(reader));
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSONArray from reader:");
        System.out.println(jsonArray.toString());
    }

    /**
     * Demonstrate various ways to build a JSONObject or JSONArray
     * 
     * @param args
     */
    public static void main(String[] args) {
        JSONJavaDemo jsonJavaDemo = new JSONJavaDemo();

        jsonJavaDemo.jsonObjectFromString(JSONJavaDemo.jsonObjectString);
        jsonJavaDemo.buildJSONObject();
        jsonJavaDemo.jsonObjectFromReader(JSONJavaDemo.jsonObjectString);

        jsonJavaDemo.jsonArrayFromString(JSONJavaDemo.jsonArrayString);
        jsonJavaDemo.buildJSONArray();
        jsonJavaDemo.jsonArrayFromReader(JSONJavaDemo.jsonArrayString);
    }

}
