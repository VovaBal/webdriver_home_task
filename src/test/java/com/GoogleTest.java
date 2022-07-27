package com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

    public static GoogleHelper googleHelper;
    private String image = "хаги ваги";

    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        googleHelper = new GoogleHelper(driver);
    }

    @Test
    public void collectImageSizeTest() {
        googleHelper.openPage();
        googleHelper.searchImage(image);
        googleHelper.openImageTab();
        int amountImages = googleHelper.collectImages();
        Assertions.assertThat(amountImages).isGreaterThan(0);
    }
}
