package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class CardDeliveryOrderHappyPathTest {

    public static String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;


    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }


    @Test
    public void shouldSendCompletedFormWithADateIn3Days() {
        String planningDate = generateDate(3);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));


    }

    @Test
    public void shouldSendCompletedFormWithADateIn4Days() {
        String planningDate = generateDate(4);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormWithADateIn10Days() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormWith2LetterName() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Ру Ян"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormWith1LetterName() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Р Я"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormWithOnlyName() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иван"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormWithHapyhenatedName() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванова Анна-Мария"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormWithSurnameHyphenated() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов-Петров Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormWithSurnameAndNameHyphenated() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов-Петров Василий-Иван"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormPhoneNumberFor8() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов-Петров Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+82226455866");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormPhoneNumberFor9() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов-Петров Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+92226455866");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormPhoneNumberFor3() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов-Петров Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+32226455866");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormPhoneNumberFor1() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов-Петров Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+12226455866");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormPhoneNumberFor0() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов-Петров Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+02226455866");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormPhoneNumberWithTheSameDigits() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов-Петров Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+99999999999");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormWithEmptyFieldDate() {
        String planningDate = generateDate(3);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $x("//*[@name=\"name\"]").setValue("Иванов Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormNarianMar() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Нарьян-Мар"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов-Петров Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+99999999999");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormAnadir() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Анадырь"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов-Петров Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+99999999999");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormTambov() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Тамбов"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов-Петров Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+99999999999");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormSaransk() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Саранск"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов-Петров Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+99999999999");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormGrozniy() {
        String planningDate = generateDate(10);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Грозный"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов-Петров Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+99999999999");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));

    }


}
