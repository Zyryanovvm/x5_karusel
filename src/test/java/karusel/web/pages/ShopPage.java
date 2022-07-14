package karusel.web.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class ShopPage {

    public ShopPage setCity(String city) {
        step("В инпуте поиска ввести Казань", () -> {
            $("#search").click();
            $("#search").setValue(city);
        });
        return this;
    }

    public ShopPage checkAdress(String adress) {
        step("ОР: Отобразиться адрес магазина в Казани", () -> {
            String actualText = $$(".karusel-dropdown__item").last().getText();
            String expectedText = adress;

            assertThat(actualText).isEqualTo(expectedText);
        });
        return this;
    }
}
