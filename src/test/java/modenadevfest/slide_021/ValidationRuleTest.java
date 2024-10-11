package modenadevfest.slide_021;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationRuleTest {

    @Test
    public void can_publish_only_Ferrari_cars() {
        Vehicle vehicle = new VehicleBuilder().make("Ferrari").build();

        ValidateMakeRule rule = new ValidateMakeRule("Ferrari");

        Assertions.assertTrue(rule.isValid(vehicle));
    }


    public static class VehicleBuilder {
        private String make = "Fiat";
        private String model = "Panda";
        private int year = 2011;
        private String color = "red";
        private String plate = "AA123BB";

        public VehicleBuilder make(String make) {
            this.make = make;
            return this;
        }

        // ... tutti gli altri ...

        public modenadevfest.slide_021.Vehicle build() {
            return new Vehicle(make, model, year, color, plate);
        }
    }


    private class ValidateMakeRule {
        public ValidateMakeRule(String ferrari) {
        }

        public boolean isValid(Vehicle vehicle) {
            return true;
        }
    }
}
