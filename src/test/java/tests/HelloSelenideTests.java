package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.isChrome;
import static org.testng.Assert.assertEquals;

public class HelloSelenideTests {

    @Test
    public void onAir(){
        isChrome();
        open("https://selenide.org");
        assertEquals(title(), "Selenide: concise UI tests in Java");

    }
}
