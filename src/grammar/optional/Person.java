package grammar.optional;

import java.util.Optional;

public class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public String getCarInsuranceName(Optional<Person > person) {
//        String name = person
//                .map(Person::getCar)
//                .map(Car::getInsurance)
//                .map(Insurance::getName)
//                .orElse("Unknown");

        String name = person
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");

        return name;
    }
}

class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}

class Insurance {
    private String name;

    public String getName() {
        return name;
    }
}