package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.model.MainPage;
import ru.yandex.praktikum.model.OrderPage;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String subwayStation;
    private final String phone;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderTest(String firstName, String secondName, String address, String subwayStation, String phone, String date, String rentalPeriod, String color, String comment) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phone = phone;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"Иван", "Иванов", "Москва, ул. Шоссейная, д. 18, кв. 123", "Печатники", "77777777777", "10.08.2024", "сутки", "серая безысходность", "домофон не работает"},
                {"Пётр", "Петров", "Москва, ул. Абрамцевская, д. 2, кв. 123", "Алтуфьево", "88888888888", "12.12.2024", "семеро суток", "чёрный жемчуг", ""},
        };
    }

    @Test
    public void makeOrderWithValidDataUsingOrderButtonInHeader() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.confirmCookie();
        mainPage.clickOrderButtonInHeader();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrder(firstName,
                secondName,
                address,
                subwayStation,
                phone,
                date,
                rentalPeriod,
                color,
                comment);
        Assert.assertTrue(orderPage.isOrderProcessedTitleDisplayed());
    }

    @Test
    public void makeOrderWithValidDataUsingOrderButtonInHowItWorksSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.confirmCookie();
        mainPage.clickOrderButtonInHowItWorksSection();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrder(firstName,
                secondName,
                address,
                subwayStation,
                phone,
                date,
                rentalPeriod,
                color,
                comment);
        Assert.assertTrue(orderPage.isOrderProcessedTitleDisplayed());
    }
}
