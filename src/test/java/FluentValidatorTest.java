import com.baidu.unbiz.fluentvalidator.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

public class FluentValidatorTest {
    private ValidatorHandler<String> licensePlateValidator;

    @Before
    public void setUp() throws Exception {
        licensePlateValidator = new ValidatorHandler<String>() {
            @Override
            public boolean validate(ValidatorContext context, String s) {
                if (s.matches("^\\p{Alpha}{2}\\d{3}\\p{Alpha}{2}$")) {
                    return true;
                } else {
                    context.addErrorMsg("License Plate is not valid");
                    return false;
                }
            }
        };
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

        Result validationResult = FluentValidator.checkAll()
                .on(car.licensePlate, licensePlateValidator)
                .doValidate().result(toSimple());

        Assert.assertTrue(validationResult.isSuccess());
    }

    @Test
    public void testInvalidData() {
        Car car = new Car();

        car.brand = "Fiat";
        car.licensePlate = "AAA321AA";
        car.doors = 4;

        Result validationResult = FluentValidator.checkAll()
                .on(car.licensePlate, licensePlateValidator)
                .doValidate().result(toSimple());

        Assert.assertFalse(validationResult.isSuccess());
    }
}
