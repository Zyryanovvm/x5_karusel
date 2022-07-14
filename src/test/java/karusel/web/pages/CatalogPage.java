package karusel.web.pages;

import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class CatalogPage {

    public CatalogPage checkNamePage() {
        step("ОР: Откроется страница Каталога товаров", () -> {
            String actualText = $$(".justify-content-between h2").get(0).getText();
            String expectedText = "Каталог";

            assertThat(actualText).isEqualTo(expectedText);
        });
        return this;
    }
}
