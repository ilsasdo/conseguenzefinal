package modenadevfest.slide_010;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class PublicationPortal {

    private final String code;
    private final String name;
    private final FtpSettings ftpSettings;

    public PublicationPortal(String code, String name, FtpSettings ftpSettings) {
        this.code = code;
        this.name = name;
        this.ftpSettings = ftpSettings;
    }

    public boolean publish(List<Vehicle> vehicles) {
        FTPClient ftp = new FTPClient();
        FTPClientConfig config = new FTPClientConfig();
        ftp.configure(config);
        try {
            ftp.connect(ftpSettings.getHost(), ftpSettings.getPort());
            ftp.login(ftpSettings.getUsername(), ftpSettings.getPassword());

            // create the file
            File generatedFile = this.createCsvFile(vehicles);

            // upload it
            ftp.storeFile("/remote/"+ this.code + ".csv", new FileInputStream(generatedFile));

            ftp.logout();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    // do nothing
                }
            }
        }
    }

    private File createCsvFile(List<Vehicle> vehicles) {
        return new File(this.code + ".csv");
    }

    public String getCodice() {
        return code;
    }

    public String getNome() {
        return name;
    }

    public FtpSettings getFtpSettings() {
        return ftpSettings;
    }
}
