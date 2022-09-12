
package ru.netology;


import com.codeborne.selenide.Condition;
import io.github.bonigarcia.wdm.WebDriverManager;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.lang.module.Configuration;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardWithDeliveryTest {

    @Test
    public void test1() {

        open(" http://localhost:9999");
        $x("//* [@placeholder = \"Город\"]").setValue("Казань");
        $x("//*[@placeholder = \"date\"]").setValue("15.09.2022");
        $x("//*[@name = \"name\"]").setValue("Иванов Андрей");
        $x("//* [@name = \"phone\"]").setValue("+79214567845");
        $x("//* [@data-test-id = \"agreement\"]").click();
        $x("//* [@class =\"button__text\" ]").click();
        // String text = $x("//* [contains(text(),'Успешно!Встреча успешно забронирована на 15.09.2022')]").getText();
        //assertEquals("Успешно!Встреча успешно забронирована на 15.09.2022", text);
        $x("//* [contains(text(),\"Успешно!Встреча успешно забронирована на 15.09.2022\")]").should(visible, Duration.ofSeconds(10));
    }
    }


