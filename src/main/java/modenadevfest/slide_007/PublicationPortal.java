package modenadevfest.slide_007;

public class PublicationPortal {

    private final String code;
    private final String name;
    private final FtpSettings ftpSettings;

    public PublicationPortal(String code,
                             String name,
                             FtpSettings ftpSettings) {
        this.code = code;
        this.name = name;
        this.ftpSettings = ftpSettings;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public FtpSettings getFtpSettings() {
        return ftpSettings;
    }
}
