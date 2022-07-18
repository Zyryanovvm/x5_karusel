package karusel.mobile.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import karusel.mobile.pages.StartPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Story("Тестирование Mobile")
@Owner("allure8")
@Feature("Тестирование web, mobile, api приложений Карусель")
@Tag("mobile")
public class KaruselMobileTests extends TestBase {
    StartPage startPage = new StartPage();

    @Test
    @AllureId("11217")
    @DisplayName("Проверка корректности заголовка на первой странице приветственной стори")
    public void firstPageTest() {
        startPage.assertHeaderFromFirstSlideStory();
    }

    @Test
    @AllureId("11218")
    @DisplayName("Проверка изменения кнопки на 7 слайде приветственной стори")
    public void sevenPageTest() {
        startPage.goToSlideSeven()
                .assertButtonFromSevenSlideStory();
    }

    @Test
    @AllureId("11219")
    @DisplayName("Проверка отображения авторизации на главном экране")
    public void startPageTest() {
        startPage.skipWelcomeStory()
                .checkStockFromHomeScreen();
    }

    @Test
    @AllureId("11220")
    @DisplayName("Проверка работы кнопки Войти на главном экране")
    public void authButtonTest() {
        startPage.skipWelcomeStory()
                .goToAuth()
                .checkAuthScreen();
    }

    @Test
    @AllureId("11221")
    @DisplayName("Проверка перехода во вкладку Акции")
    public void salePageTest() {
        startPage.skipWelcomeStory()
                .goToStock()
                .checkStockScreen();
    }
}
