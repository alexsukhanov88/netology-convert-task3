import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.equalTo;


public class ReadStringTest {

    private Converter converter = new Converter();
    private String readString = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25},{\"id\":2,\"firstName\":\"Inav\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";

    @Test
    public void read_sring_success() {
        String fileString = converter.readString("data.json");
        MatcherAssert.assertThat(readString, equalTo(fileString));
    }

}
