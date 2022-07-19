# Проект по тестированию WEB, Mobile и API платформ [Гипермаркета КАРУСЕЛЬ](https://karusel.ru/)

## Содержание:

- <a href="#computer-технологии-используемые-в-данном-проекте">Технологии, используемые в данном проекте</a>
- <a href="#clipboard-тест-кейсы-в-Allure-TestOps">Тест кейсы в Allure TestOps</a>
- <a href="#robot-сборка-в-Jenkins">Сборка в Jenkins</a>
- <a href="#bar_chart-отчеты-по-тестированию-в-Allure-report">Отчеты по тестированию в Allure report</a>
- <a href="#bar_chart-интеграция-с-AllureTestOps">Интеграция с AllureTestOps</a>
- <a href="#уведомление-в-Telegram">Уведомление в Telegram</a>

* [Технологии, используемые в данном проекте](https://github.com/SvetlanaVaskevich/qa_guru_diplom#%D1%82%D0%B5%D1%85%D0%BD%D0%BE%D0%BB%D0%BE%D0%B3%D0%B8%D0%B8-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D1%83%D0%B5%D0%BC%D1%8B%D0%B5-%D0%B2-%D0%B4%D0%B0%D0%BD%D0%BD%D0%BE%D0%BC-%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B5)
* [Тест кейсы](https://github.com/SvetlanaVaskevich/qa_guru_diplom#%D1%82%D0%B5%D1%81%D1%82-%D0%BA%D0%B5%D0%B9%D1%81%D1%8B)
* [Сборка в Jenkins](https://github.com/SvetlanaVaskevich/qa_guru_diplom#%D1%81%D0%B1%D0%BE%D1%80%D0%BA%D0%B0-%D0%B2-jenkins)
* [Информация о тестах в Allure report]()
* [Интеграция с AllureTestOps]()

## :computer: Технологии, используемые в данном проекте

[<img alt="Java" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Java.svg" width="50"/>](https://www.java.com/)
[<img alt="IDEA" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Idea.svg" width="50"/>](https://www.jetbrains.com/idea/)
[<img alt="Appium" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Appium.svg" width="50"/>](https://appium.io/)
[<img alt="Selenide" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Selenide.svg" width="50"/>](https://ru.selenide.org/)
[<img alt="Selenoid" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Selenoid.svg" width="50"/>](https://aerokube.com/selenoid/latest/)
[<img alt="Android" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Android.svg" width="50"/>](https://developer.android.com/studio)
[<img alt="Browserstack" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Browserstack.svg" width="50"/>](https://www.browserstack.com/)
[<img alt="Github" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/GitHub.svg" width="50"/>](https://github.com/)
[<img alt="JUnit 5" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Junit5.svg" width="50"/>](https://junit.org/junit5/)
[<img alt="Gradle" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Gradle.svg" width="50"/>](https://gradle.org/)
[<img alt="Allure" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Allure.svg" width="50"/>](https://github.com/allure-framework/allure2)
[<img alt="Allure_EE" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Allure_EE.svg" width="50"/>](https://qameta.io/)
[<img alt="Jenkins" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Jenkins.svg" width="50"/>](https://www.jenkins.io/)

В данном проекте сценарии автотестов написаны в **AllureTestOps**.

Сами автотесты написаны на **Java** с использованием фреймворка для тестирования **Selenide**. Для сборки проекта в среде **IntelliJ IDEA** используется **Gradle**. **JUnit5** задействован в качестве фреймворка модульного тестирования. Запуск тестов выполняется из **Jenkins**. **Selenoid** используется для запуска браузеров в контейнерах **Docker**.

**Browserstack** используется для запуска мобильных тестов. Для запуска на эмуляторе используются **Android Studio** и **Appium**.

Отчеты по результатам прогона автотестов формируются в **Allure Report**, **AllureTestOps**.

Так же настроена отправка уведомленний в **Telegram**.

## :clipboard: Тест кейсы в Allure TestOps

- ### Тест кейсы для WEB тестирования
<p align="center">
<img title="" src="images/Allure TestOps/web testcase.png">
</p>

- ### Тест кейсы для MOBILE тестирования
<p align="center">
<img title="" src="images/Allure TestOps/mobile testcase.png">
</p>

- ### Тест кейсы для API тестирования
<p align="center">
<img title="" src="images/Allure TestOps/api testcase.png">
</p>

## :robot: [Сборка в Jenkins](https://jenkins.autotests.cloud/job/x5_karusel/)
<p align="center">
<img title="" src="images/Jenkins/jenkins 1.png">
</p>

<p align="center">
<img title="" src="images/Jenkins/jenkins param.png">
</p>

Перед началом запуска сборки мы можем выбрать следующие параметры:

_AUTOTESTS_ - выбрать автоесты на какую платформу мы хотим запустить.

_WEBPLATFOTM_ - платформу для запуска WEB автотестов.

_MOBILEDEVICEHOST_ - платформу для запуска MOBILE автотестов.

### Так же можно настраивать параметры запуска автотестов в .properties файлах
Пример local.properties
<p align="center">
<img title="" src="images/Jenkins/jenkins proper.png">
</p>

## :bar_chart: Отчеты по тестированию в [Allure report](https://jenkins.autotests.cloud/job/x5_karusel/21/allure/)

### Главное окно
<p align="center">
<img title="" src="images/Allure Report/head page.png">
</p>

### Окно с тестовыми кейсами
В данном окне мы можем подробно изучить результаты прогона автотеста. Посмотреть тестовые данные, шаги автотеста, проверки.

Так же во вкладке _Tear down_ изучить скриншоты последней страницы, браузерную консоль и видео запись прохождения автотеста.
<p align="center">
<img title="" src="images/Allure Report/test run report.png">
</p>

### :film_projector: Пример видео записи мобильного автотеста №11221 по переходу во вкладку Акции.
<p align="center">
<img title="" src="images/Allure Report/mobile video.gif">
</p>

## :bar_chart: Интеграция с [AllureTestOps](https://allure.autotests.cloud/launch/14525)
### Так же все отчеты можно посмотреть в *Allure TestOps*
<p align="center">
<img title="" src="images/Allure TestOps/report.png">
</p>
<p align="center">
<img title="" src="images/Allure TestOps/run.png">
</p>


## Уведомление в Telegram

После завершения тестов отчет о прохождении приходит в Telegram-чат
<p align="center">
<img title="" src="images/Telegram/QR Telegramm.png">
</p>

Пример отчета
<p align="center">
<img title="" src="images/Telegram/report.png">
</p>
