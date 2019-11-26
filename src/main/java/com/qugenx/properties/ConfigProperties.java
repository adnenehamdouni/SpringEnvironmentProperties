package com.qugenx.properties;

import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "mail")
@Validated
public class ConfigProperties {

    @NotBlank
    @Size(max = 15, min = 6)
    private String hostName;

    @Min(1025)
    @Max(65536)
    private int port;

    @Length(max = 20, min = 3)
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
    private String from;

    private List<String> defaultRecipients;
    private Map<String, String> additionalHeaders;

    // standard getters and setters

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getDefaultRecipients() {
        return defaultRecipients;
    }

    public void setDefaultRecipients(List<String> defaultRecipients) {
        this.defaultRecipients = defaultRecipients;
    }

    public Map<String, String> getAdditionalHeaders() {
        return additionalHeaders;
    }

    public void setAdditionalHeaders(Map<String, String> additionalHeaders) {
        this.additionalHeaders = additionalHeaders;
    }
}
