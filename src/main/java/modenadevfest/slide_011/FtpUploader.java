package modenadevfest.slide_011;

import modenadevfest.slide_010.FtpSettings;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FtpUploader {
    private final FtpSettings ftpSettings;

    public FtpUploader(FtpSettings ftpSettings) {
        this.ftpSettings = ftpSettings;
    }

    public boolean upload(File generatedFile, String destination) {
        FTPClient ftp = new FTPClient();
        FTPClientConfig config = new FTPClientConfig();
        ftp.configure(config);
        try {
            ftp.connect(ftpSettings.getHost(), ftpSettings.getPort());
            ftp.login(ftpSettings.getUsername(), ftpSettings.getPassword());

            // upload it
            ftp.storeFile("/remote/"+ destination, new FileInputStream(generatedFile));

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
}
