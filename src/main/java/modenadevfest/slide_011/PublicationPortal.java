package modenadevfest.slide_011;

import modenadevfest.slide_010.Vehicle;

import java.io.File;
import java.util.List;

public class PublicationPortal {

    private final String code;
    private final String name;
    private final FtpUploader ftpUploader;

    public PublicationPortal(String code, String name, FtpUploader ftpUploader) {
        this.code = code;
        this.name = name;
        this.ftpUploader = ftpUploader;
    }

    public boolean publish(List<Vehicle> veicoli) {
        return ftpUploader.upload(createCsvFile(veicoli), this.code + ".csv");
    }

    private File createCsvFile(List<Vehicle> veicoli) {
        return new File(this.code + ".csv");
    }
}
