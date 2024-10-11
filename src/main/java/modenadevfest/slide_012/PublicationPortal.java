package modenadevfest.slide_012;

import modenadevfest.slide_010.Vehicle;

import java.io.File;
import java.util.List;

public class PublicationPortal {

    private final String code;
    private final String name;
    private final boolean uploadToFtp;
    private final FtpUploader ftpUploader;
    private final S3Uploader s3Uploader;

    public PublicationPortal(String code, String name, boolean uploadToFtp,
                             FtpUploader ftpUploader, S3Uploader s3Uploader) {
        this.code = code;
        this.name = name;
        this.uploadToFtp = uploadToFtp;
        this.ftpUploader = ftpUploader;
        this.s3Uploader = s3Uploader;
    }

    public boolean publish(List<Vehicle> vehicles) {
        if (uploadToFtp) {
            return ftpUploader.upload(createCsvFile(vehicles), "/" + this.code + ".csv");
        } else {
            return s3Uploader.uploadToBucket("s3://bucket/" + this.code + ".csv", createCsvFile(vehicles));
        }
    }

    private File createCsvFile(List<Vehicle> vehicles) {
        return new File("vehicles.csv");
    }
}
