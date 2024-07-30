package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {

    // Поле "Имя"
    private static final By FIRST_NAME_INPUT = By.xpath(".//input[@placeholder='* Имя']");
    // Поле "Фамилия"
    private static final By SECOND_NAME_INPUT = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле "Адрес"
    private static final By ADDRESS_NAME_INPUT = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле "Станция метро"
    private static final By SUBWAY_INPUT = By.xpath(".//input[@placeholder='* Станция метро']");
    // Поле "Телефон"
    private static final By PHONE_INPUT = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private static final By NEXT_BUTTON = By.xpath(".//button[text()='Далее']");
    // Поле "Когда привезти самокат"
    private static final By DATE_INPUT = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Поле "Срок аренды"
    private static final By RENTAL_PERIOD_FIELD = By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    // Чекбокс "Цвет самоката" - чёрный жемчуг
    private static final By BLACK_COLOR_CHECKBOX = By.id("black");
    // Чекбокс "Цвет самоката" - серая безысходность
    private static final By GREY_COLOR_CHECKBOX = By.id("grey");
    // Поле "Комментарий для курьера"
    private static final By COMMENT_INPUT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка "Заказать" в форме заказа
    private static final By ORDER_FORM_ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    // Кнопка "Да" в окне "Хотите оформить заказ?"
    private static final By YES_BUTTON = By.xpath(".//button[text()='Да']");
    // Заголовок окна "Заказ оформлен"
    private static final By ORDER_PROCESSED_HEADER = By.xpath(".//div[contains(text(), 'Заказ оформлен')]");

    private WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
    }

    public void enterSecondName(String secondName) {
        driver.findElement(SECOND_NAME_INPUT).sendKeys(secondName);
    }

    public void enterAddress(String address) {
        driver.findElement(ADDRESS_NAME_INPUT).sendKeys(address);
    }

    public void enterSubwayStation(String subwayStation) {
        WebElement subwayInput = driver.findElement(SUBWAY_INPUT);
        subwayInput.click();
        subwayInput.sendKeys(subwayStation);
        driver.findElement(By.xpath(".//li[@role='menuitem']//div[text()='" + subwayStation + "']")).click();
    }

    public void enterPhone(String phone) {
        driver.findElement(PHONE_INPUT).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(NEXT_BUTTON).click();
    }

    public void enterDate(String date) {
        driver.findElement(DATE_INPUT).sendKeys(date);
        driver.findElement(By.xpath(".//div[contains(@class, 'react-datepicker__day--selected')]")).click();
    }

    public void enterRentalPeriod(String rentalPeriod) {
        driver.findElement(RENTAL_PERIOD_FIELD).click();
        driver.findElement(By.xpath(".//div[@role='option' and text()='" + rentalPeriod + "']")).click();
    }

    public void enterColor(String color) {
        WebElement blackCheckbox = driver.findElement(BLACK_COLOR_CHECKBOX);
        WebElement greyCheckbox = driver.findElement(GREY_COLOR_CHECKBOX);
        if (color.equals("чёрный жемчуг") && !blackCheckbox.isSelected()) {
            blackCheckbox.click();
        } else if (color.equals("серая безысходность") && !greyCheckbox.isSelected()) {
            greyCheckbox.click();
        }
    }

    public void enterComment(String comment) {
        driver.findElement(COMMENT_INPUT).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(ORDER_FORM_ORDER_BUTTON).click();
    }

    public void confirmOrder() {
        driver.findElement(YES_BUTTON).click();
    }

    public Boolean isOrderProcessedTitleDisplayed() {
        return driver.findElement(ORDER_PROCESSED_HEADER).isDisplayed();
    }

    public void fillOrder(String firstName,
                          String secondName,
                          String address,
                          String subwayStation,
                          String phone,
                          String date,
                          String rentalPeriod,
                          String color,
                          String comment) {
        enterFirstName(firstName);
        enterSecondName(secondName);
        enterAddress(address);
        enterSubwayStation(subwayStation);
        enterPhone(phone);
        clickNextButton();
        enterDate(date);
        enterRentalPeriod(rentalPeriod);
        enterColor(color);
        enterComment(comment);
        clickOrderButton();
        confirmOrder();
    }
}
