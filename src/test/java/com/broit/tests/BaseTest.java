package com.broit.tests;

import com.broit.forms.ShopForm;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    @BeforeAll
    public static void setupAllure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
            .savePageSource(false)
        );
    }

    @BeforeEach
    public void open() {
        Selenide.open(Configuration.baseUrl);
        ShopForm.switchToShop();
    }

    @AfterEach
    public void clearBrowser() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.sessionStorage().clear();
    }
}
