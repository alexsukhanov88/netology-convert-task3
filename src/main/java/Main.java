import java.util.List;

public class Main {

    public static void main(String[] args) {

        Converter converter = new Converter();

        String json = converter.readString("data.json");
        List<Employee> list = converter.jsonToList(json);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}
