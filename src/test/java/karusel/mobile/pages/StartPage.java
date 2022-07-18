package karusel.mobile.pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class StartPage {

    public StartPage goToSlideSeven() {
        step("Нажимать на Далее до 7ой страницы приветственной стори", () -> {
            $$(AppiumBy.className("android.widget.TextView")).last().click();
            $$(AppiumBy.className("android.widget.TextView")).last().click();
            $$(AppiumBy.className("android.widget.TextView")).last().click();
            $$(AppiumBy.className("android.widget.TextView")).last().click();
            $$(AppiumBy.className("android.widget.TextView")).last().click();
            $$(AppiumBy.className("android.widget.TextView")).last().click();
            $$(AppiumBy.className("android.widget.TextView")).last().click();
        });
        return this;
    }

    public StartPage skipWelcomeStory() {
        step("Пролистать начальную сторю", () -> {
            $$(AppiumBy.className("android.widget.TextView")).last().click();
            $$(AppiumBy.className("android.widget.TextView")).last().click();
            $$(AppiumBy.className("android.widget.TextView")).last().click();
            $$(AppiumBy.className("android.widget.TextView")).last().click();
            $$(AppiumBy.className("android.widget.TextView")).last().click();
            $$(AppiumBy.className("android.widget.TextView")).last().click();
            $$(AppiumBy.className("android.widget.TextView")).last().click();
            $$(AppiumBy.className("android.widget.TextView")).last().click();
        });
        return this;
    }

    public StartPage assertHeaderFromFirstSlideStory() {
        step("ОР: На стартовой страницу должен отображаться заголовок", () -> {
            String actualText = $$(AppiumBy.className("android.widget.TextView")).first().getText();
            String expectedText = "Научим экономить!";

            assertThat(actualText).isEqualTo(expectedText);
        });
        return this;
    }

    public StartPage assertButtonFromSevenSlideStory() {
        step("ОР: На месте кнопки 'Далее' должна отобразиться 'Прекрасно!'", () -> {
            String actualText = $$(AppiumBy.className("android.widget.TextView")).last().getText();
            String expectedText = "Прекрасно!";

            assertThat(actualText).isEqualTo(expectedText);
        });
        return this;
    }

    public StartPage checkStockFromHomeScreen() {
        step("ОР: После закрытия отобразится главный экран с окном Авторизации", () -> {
            String actualText = $$(AppiumBy.className("android.widget.TextView")).get(1).getText();
            String expectedText = "Войти";

            assertThat(actualText).isEqualTo(expectedText);
        });
        return this;
    }

    public StartPage goToAuth() {
        step("Вверху главного экрана нажать на кнопку войти", () ->
                $$(AppiumBy.className("android.widget.TextView")).get(1).click());
        return this;
    }

    public StartPage checkAuthScreen() {
        step("Вверху главного экрана нажать на кнопку войти", () ->
                $$(AppiumBy.className("android.widget.TextView")).get(1).click());
        return this;
    }

    public StartPage goToStock() {
        step("В нижнем баре нажать на иконку Акции", () ->
                $$(AppiumBy.className("android.widget.Button")).get(2).click());
        return this;
    }

    public StartPage checkStockScreen() {
        step("ОР: Отобразиться страница с Акциями", () -> {
            String actualText = $$(AppiumBy.className("android.widget.TextView")).first().getText();
            String expectedText = "Акции";

            assertThat(actualText).isEqualTo(expectedText);
        });
        return this;
    }


}
