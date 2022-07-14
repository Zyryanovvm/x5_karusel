package karusel.web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import karusel.web.config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import karusel.web.drivers.DriverSettings;
import karusel.web.helpers.Attach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    static WebConfig config = ConfigFactory.create(WebConfig.class);
    static String useRemote = System.getProperty("webPlatform", "local");

    @BeforeAll
    static void firstSetup() {
        DriverSettings.configuration();
        if (useRemote.equals("remote")) {
            Configuration.remote = config.remoteUrl();
        }
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs();
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (useRemote.equals("remote")) {
            Attach.addVideo();
        }
        closeWebDriver();
    }



}
