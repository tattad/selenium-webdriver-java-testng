package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_25_Wait_04_Static_Dead_Hard {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_Equal_5_Second() {
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        sleepInSecond(5);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
    }

    @Test
    public void TC_02_Less_Than_5_Second() {
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
    }

    @Test
    public void TC_03_Greater_Than_5_Second() {
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        sleepInSecond(10);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
