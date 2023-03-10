package com.tsoft.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SpotifyAutomation {

    public static void main(String[] args) throws InterruptedException {

        //Project and Driver route

        String rutaProyecto = System.getProperty("user.dir");
        String rutaDriver = rutaProyecto + "\\src\\test\\resources\\drivers\\chromedriver.exe";

        //Routing driver with browser

        System.setProperty("webdriver.chrome.driver",rutaDriver);

        //Creat objetc driver

        WebDriver driver = new ChromeDriver();


        //Start automation

        String url = "https://www.google.com.ar";
        driver.get(url);
        driver.manage().window().maximize();
        driver.navigate().to("https://open.spotify.com/");

        //Registrer User

        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/header/div[5]/button[1]")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button")).click();

        //Data registration

        String email = "name_test_996@testing.com";
        String password = "secret_password_testing";
        String name = "testing_user_automation96";
        String day = "20";
        String year = "1996";

        //Set information and complete registration

        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("confirm")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("displayname")).sendKeys(name);
        driver.findElement(By.id("day")).sendKeys(day);
        Select monthList = new Select(driver.findElement(By.id("month"))); monthList.selectByIndex(11);
        driver.findElement((By.id("year"))).sendKeys(year);

        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/form/fieldset/div/div[1]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/form/div[6]/div/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/form/div[8]/div/button/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/form/div[7]/div/label/span[1]")).click();

        System.out.println("Registro completo");

        Thread.sleep(10000);

        driver.close();

    }

}
