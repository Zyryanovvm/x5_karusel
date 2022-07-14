package karusel.web.config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:config/web/${webPlatform}.properties"
})
public interface WebConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://karusel.ru/")
    String baseUrl();
    @Key("browserSize")
    @DefaultValue("1200x900")
    String browserSize();
    @Key("browser")
    @DefaultValue("CHROME")
    String browserName();
    @Key("browserVersion")
    @DefaultValue("103")
    String browserVersion();
    @Key("remoteUrl")
    @DefaultValue("")
    String remoteUrl();
}
