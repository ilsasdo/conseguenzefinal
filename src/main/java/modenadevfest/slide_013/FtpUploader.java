package modenadevfest.slide_013;

import java.io.File;

public class FtpUploader implements FileUploader {
    private final FtpSettings ftpSettings;

    public FtpUploader(FtpSettings ftpSettings) {
        this.ftpSettings = ftpSettings;
    }

    public boolean upload(File file, String dest) {
        return true;
    }
}
