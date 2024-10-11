package modenadevfest.slide_013;

import java.io.File;
import java.util.List;

public class PublicationPortal {

    private final String code;
    private final String name;
    private final FileUploader fileUploader;

    public PublicationPortal(String code, String name, FileUploader fileUploader) {
        this.code = code;
        this.name = name;
        this.fileUploader = fileUploader;
    }

    public boolean publish(List<Vehicle> vehicles) {
        return fileUploader.upload(createCsvFile(vehicles), "/" + this.code + ".csv");
    }

    private File createCsvFile(List<Vehicle> vehicles) {
        return new File("vehicles.csv");
    }
}
