package karusel.mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import karusel.mobile.drivers.BrowserStackMobileDriver;
import karusel.mobile.drivers.EmulationMobileDriver;
import karusel.mobile.helpers.Attach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;
import static karusel.mobile.helpers.Attach.sessionId;

public class TestBase {
    static String driver = System.getProperty("deviceHost", "browserstack");

    @BeforeAll
    public static void setup() {
        if (driver.equals("browserstack")) {
            Configuration.browser = BrowserStackMobileDriver.class.getName();
        } else if (driver.equals("emulation")) {
            Configuration.browser = EmulationMobileDriver.class.getName();
        }  else {
            System.out.println("Невозможно запустить тест, так как вы ввели некорректное название стенда!");
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());

        step("Открыть приложение", () -> open());
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        step("Close driver", Selenide::closeWebDriver);

        if (driver.equals("browserstack")) {
            Attach.video(sessionId);
        }
    }

}
