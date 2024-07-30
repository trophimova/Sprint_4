package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {

    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    // Кнопка "Заказать" в хэдере
    private static final By HEADER_ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g' and text()='Заказать']");
    // Кнопка "Заказать" в разделе "Как это работает"
    private static final By HOW_IT_WORKS_ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    // Раздел Вопросы о важном
    // Список заголовков вопросов
    public static final By QUESTION_HEADINGS = By.xpath(".//div[@data-accordion-component='AccordionItemButton']");
    // Список ответов на вопросы
    public static final By ANSWER_HEADINGS = By.xpath(".//div[@data-accordion-component='AccordionItemPanel']/p");
    // Кнопка принятия куки "да все привыкли"
    private static final By CONFIRM_COOKIE_BUTTON = By.id("rcc-confirm-button");

    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PAGE_URL);
    }

    public void clickOrderButtonInHeader() {
        driver.findElement(HEADER_ORDER_BUTTON).click();
    }

    public void clickOrderButtonInHowItWorksSection() {
        driver.findElement(HOW_IT_WORKS_ORDER_BUTTON).click();
    }

    public String getQuestionTitleByIndex(int index) {
        List<WebElement> questionHeadings = driver.findElements(QUESTION_HEADINGS);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", questionHeadings.get(index));
        return questionHeadings.get(index).getText();
    }

    public void clickQuestionTitleByIndex(int index) {
        List<WebElement> questionHeadings = driver.findElements(QUESTION_HEADINGS);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", questionHeadings.get(index));
        questionHeadings.get(index).click();
    }

    public String getAnswerTitleByIndex(int index) {
        List<WebElement> answerHeadings = driver.findElements(ANSWER_HEADINGS);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> (answerHeadings.get(index).getText() != null
                && !answerHeadings.get(index).getText().isEmpty()
        ));
        return answerHeadings.get(index).getText();
    }

    public void confirmCookie() {
        driver.findElement(CONFIRM_COOKIE_BUTTON).click();
    }
}
