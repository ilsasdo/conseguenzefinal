package modenadevfest.slide_006;

import modenadevfest.slide_021.Vehicle;

import java.io.File;
import java.util.List;

public class PublicationPortal {

    // ... fields ...
    // ... constructor ...

    public void publish(List<Vehicle> vehicles) {
        File file = this.generateFile(vehicles);

        this.uploadToFtp(file);
    }

    private void uploadToFtp(File file) {
        // uploads to ftp....
    }

    private File generateFile(List<Vehicle> vehicles) {
        return new File("file");
    }


    private final String code;
    private final String name;
    private final String ftphost;
    private final String ftpport;
    private final String ftpusername;
    private final String ftppassword;


    public PublicationPortal(String code, String name,
                             String ftphost, String ftpport,
                             String ftpusername, String ftppassword) {
        this.code = code;
        this.name = name;
        this.ftphost = ftphost;
        this.ftpport = ftpport;
        this.ftpusername = ftpusername;
        this.ftppassword = ftppassword;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getHost() {
        return ftphost;
    }

    public String getPort() {
        return ftpport;
    }

    public String getUsername() {
        return ftpusername;
    }

    public String getPassword() {
        return ftppassword;
    }
}
