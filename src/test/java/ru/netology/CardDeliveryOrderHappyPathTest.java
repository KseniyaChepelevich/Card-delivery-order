package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class CardDeliveryOrderHappyPathTest {

    public static String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;


    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }


    @Test
    public void shouldSendCompletedForm() {
        Configuration.holdBrowserOpen = true;
        //Открыть приложение
        open("http://localhost:9999");
        //Заполнить поле Город
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        //Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);
        $("[data-test-id='date'] .input__control").setValue("23122021");
        //Заполнить поле Фамилия Имя
        $x("//*[@name=\"name\"]").setValue("Иванов Василий");
        //Заполнить поле Мобильный телефон
        $x("//*[@name=\"phone\"]").setValue("+79998885566");
        //Кликнуть чекбокс
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        //Нажать кнопку Забронировать
        $(".button__text").click();
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на 23.12.2021"), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на

    }

    @Test
    public void shouldSendCompletedFormWithADateIn3Days() {
        Configuration.holdBrowserOpen = true;
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


    }

    @Test
    public void shouldSendCompletedFormWithADateIn4Days() {
        Configuration.holdBrowserOpen = true;
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


    }

    @Test
    public void shouldSendCompletedFormWithADateIn10Days() {
        Configuration.holdBrowserOpen = true;
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


    }

    @Test
    public void shouldSendCompletedFormWith2LetterName() {
        Configuration.holdBrowserOpen = true;
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


    }

    @Test
    public void shouldSendCompletedFormWith1LetterName() {
        Configuration.holdBrowserOpen = true;
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


    }

    @Test
    public void shouldSendCompletedFormWithOnlyName() {
        Configuration.holdBrowserOpen = true;
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


    }

    @Test
    public void shouldSendCompletedFormWithHapyhenatedName() {
        Configuration.holdBrowserOpen = true;
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


    }

    @Test
    public void shouldSendCompletedFormWithSurnameHyphenated() {
        Configuration.holdBrowserOpen = true;
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


    }

    @Test
    public void shouldSendCompletedFormWithSurnameAndNameHyphenated() {
        Configuration.holdBrowserOpen = true;
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


    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormPhoneNumberFor8() {
        Configuration.holdBrowserOpen = true;
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


    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormPhoneNumberFor9() {
        Configuration.holdBrowserOpen = true;
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


    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormPhoneNumberFor3() {
        Configuration.holdBrowserOpen = true;
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


    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormPhoneNumberFor1() {
        Configuration.holdBrowserOpen = true;
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


    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormPhoneNumberFor0() {
        Configuration.holdBrowserOpen = true;
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


    }

    @Test
    public void shouldSendCompletedFormshouldSendTheCompletedFormPhoneNumberWithTheSameDigits() {
        Configuration.holdBrowserOpen = true;
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


    }

    @Test
    public void shouldSendCompletedFormWithEmptyFieldDate() {
        Configuration.holdBrowserOpen = true;
        String planningDate = generateDate(3);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $x("//*[@name=\"name\"]").setValue("Иванов Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));


    }


}
