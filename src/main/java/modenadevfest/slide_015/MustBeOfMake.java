package modenadevfest.slide_015;

public class MustBeOfMake implements PublicationRule {
    public MustBeOfMake(String fiat) {
        super();
    }

    @Override
    public boolean isValid(Vehicle veicolo) {
        return false;
    }
}
