
package ru.netology;


import com.codeborne.selenide.Condition;
import io.github.bonigarcia.wdm.WebDriverManager;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.module.Configuration;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardWithDeliveryTest {


    @Test
    public void test1() {

        open("http://localhost:9999");
        $x("//*[@placeholder = \"Город\"]").setValue("Казань");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("20.09.2022"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Иванов Андрей");
        $x("//*[@name = \"phone\"]").setValue("+79214567845");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Успешно!\")]").should(visible, Duration.ofSeconds(12));
    }

    @Test
    public void test2() {

        open("http://localhost:9999");
        $x("//*[@placeholder = \"Город\"]").setValue("Калуга");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("27.10.2022"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Андреев Иван");
        $x("//*[@name = \"phone\"]").setValue("+79126547467");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Успешно!\")]").should(visible, Duration.ofSeconds(12));
    }

    @Test
    public void test3() {
        open("http://localhost:9999");
        $x("//*[@placeholder = \"Город\"]").setValue("Kazan");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("20.09.2022"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Иванов Андрей");
        $x("//*[@name = \"phone\"]").setValue("+79214567845");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Доставка в выбранный город недоступна\")]").should(visible, Duration.ofSeconds(12));

    }

    @Test
    public void test4() {
        open("http://localhost:9999");
        $x("//*[@placeholder = \"Город\"]").setValue("");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("20.09.2022"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Иванов Андрей");
        $x("//*[@name = \"phone\"]").setValue("+79214567845");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Поле обязательно для заполнения\")]").should(visible, Duration.ofSeconds(12));

    }

    @Test
    public void test5() {
        open("http://localhost:9999");
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
    public void test6() {
        open("http://localhost:9999");
        $x("//*[@placeholder = \"Город\"]").setValue("Казань");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("20.09.2022"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Ivanov Andrey");
        $x("//*[@name = \"phone\"]").setValue("+79214567845");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.\")]").should(visible, Duration.ofSeconds(12));


    }

    @Test
    public void test7() {
        open("http://localhost:9999");
        $x("//*[@placeholder = \"Город\"]").setValue("Казань");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("20.09.2022"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("");
        $x("//*[@name = \"phone\"]").setValue("+79214567845");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Поле обязательно для заполнения\")]").should(visible, Duration.ofSeconds(12));


    }

    @Test
    public void test8() {
        open("http://localhost:9999");
        $x("//*[@placeholder = \"Город\"]").setValue("Казань");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("20.09.2022"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Иванов Андрей");
        $x("//*[@name = \"phone\"]").setValue("9214567845");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.\")]").should(visible, Duration.ofSeconds(12));


    }

    @Test
    public void test9() {
        open("http://localhost:9999");
        $x("//*[@placeholder = \"Город\"]").setValue("Казань");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("20.09.2022"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Иванов Андрей");
        $x("//*[@name = \"phone\"]").setValue("");
        $x("//*[@data-test-id = \"agreement\"]").click();
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Поле обязательно для заполнения\")]").should(visible, Duration.ofSeconds(12));


    }

    @Test
    public void test10() {
        open("http://localhost:9999");
        $x("//*[@placeholder = \"Город\"]").setValue("Казань");
        String verificationDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("20.09.2022"));
        $x("//*[@data-test-id = \"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE + verificationDate);
        $x("//*[@name = \"name\"]").setValue("Иванов Андрей");
        $x("//*[@name = \"phone\"]").setValue("9214567845");
        $x("//*[@class =\"button__text\" ]").click();
        $x("//* [contains(text(),\"Я соглашаюсь с условиями обработки и использования моих персональных данных\")]").should(visible, Duration.ofSeconds(12));

    }
}


