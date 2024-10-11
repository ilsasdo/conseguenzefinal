package modenadevfest.slide_010;

public class FtpSettings {
    private final String host;
    private final int port;
    private final String username;
    private final String password;

    public FtpSettings(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getConnectionString() {
        return String.format("%s@%s:%d", username, host, port);
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
