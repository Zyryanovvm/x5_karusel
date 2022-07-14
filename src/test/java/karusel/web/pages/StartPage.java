package karusel.web.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class StartPage {

    public StartPage openStartPage() {
        step("Открыть web страницу https://karusel.ru/", () ->
                open(""));
        return this;
    }

    public StartPage checkConsole() {
        step("ОР: Страница главная страница, в консоли нет SEVERE ошибок", () -> {
            String consoleLogs = String.join("\n", Selenide.getWebDriverLogs(BROWSER));
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
        return this;
    }

    public StartPage checkTitle() {
        step("Проверить корректно ли отображается title", () -> {
            String expectedTitle = "Карусель | Главная";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
        return this;
    }

    public StartPage clickAnotherCity() {
        step("Во всплывающем окне выбора города кликнуть на Нет, другой", () ->
                $$(".karusel-prompt__btn").findBy(text("Нет, другой")).click());
        return this;
    }

    public StartPage clickYesCity() {
        step("Во всплывающем окне выбора города кликнуть на Да", () ->
                $(".city-picker-prompt__btn").click());
        return this;
    }

    public StartPage citySelection(String city) {
        step("Выбрать из списка город Уфа", () ->
                $$(".cities-list li").findBy(text(city)).click());
        return this;
    }

    public StartPage checkCity(String city) {
        step("ОР: В верхнем правом углу отображается город Уфа", () -> {
            String actualText = $(".city-picker__btn").getText();
            String expectedText = city;

            assertThat(actualText).isEqualTo(expectedText);
        });
        return this;
    }

    public StartPage goCatalog() {
        step("В верхнем баре кликнуть на Каталог", () ->
                $$(".app-nav-list__item").get(0).click());
        return this;
    }

    public StartPage goShop() {
        step("В верхнем баре кликнуть на Магазины", () ->
                $$(".app-nav-list__item").get(3).click());
        return this;
    }
}
