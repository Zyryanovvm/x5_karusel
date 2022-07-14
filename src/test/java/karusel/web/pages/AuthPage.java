package karusel.web.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthPage {
    public AuthPage openAuthPage() {
        step("Перейти по ссылке авторизации пользователя", () ->
                open("https://id.x5.ru/tck?redirect_url=https://karusel.ru/auth/"));
        return this;
    }
    public AuthPage setNumber(String number) {
        step("Ввести некорректный номер +7 111 111 11 12", () ->
                $("#phone").setValue(number));
        return this;
    }
    public AuthPage checkNegativeAllert() {
        step("ОР: Под инпутом отобразиться подсказка Неверный формат номера", () -> {
            String actualText = $(".error_message").getText();
            String expectedText = "Номер телефона должен соответствовать формату +7 9XX XXX-XX-XX";

            assertThat(actualText).isEqualTo(expectedText);
        });
        return this;
    }
}
