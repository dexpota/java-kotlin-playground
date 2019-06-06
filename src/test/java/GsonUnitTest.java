import com.google.gson.Gson;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GsonUnitTest {
    private static Gson gson = new Gson();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testBasicParsing() {
        String in = "{'brand': 'Jeep', 'doors': 3, 'licensePlate': 'AA111AA'}";
        Car car = gson.fromJson(in, Car.class);
        Assert.assertNotNull(car);

        String out = gson.toJson(car);

        Assert.assertEquals(car, gson.fromJson(out, Car.class));
    }
}
