package org.example.TestSeturMain;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestMain {
    private static final Logger logger = LogManager.getLogger(TestMain.class);
    public static void main(String[] args) throws Exception {
        TestMain a= new TestMain();
        System.setProperty("chromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.setur.com.tr/");
        if (!a.seturLinkKontrol(driver.getCurrentUrl())){// gidilen link seturda tamamlanmıyor mu kontrol edecek
            logger.info("setur.com.tr ye bağlanılamadı.");
        }
        Thread.sleep(5000);
        try {
            driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div/span")).click();// Teklifi reddetmek için
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#CybotCookiebotDialogBodyLevelButtonLevelOptinDeclineAll")).click();// Çerezleri reddetme için
        }catch (Exception e){
            int i=0;
            while (i<5){
                try {
                    i++;
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/span")).click();// Teklifi reddetmek için
                    Thread.sleep(500);
                    driver.findElement(By.cssSelector("#CybotCookiebotDialogBodyLevelButtonLevelOptinDeclineAll")).click();// Çerezleri reddetme için
                }catch (Exception ex){

                }

            }

        }


        if (!a.otelTabKontrol(driver)){// Otel Tabı seçili değil ise otel tabına tıklayacak
            logger.info("Otel tabı seçili değil");
        }
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#__next > div.sc-a23d9083-0.ASMVH > div.sc-a23d9083-1.cVIkbc > div.sc-4db08b3b-3.kLlmNp > div > div > div > div:nth-child(2) > div.sc-94dcce44-10.hOQfGD > div > div > span.sc-acaf4d52-4.etvBQv")).click();
        highlightElement(driver,driver.findElement(By.cssSelector("#__next > div.sc-a23d9083-0.ASMVH > div.sc-a23d9083-1.cVIkbc > div.sc-4db08b3b-3.kLlmNp > div > div > div > div:nth-child(2) > div.sc-94dcce44-10.hOQfGD > div > div > span.sc-acaf4d52-4.etvBQv")));
        Thread.sleep(500);//gitmek istediğiniz yer alanına tıklama

        driver.findElement(By.cssSelector("body > div.sc-67e1a7fc-3.RsWuc > div.sc-67e1a7fc-2.gDsjfR.sc-acaf4d52-5.cjojUe > div > div.sc-67e1a7fc-6.kxIplK > div > div.sc-acaf4d52-7.NlIEQ > div > div.sc-90340560-2.iyvTQM > div.sc-90340560-4.jNjuDA > input")).click();
        highlightElement(driver, driver.findElement(By.cssSelector("body > div.sc-67e1a7fc-3.RsWuc > div.sc-67e1a7fc-2.gDsjfR.sc-acaf4d52-5.cjojUe > div > div.sc-67e1a7fc-6.kxIplK > div > div.sc-acaf4d52-7.NlIEQ > div > div.sc-90340560-2.iyvTQM > div.sc-90340560-4.jNjuDA > input")));
        Thread.sleep(100);//yazı yazmak için tıklama

        driver.findElement(By.cssSelector("body > div.sc-67e1a7fc-3.RsWuc > div.sc-67e1a7fc-2.gDsjfR.sc-acaf4d52-5.cjojUe > div > div.sc-67e1a7fc-6.kxIplK > div > div.sc-acaf4d52-7.NlIEQ > div > div.sc-90340560-2.iyvTQM > div.sc-90340560-4.jNjuDA > input")).sendKeys(a.csvOku());// csv den ilin alınması
        Thread.sleep(2000);
        // csv den gelen şehir ismi sonrası şehire tıklama
        driver.findElement(By.cssSelector("body > div.sc-67e1a7fc-3.RsWuc > div.sc-67e1a7fc-2.gDsjfR.sc-acaf4d52-5.cjojUe > div > div.sc-67e1a7fc-6.kxIplK > div > div.sc-acaf4d52-10.cDYFfy > div > div:nth-child(1)")).click();
        Thread.sleep(1000);

        //şehir seçimi uygula butonu
        driver.findElement(By.cssSelector("body > div.sc-67e1a7fc-3.RsWuc > div.sc-67e1a7fc-2.gDsjfR.sc-acaf4d52-5.cjojUe > div > div.sc-67e1a7fc-6.kxIplK > div > div.sc-acaf4d52-16.bzbinX > button")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#__next > div.sc-a23d9083-0.ASMVH > div.sc-a23d9083-1.cVIkbc > div.sc-4db08b3b-3.kLlmNp > div > div > div > div:nth-child(2) > div.sc-bf3a6118-0.VntNS > div > div > span.sc-fd984615-0.cdgkri")).click();
        highlightElement(driver,driver.findElement(By.cssSelector("#__next > div.sc-a23d9083-0.ASMVH > div.sc-a23d9083-1.cVIkbc > div.sc-4db08b3b-3.kLlmNp > div > div > div > div:nth-child(2) > div.sc-bf3a6118-0.VntNS > div > div > span.sc-fd984615-0.cdgkri")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div[2]/div[4]/div/table/tbody/tr[1]/td[1]")).click();
        highlightElement(driver, driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div[2]/div[4]/div/table/tbody/tr[1]/td[1]")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div[2]/div[4]/div/table/tbody/tr[1]/td[7]")).click();
        highlightElement(driver,driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div[2]/div[4]/div/table/tbody/tr[1]/td[7]")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div[2]/div/div[3]/button")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#__next > div.sc-a23d9083-0.ASMVH > div.sc-a23d9083-1.cVIkbc > div.sc-4db08b3b-3.kLlmNp > div > div > div > div:nth-child(2) > div.sc-94dcce44-14.gyuuaP > div > span.sc-fd984615-0.cdgkri > span")).click();
        highlightElement(driver,driver.findElement(By.cssSelector("#__next > div.sc-a23d9083-0.ASMVH > div.sc-a23d9083-1.cVIkbc > div.sc-4db08b3b-3.kLlmNp > div > div > div > div:nth-child(2) > div.sc-94dcce44-14.gyuuaP > div > span.sc-fd984615-0.cdgkri > span")));
        Thread.sleep(1000);

        String yetiskinSayisi=driver.findElement(By.cssSelector("body > div.sc-67e1a7fc-3.RsWuc > div.sc-67e1a7fc-2.gDsjfR.sc-acaf4d52-20.gxwEUL > div > div.sc-67e1a7fc-6.kxIplK > div > div.sc-acaf4d52-22.eTPNuI > div > div > div > div > div.sc-acaf4d52-29.kVgtGn > div:nth-child(1) > div > div.sc-423a98f0-0.iibhk > span")).getText();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[1]/div/div[2]/button[2]/span/span")).click();
        highlightElement(driver,driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[1]/div/div[2]/button[2]/span/span")));
        Thread.sleep(1000);

        String yeniYetiskinSayisi=driver.findElement(By.cssSelector("body > div.sc-67e1a7fc-3.RsWuc > div.sc-67e1a7fc-2.gDsjfR.sc-acaf4d52-20.gxwEUL > div > div.sc-67e1a7fc-6.kxIplK > div > div.sc-acaf4d52-22.eTPNuI > div > div > div > div > div.sc-acaf4d52-29.kVgtGn > div:nth-child(1) > div > div.sc-423a98f0-0.iibhk > span")).getText();
        if (yetiskinSayisi.equals(yeniYetiskinSayisi)){
            logger.info("Yetişkin sayısı artmadı.");
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div[2]/div/div[2]/button")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#__next > div.sc-a23d9083-0.ASMVH > div.sc-a23d9083-1.cVIkbc > div.sc-4db08b3b-3.kLlmNp > div > div > div > div.sc-fc13bd1-0.vgwrl > button")).click();
        highlightElement(driver,driver.findElement(By.cssSelector("#__next > div.sc-a23d9083-0.ASMVH > div.sc-a23d9083-1.cVIkbc > div.sc-4db08b3b-3.kLlmNp > div > div > div > div.sc-fc13bd1-0.vgwrl > button")));
        Thread.sleep(5000);//sayfadan sonuç gelmesi bekleniyor.
        if (!a.sehirAdiKontrol(driver.getCurrentUrl())){
            logger.info("Sayfa Url'inde "+a.csvOku()+" kelimesi yok.");
        }
        driver.manage().window().maximize();
        Thread.sleep(1000);
        List<WebElement> rasgteleTiklamaDigerBolgeler=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]")).findElements(By.className("sc-e4b3cd20-0"));
        String parantezDeger=a.rastgeleTiklama(driver,rasgteleTiklamaDigerBolgeler);
        logger.info("diğer bölgelerden rastgele tıklanan alanın toplam kayıt değeri "+parantezDeger+" dir.");
        WebElement sayfaKaydirmaElementSinir= sayfaKaydirmaElementSinir=driver.findElement(By.cssSelector("#__next > div.sc-a23d9083-0.ASMVH > div.sc-a23d9083-1.cVIkbc > div > div.sc-59ad5318-0.kOXeZw"));
        sayfayiKaydirma(driver,sayfaKaydirmaElementSinir);//eğer sayfada sayfalandırma yok ise bahsedilen Antalya Otelleri ve En Uygun Antalya Otel Fiyatları alanı çıkmamaktadır. Bu alan sadece 20 veri getirmektedir. 20 den fazla ise bahsedilen alan çıkmaktadır ve paggination yapmaktadır.

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