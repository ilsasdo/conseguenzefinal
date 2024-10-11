package modenadevfest.slide_003;

public class PublicationPortal {
    private String code;
    private String name;
    private String ftphost;
    private int ftpport;
    private String ftpusername;
    private String ftppassword;

    // ... getters and setters...


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return ftphost;
    }

    public void setHost(String host) {
        this.ftphost = host;
    }

    public int getPort() {
        return ftpport;
    }

    public void setPort(int port) {
        this.ftpport = port;
    }

    public String getUsername() {
        return ftpusername;
    }

    public void setUsername(String username) {
        this.ftpusername = username;
    }

    public String getPassword() {
        return ftppassword;
    }

    public void setPassword(String password) {
        this.ftppassword = password;
    }
}
