/**
 * This is my Driver class
 */
public class Main {
    public static void main(String[] args) {

        /**
         * calling URL class without Builder
         */
/*        UrlWithoutBuilder url = new UrlWithoutBuilder();
        url.setProtocol("https://");
        url.setHostname("mywebsite");
        url.setPort(":8080/");
        url.setPathParam("homepage/");
        url.setQueryParam("random");
        System.out.print(url.getProtocol());
        System.out.print(url.getHostname());
        System.out.print(url.getPort());
        System.out.print(url.getPathParam());
        System.out.print(url.getQueryParam());*/

        /**
         * calling URL class with Telescopic constructor design
         */

        /**
         * Builder Design Pattern
         */
        System.out.println("Object with Builder Design Pattern (Protocol, Hostname, Port): ");
        URLBuilder.Builder builder = new URLBuilder.Builder();
        builder.protocol("https://")
                .hostname("sp.com/")
                .port("8080");

        URLBuilder UrlBuilder = builder.build();

        System.out.print(UrlBuilder.protocol);
        System.out.print(UrlBuilder.hostname);
        System.out.print(UrlBuilder.port);

        System.out.println(" ");

        System.out.println("Object with Builder Design Pattern (Protocol, Hostname, Path Param): ");
        URLBuilder.Builder builder2 = new URLBuilder.Builder();
        builder2.protocol("https://").hostname("mywebsite2").pathParam("/abc");

        URLBuilder urlBuilder2 = builder2.build();

        System.out.print(urlBuilder2.protocol);
        System.out.print(urlBuilder2.hostname);
        System.out.print(urlBuilder2.pathParam );
    }
}