/**
 * Telescopic constructor == constructor chaining
 */
public class UrlTelescopicWithoutBuilder {
    private String protocol;
    private String hostname;
    private String port;
    private String pathParam;
    private String queryParam;

    public UrlTelescopicWithoutBuilder() {
    }
    public UrlTelescopicWithoutBuilder(String protocol) {
        this.protocol = protocol;
    }
    public UrlTelescopicWithoutBuilder(String protocol, String hostname) {
        this(protocol);
        this.hostname = hostname;
    }
    public UrlTelescopicWithoutBuilder(String protocol, String hostname, String port) {
        this(protocol, hostname);
        this.port = port;
    }
    public UrlTelescopicWithoutBuilder(String protocol, String hostname, String port, String pathParam) {
        this(protocol,hostname,port);
        this.pathParam = pathParam;
    }
    public UrlTelescopicWithoutBuilder(String protocol, String hostname, String port, String pathParam, String queryParam) {
        this(protocol, hostname, port, pathParam);
        this.queryParam = queryParam;
    }
    public String getProtocol() {
        return protocol;
    }
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
    public String getHostname() {
        return hostname;
    }
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public String getPathParam() {
        return pathParam;
    }
    public void setPathParam(String pathParam) {
        this.pathParam = pathParam;
    }
    public String getQueryParam() {
        return queryParam;
    }
    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

}