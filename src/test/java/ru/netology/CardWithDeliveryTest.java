
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
}


