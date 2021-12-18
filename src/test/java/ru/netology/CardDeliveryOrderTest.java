package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryOrderTest {

    public static String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;


    @Test
    public void shouldSendCompletedForm() {
        Configuration.holdBrowserOpen = true;
        //Открыть приложение
        open("http://localhost:7777");
        //Заполнить поле Город
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        //Заполнить поле Дата встречи спредставителем банка
        $("[data-test-id='date'] .input__control").sendKeys(deleteString);
        $("[data-test-id='date'] .input__control").setValue("22122021");
        //Заполнить поле Фамилия Имя
        $x("//*[@name=\"name\"]").setValue("Иванов Василий");
        //Заполнить поле Мобильный телефон
        $x("//*[@name=\"phone\"]").setValue("+79998885566");
        //Кликнуть чекбокс
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        //Нажать кнопку Забронировать
        $(".button__text").click();
        //Подождать 15 сек
        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на 22.12.2021"), Duration.ofSeconds(15));
        //Получить всплывающее окно с сообщением "Успешно! Встреча успешно забранирована на

    }
}
