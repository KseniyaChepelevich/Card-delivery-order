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

public class CardDeliveryOrderTest {

    public static String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;






    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }




    @Test
    public void shouldSendCompletedForm() {
        Configuration.holdBrowserOpen = true;
        //Открыть приложение
        open("http://localhost:7777");
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
    public void shouldSendCompletedFormWithADate3Days() {
        Configuration.holdBrowserOpen = true;
        String planningDate = generateDate(1);
        open("http://localhost:7777"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);;//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id='date'] .input_invalid .input__sub").shouldHave(text("Заказ на выбранную дату невозможен"));




    }

    @Test
    public void shouldSendCompletedFormWithADateLessThan3Days() {
        Configuration.holdBrowserOpen = true;
        String planningDate = generateDate(2);
        open("http://localhost:7777"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на "+planningDate), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на


    }
}
