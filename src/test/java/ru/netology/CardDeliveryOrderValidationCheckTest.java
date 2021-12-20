package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class CardDeliveryOrderValidationCheckTest {

    public static String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;


    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }

    @Test
    public void shouldSendTheEmptyForm() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999"); //Открыть приложение
        $(".button__text").click();//Нажать кнопку Забронировать
        $("[data-test-id='city'].input_invalid .input__sub").shouldHave(text("Поле обязательно для заполнения"));


    }

    @Test
    public void shouldSendCompletedFormWithEmptyFieldCity() {
        Configuration.holdBrowserOpen = true;
        String planningDate = generateDate(3);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id='date'] input").doubleClick().sendKeys(deleteString);
        ;//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id='city'].input_invalid .input__sub").shouldHave(text("Поле обязательно для заполнения"));


    }

    @Test
    public void shouldSendCompletedFormWithEmptyFieldName() {
        Configuration.holdBrowserOpen = true;
        String planningDate = generateDate(3);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] input").doubleClick().sendKeys(deleteString);
        ;//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue(""); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(text("Поле обязательно для заполнения"));


    }

    @Test
    public void shouldSendCompletedFormWithEmptyFieldPhone() {
        Configuration.holdBrowserOpen = true;
        String planningDate = generateDate(3);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] input").doubleClick().sendKeys(deleteString);
        ;//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(text("Поле обязательно для заполнения"));


    }

    @Test
    public void shouldSendCompletedFormWithoutClickInCheckbox() {
        Configuration.holdBrowserOpen = true;
        String planningDate = generateDate(5);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] input").doubleClick().sendKeys(deleteString);
        ;//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон

        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id='agreement'] .checkbox__text").shouldHave(text("Я соглашаюсь с условиями обработки и использования моих персональных данных"));


    }


    @Test
    public void shouldSendCompletedFormWithADateIn1Days() {
        Configuration.holdBrowserOpen = true;
        String planningDate = generateDate(1);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] input").doubleClick().sendKeys(deleteString);
        ;//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id='date'] .input_invalid .input__sub").shouldHave(text("Заказ на выбранную дату невозможен"));


    }

    @Test
    public void shouldSendCompletedFormWithADateIn2Days() {
        Configuration.holdBrowserOpen = true;
        String planningDate = generateDate(2);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] input").doubleClick().sendKeys(deleteString);
        ;//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id='date'] .input_invalid .input__sub").shouldHave(text("Заказ на выбранную дату невозможен"));


    }

    @Test
    public void shouldSendCompletedFormWithADateIn0Days() {
        Configuration.holdBrowserOpen = true;
        String planningDate = generateDate(0);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //Заполнить поле Город
        $("[data-test-id='date'] input").doubleClick().sendKeys(deleteString);
        ;//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id='date'] .input_invalid .input__sub").shouldHave(text("Заказ на выбранную дату невозможен"));


    }

    @Test
    public void shouldSendCompletedFormWithCityKiev() {
        Configuration.holdBrowserOpen = true;
        String planningDate = generateDate(1);
        open("http://localhost:9999"); //Открыть приложение
        $("[data-test-id=\"city\"] .input__control").setValue("Киев"); //Заполнить поле Город
        $("[data-test-id='date'] input").doubleClick().sendKeys(deleteString);
        ;//Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name=\"name\"]").setValue("Иванов Василий"); //Заполнить поле Фамилия Имя
        $x("//*[@name=\"phone\"]").setValue("+79998885566");//Заполнить поле Мобильный телефон
        $("[data-test-id=\"agreement\"] .checkbox__box").click();//Кликнуть чекбокс
        $(".button__text").click();//Нажать кнопку Забронировать
        //Подождать 15 сек
        $("[data-test-id='city'].input_invalid .input__sub").shouldHave(text("Доставка в выбранный город недоступна"));


    }
}
