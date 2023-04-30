package qa.guru.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"}
)

public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    Browser browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("baseUrl")
    @DefaultValue("https://www.moviefone.com/")
    String baseUrl();

    @DefaultValue("false")
    @Key("isRemote")
    boolean isRemote();

    @Key("remoteUrl")
    String remoteUrl();

}