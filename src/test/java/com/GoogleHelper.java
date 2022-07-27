package com;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleHelper {
    private WebDriver driver;
    private WebDriverWait waiter;
    private String baseUrl;

    public GoogleHelper(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.baseUrl = "https://google.com";
    }

    public void openPage() {
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    public void searchImage(String nameImage) {
        WebElement searchField = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='q']")));
        searchField.sendKeys(nameImage);
        searchField.sendKeys(Keys.ENTER);
    }

    public void openImageTab() {
        WebElement imageTab = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Картинки']")));
        imageTab.click();
    }

    public int collectImages() {
        List<WebElement> images = driver.findElements(By.xpath("//div[@id='islrg']//div//div"));
        System.out.println("size = " + images.size());
        return images.size();
    }

}
