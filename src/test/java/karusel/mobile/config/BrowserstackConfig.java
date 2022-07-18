package karusel.mobile.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/mobile/browserstack.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("user")
    @DefaultValue("bsuser_Rny98C")
    String user();

    @Key("key")
    @DefaultValue("Cb6KXpGQt4T8YJWz1EbX")
    String key();

    @Key("urlApp")
    @DefaultValue("821c216761980a1461dfc31b3066e61cf277b856")
    String urlApp();

    @Key("deviceName")
    @DefaultValue("Google Pixel 3")
    String deviceName();

    @Key("androidVersion")
    @DefaultValue("9.0")
    String androidVersion();
}
