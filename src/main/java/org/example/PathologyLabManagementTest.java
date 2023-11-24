package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.net.WWWFormCodec;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestNGUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PathologyLabManagementTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize the driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void testLoginAndNavigateToFeatures() throws InterruptedException {
        // Navigate to the login page
        driver.get("https://gor-pathology.web.app/");

        // Login with valid credentials
        Thread.sleep(2000);
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));

        usernameInput.sendKeys("test@kennect.io");
        passwordInput.sendKeys("Qwerty@1234");
        loginButton.click();
        Thread.sleep(2000);
        loadingWait(driver);

        Thread.sleep(2000);
        WebElement todosList = driver.findElement(By.xpath("//div[contains(text(),'TODO')]"));
        Assert.assertTrue(todosList.isDisplayed(), "Todos list is not displayed");

        WebElement patients= driver.findElement(By.xpath("//span[contains(text(),'Patients')]"));
        patients.click();
        WebElement addpatient= driver.findElement(By.xpath("(//span[contains(text(),'Add Patient')])[1]"));
        addpatient.click();
        WebElement enterpatientname= driver.findElement(By.xpath("//input[@name='name']"));
        enterpatientname.sendKeys("sakshi");
        WebElement enterpatientemail= driver.findElement(By.xpath("//input[@name='email']"));
        enterpatientemail.sendKeys("abc@gmail.com");
        WebElement phone=driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys("9653248526");
        WebElement generaldetailsbtn= driver.findElement(By.xpath("(//span[contains(text(), 'General Details')])[2]"));
        generaldetailsbtn.click();

        Thread.sleep(2000);
        WebElement height= driver.findElement(By.xpath("//input[@name='height']"));
        height.click();
        height.clear();
        height.sendKeys("172");
        WebElement weight= driver.findElement(By.xpath("//input[@name='weight']"));
        weight.click();
        weight.clear();
        weight.sendKeys("52");
        WebElement gender= driver.findElement(By.xpath("//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']"));
        gender.click();
        WebElement genderdropdwn = driver.findElement(By.xpath("//ul//li[contains(text(),'Female')]"));
        genderdropdwn.click();
        WebElement age=driver.findElement(By.xpath("//input[@name='age']"));
        age.click();
        age.clear();
        age.sendKeys("25");
        WebElement bp1= driver.findElement(By.xpath("//input[@name='systolic']"));
        bp1.click();
        bp1.clear();
        bp1.sendKeys("98");
        WebElement bp2=driver.findElement(By.xpath("//input[@name='diastolic']"));
        bp2.click();
        bp2.clear();
        bp2.sendKeys("85");
        WebElement addtestbtn= driver.findElement(By.xpath("(//span[contains(text(),'Add Tests')])[2]"));
        addtestbtn.click();
        Thread.sleep(2000);
        WebElement addtestpatienttab=driver.findElement(By.xpath("//input[@id='patient-test']"));
        addtestpatienttab.click();
         WebElement addtestpatient=driver.findElement(By.xpath("//ul//li[@id='patient-test-option-5']"));
        Thread.sleep(2000);
        addtestpatient.click();
        WebElement distab= driver.findElement(By.xpath("(//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[1]"));
        distab.click();
        WebElement discount= driver.findElement(By.xpath("//ul//li[contains(text(), '10%')]"));
        discount.click();
        Thread.sleep(2000);
        WebElement labrecommend=driver.findElement(By.xpath("//input[@id='patient-tests-labs']"));
        labrecommend.click();
        Thread.sleep(2000);
        WebElement labrecomendenter=driver.findElement(By.xpath("//ul//li[@id='patient-tests-labs-option-0']"));
        labrecomendenter.click();
        WebElement recommenddr=driver.findElement(By.xpath("//input[@name='doctor_name']"));
        recommenddr.click();
        Thread.sleep(2000);
        WebElement dr= driver.findElement(By.xpath("//ul//li[contains(text(), 'Dr.roheet rathod ')]"));
        dr.click();
        WebElement commisiontab= driver.findElement(By.xpath("//div[@id='mui-component-select-doctor_commission']"));
        commisiontab.click();
        WebElement comission=driver.findElement(By.xpath("//ul//li[contains(text(), '40%')]"));
        comission.click();
        scrolls(driver);

        WebElement addButton = driver.findElement(By.xpath("//div[@class='jss170']//button[contains(@class, 'MuiIconButton-colorInherit')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);

        Thread.sleep(3000);
        WebElement check=driver.findElement(By.xpath("//button[contains(@class, 'MuiIconButton-root') and .//span[@class='material-icons MuiIcon-root' and text()='check']]"));
        Thread.sleep(3000);
        check.click();
       // Thread.sleep(2000);
        WebElement addpatientbtn=driver.findElement(By.xpath("//span[contains(text(),'Add Patient')]"));
        addpatientbtn.click();
    }

    public static void loadingWait(WebDriver driver) {
        WebElement loading= driver.findElement(By.xpath("//div[@role='progressbar']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(loading)); // wait for loader to disappear
    }
    public static void scrolls(WebDriver driver) {

        // Perform scrolling to the end of the page
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
