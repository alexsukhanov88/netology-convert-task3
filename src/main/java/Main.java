import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    private static List<Employee> jsonToList(String json) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        JSONParser parser = new JSONParser();
        List<Employee> list = new ArrayList<>();

        try {
            Object obj = parser.parse(json);
            JSONArray jsonArray = (JSONArray) obj;
            for (Object value : jsonArray) {
                Employee employee = gson.fromJson(value.toString(), Employee.class);
                list.add(employee);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return list;
    }

    private static String readString(String fileName) {

        String json = new String();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            json = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static void main(String[] args) {

        String json = readString("data.json");
        List<Employee> list = jsonToList(json);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}
