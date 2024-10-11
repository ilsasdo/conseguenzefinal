package modenadevfest.slide_004;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "publication_portals")
public class PublicationPortal {

    @Id private Long id;
    @Version private Long version;

    @Column private String code;
    @Column private String name;
    @Column private String ftphost;
    @Column private int ftpport;
    @Column private String ftpusername;
    @Column private String ftppassword;

    // ... getters and setters...


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

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
