package org.example.yemekSepeti;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class TestMain {
    private static final Logger logger = LogManager.getLogger(TestMain.class);
    public static void main(String[] args) throws Exception {
        TestMain a= new TestMain();
        System.setProperty("chromeDriver", "src/main/resources/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--enable-mobile-emulation", "--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75 Mobile Safari/602.1");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.example.com");
        Thread.sleep(5000);
        driver.quit();
    }
    public boolean otelTabKontrol(WebDriver driver){
        WebElement otelTabKontrolu=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/button[1]"));
        String classAdi=otelTabKontrolu.getAttribute("class");
        return classAdi.contains("crUBM");
    }
    public boolean seturLinkKontrol(String currentUrl){
        return currentUrl.contains("https://www.setur.com.tr");
    }

    public boolean sehirAdiKontrol(String currentUrl){
        return currentUrl.contains("antalya");
    }

    public String csvOku() throws CsvValidationException, IOException {
        File f=new File("src/main/resources/iller.csv");
        CSVReader reader=new CSVReader(new BufferedReader(new FileReader(f)));
        String[]s = reader.readNext();
        return  s[0];
    }
    public String rastgeleTiklama(WebDriver driver, List<WebElement> innerDivs) throws InterruptedException {
        Random random = new Random();
        String randomSecilen=null;
        WebElement randomInnerDiv=null;
        while (randomSecilen==null){
            randomInnerDiv = innerDivs.get(random.nextInt(innerDivs.size()));
            randomSecilen=randomInnerDiv.getText();
            try {
                randomSecilen=randomSecilen.substring(randomSecilen.indexOf("(")+1,randomSecilen.indexOf(")"));
            }catch (Exception e){
                randomSecilen=null;
            }
        }
        randomInnerDiv.click();
        highlightElement(driver,randomInnerDiv);
        Thread.sleep(5000);
        highlightElement(driver,randomInnerDiv);
        return randomSecilen;
    }

    public static void sayfayiKaydirma(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int elementYüksekligi = element.getSize().getHeight();
        js.executeScript("window.scrollTo(0, arguments[0]);", element.getLocation().getY() - elementYüksekligi);
    }


    public static void highlightElement(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid yellow;');", element);
        }catch (Exception e){
        }
    }


}