package modenadevfest.slide_015;

import java.io.File;
import java.util.List;

public class PublicationPortal {

    private final String code;
    private final String name;
    private final List<PublicationRule> rules;
    private final FileProducer fileGenerator;
    private final FileUploader fileUploader;

    public PublicationPortal(String code, String name, List<PublicationRule> rules, FileProducer fileGenerator, FileUploader fileUploader) {
        this.code = code;
        this.name = name;
        this.rules = rules;
        this.fileGenerator = fileGenerator;
        this.fileUploader = fileUploader;
    }

    public boolean publish(List<Vehicle> vehicles) {
        return fileUploader.upload(createCsvFile(vehicles), "/vehicles.csv");
    }

    private File createCsvFile(List<Vehicle> vehicles) {
        return new File("vehicles.csv");
    }
}
