
package ru.netology;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.Keys;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class CardWithDeliveryTest {
    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldSendingAFormWithValidData1() {


        $x("//*[@placeholder = \"Город\"]").setValue("Казань");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Иванов Андрей");
        $x("//*[@name = \"phone\"]").setValue("+79214567845");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Успешно!\")]").should(visible, Duration.ofSeconds(12));
    }

    @Test
    public void shouldSendingAFormWithValidData2() {


        $x("//*[@placeholder = \"Город\"]").setValue("Калуга");
        String verificationDate = LocalDate.now().plusDays(10).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Андреев Иван");
        $x("//*[@name = \"phone\"]").setValue("+79126547467");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Успешно!\")]").should(visible, Duration.ofSeconds(12));
    }

    @Test
    public void shouldEnteringInvalidDataInTheCityField() {

        $x("//*[@placeholder = \"Город\"]").setValue("Kazan");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Иванов Андрей");
        $x("//*[@name = \"phone\"]").setValue("+79214567845");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Доставка в выбранный город недоступна\")]").should(visible, Duration.ofSeconds(12));

    }

    @Test
    public void shouldClearingTheCityField() {

        $x("//*[@placeholder = \"Город\"]").setValue("");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Иванов Андрей");
        $x("//*[@name = \"phone\"]").setValue("+79214567845");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Поле обязательно для заполнения\")]").should(visible, Duration.ofSeconds(12));

    }

    @Test
    public void shouldClearingTheDateOfTheMeetingField() {

        $x("//*[@placeholder = \"Город\"]").setValue("Казань");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern(""));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Иванов Андрей");
        $x("//*[@name = \"phone\"]").setValue("+79214567845");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Неверно введена дата\")]").should(visible, Duration.ofSeconds(12));


    }

    @Test
    public void shouldEnteringInvalidDataInTheLastNameAndFirstNameField() {

        $x("//*[@placeholder = \"Город\"]").setValue("Казань");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Ivanov Andrey");
        $x("//*[@name = \"phone\"]").setValue("+79214567845");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.\")]").should(visible, Duration.ofSeconds(12));


    }

    @Test
    public void shouldClearingTheLastNameAndFirstNameField() {

        $x("//*[@placeholder = \"Город\"]").setValue("Казань");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("");
        $x("//*[@name = \"phone\"]").setValue("+79214567845");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Поле обязательно для заполнения\")]").should(visible, Duration.ofSeconds(12));


    }

    @Test
    public void shouldEnteringInvalidDataInTheMobilePhoneField() {

        $x("//*[@placeholder = \"Город\"]").setValue("Казань");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Иванов Андрей");
        $x("//*[@name = \"phone\"]").setValue("9214567845");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.\")]").should(visible, Duration.ofSeconds(12));


    }

    @Test
    public void shouldClearingTheMobilePhoneField() {

        $x("//*[@placeholder = \"Город\"]").setValue("Казань");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Иванов Андрей");
        $x("//*[@name = \"phone\"]").setValue("");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Поле обязательно для заполнения\")]").should(visible, Duration.ofSeconds(12));


    }

    @Test
    public void shouldTestCheckboxAgreement() {

        $x("//*[@placeholder = \"Город\"]").setValue("Казань");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Иванов Андрей");
        $x("//*[@name = \"phone\"]").setValue("+79214567845");
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Я соглашаюсь с условиями обработки и использования моих персональных данных\")]").should(visible, Duration.ofSeconds(12));

    }
}


