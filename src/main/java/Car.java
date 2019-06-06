import java.util.Objects;

class Car {
    public String brand;
    public String licensePlate;
    public int doors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return doors == car.doors &&
                brand.equals(car.brand) &&
                licensePlate.equals(car.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, licensePlate, doors);
    }
}
