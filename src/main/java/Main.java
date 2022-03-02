import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USUARIO\\Desktop\\Tareas haciendose y otras cosas" +
                "\\Gestion Calidad de Software\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.lifepointspanel.com/registration");
        Thread.sleep(1000);

        submitForm(driver);
        waitForAlertBanner(driver);

        assertEquals("TÉRMINOS Y CONDICIONES",getAlertBannerText(driver));

       // driver.quit();

    }

    public static void submitForm(WebDriver driver) throws InterruptedException {
        //elementos de la primera parte del registro
       // driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/button")).click();
        //driver.findElement(By.name("accept_only_website_cookies")).click();
        driver.findElement(By.id("edit-first-name")).sendKeys("Berny");
        driver.findElement(By.id("edit-last-name")).sendKeys("Urquijo");
        driver.findElement(By.id("edit-email-address")).sendKeys("bernysex@gmail.com");
        driver.findElement(By.id("edit-confirm-email-address")).sendKeys("bernysex@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"lp-registration-form\"]/div[1]/div[5]/p/a")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"edit-password\"]")).sendKeys("Weezer123*");
        driver.findElement(By.xpath("//*[@id=\"edit-password-confirm\"]")).sendKeys("Weezer123*");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"lp-registration-form\"]/div[2]/div[3]/p/a[2]")).click();

        Thread.sleep(2000);
       driver.findElement(By.cssSelector("#edit-gender > div:nth-child(1) > label > label")).click();

        driver.findElement(By.xpath("//*[@id=\"edit-date-of-birth-dd\"]")).sendKeys("11");
        driver.findElement(By.xpath("//*[@id=\"edit-date-of-birth-mm\"]")).sendKeys("11");
        driver.findElement(By.xpath("//*[@id=\"edit-date-of-birth-yyyy\"]")).sendKeys("2001");
        driver.findElement(By.xpath("//*[@id=\"lp-registration-form\"]/div[3]/div[4]/p/a[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"edit-mailing-address1\"]")).sendKeys("Sexta Privada Yañez #14");
        driver.findElement(By.xpath("//*[@id=\"edit-mailing-address2\"]")).sendKeys("Col Modelo");

        driver.findElement(By.xpath("//*[@id=\"edit-state\"]/option[27]")).click();
        driver.findElement(By.xpath("//*[@id=\"edit-city\"]")).sendKeys("Hermosillo");
        driver.findElement(By.xpath("//*[@id=\"edit-postal-code\"]")).sendKeys("83190");
        driver.findElement(By.xpath("//*[@id=\"lp-registration-form\"]/div[4]/div[5]/p/a[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"lp-registration-form\"]/div[5]/div[1]/div[1]/div/div[1]/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"lp-registration-form\"]/div[5]/div[1]/div[2]/div/div[1]/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"lp-registration-form\"]/div[5]/div[1]/div[3]/div/div[1]/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"lp-registration-form\"]/div[5]/div[1]/div[4]/div/div[1]/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"edit-submit\"]")).click();

    }

    public static void waitForAlertBanner(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/div/div[3]/div[2]/div/div[2]/div/div/h3[5]")));
    }

    public static String getAlertBannerText(WebDriver driver){
       // String alertText = alert.getText();
        return driver.findElement(By.xpath("/html/body/div[1]/section/div/div[3]/div[2]/div/div[2]/div/div/h3[5]")).getText();
    }
}
