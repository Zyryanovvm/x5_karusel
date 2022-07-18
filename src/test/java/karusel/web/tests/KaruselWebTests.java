package karusel.web.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import karusel.web.pages.AuthPage;
import karusel.web.pages.CatalogPage;
import karusel.web.pages.ShopPage;
import karusel.web.pages.StartPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Story("Тестирование WEB")
@Owner("allure8")
@Feature("Тестирование web, mobile, api приложений Карусель")
@Tag("web")
@Tag("allTests")
public class KaruselWebTests extends TestBase {

    String city = "Уфа",
            cityForAddress = "Казань",
            expectedAddress = "Казань,Оренбургский Тракт ГИПЕ 420064, " +
                    "Татарстан Респ, Казань г, Оренбургский Тракт ул, 170";
//            negativeAuthNumber = "1111111112";


    StartPage startPage = new StartPage();
    CatalogPage catalogPage = new CatalogPage();
    ShopPage shopPage = new ShopPage();
    AuthPage authPage = new AuthPage();

    @Test
    @Disabled
    @AllureId("11189")
    @DisplayName("Проверка отсутствия SEVERE ошибок в консоли при открытии стартовой страницы")
    public void openStartPageTest() {
        startPage.openStartPage()
                .checkConsole();
    }

    @Test
    @AllureId("11190")
    @DisplayName("Наличие корректного title")
    public void titleTest() {
        startPage.openStartPage()
                .checkTitle();
    }

    @Test
    @AllureId("11191")
    @DisplayName("Изменение города")
    public void changeCityTest() {
        startPage.openStartPage()
                .clickAnotherCity()
                .citySelection(city)
                .checkCity(city);
    }

    @Test
    @AllureId("11192")
    @DisplayName("Переход во вкладку Каталог")
    public void productRatingTest() {
        startPage.openStartPage()
                .clickYesCity()
                .goCatalog();
        catalogPage.checkNamePage();
    }

    @Test
    @AllureId("11193")
    @DisplayName("Поиск списка магазина в городе Казань")
    public void searchCityListTest() {
        startPage.openStartPage()
                .clickYesCity()
                .goShop();
        shopPage.setCity(cityForAddress);

        shopPage.checkAdress(expectedAddress);
    }

    @ValueSource(strings = {
            "1111111112",
            "2111111112",
            "3111111112"
    })
    @ParameterizedTest()
    @AllureId("11194")
    @DisplayName("Авторизация. Ввод некорректных данных. Parametrized Tests")
    public void authNegativeTests(String negativeAuthNumber) {
        authPage.openAuthPage()
                .setNumber(negativeAuthNumber)
                .checkNegativeAllert();
    }
}
