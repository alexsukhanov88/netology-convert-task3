import java.util.List;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.*;


public class JsonToListTest {

    private Converter converter = new Converter();
    private String testString = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25},{\"id\":2,\"firstName\":\"Inav\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";

    @Test
    public void json_to_list_success() {
        MatcherAssert.assertThat(converter.jsonToList(testString), instanceOf(List.class));
        MatcherAssert.assertThat(converter.jsonToList(testString), not(emptyCollectionOf(Employee.class)));
    }

}