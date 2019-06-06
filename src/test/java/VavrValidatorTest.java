import io.vavr.control.Validation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VavrValidatorTest {

    private Validation<String, String> validateLicensePlate(String s) {
        if (s.matches("^\\p{Alpha}{2}\\d{3}\\p{Alpha}{2}$")) {
            return Validation.valid(s) ;
        } else {
            return Validation.invalid("License Plate is not valid");
        }
    }


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testValidData() {
        Car car = new Car();

        car.brand = "Fiat";
        car.licensePlate = "AA321AA";
        car.doors = 4;

        Assert.assertTrue(validateLicensePlate(car.licensePlate).isValid());
    }

    @Test
    public void testInvalidData() {
        Car car = new Car();

        car.brand = "Fiat";
        car.licensePlate = "AAA321AA";
        car.doors = 4;

        Assert.assertTrue(validateLicensePlate(car.licensePlate).isInvalid());
    }
}
