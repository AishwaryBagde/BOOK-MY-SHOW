package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        // 1. Launch Browser (Chrome) :ChromeDriver()
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        // 1.2 Maximize Window :driver.manage().window().maximize();;
        driver.manage().window().maximize();
        // 1.5 Handle Sync issue using implicitlyWait() :driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01()throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        
        // Load and print the URL  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // Wait for 30 seconds  
        Thread.sleep(3000);
        // Click on > button  Using Locator "XPath" "(//div[@class='sc-lnhrs7-7 faepMR'])[1]"
        driver.findElementByXPath("(//div[@class='sc-lnhrs7-7 faepMR'])[1]").click();
        // Wait for 3 seconds
        Thread.sleep(5000);

        //Go to Recommended movies section and print the Image url's of 10 movies  "//div[@class='sc-133848s-2 sc-1t5vwh0-0 bnfwqC']//div//img"
        List<WebElement> recommendedMoviesImageUrls = driver.findElementsByXPath("//div[@class='sc-133848s-2 sc-1t5vwh0-0 bnfwqC']//div//img");
        //Traversing through the list and print the image urls using for each loop  
        for(WebElement imageUrls:recommendedMoviesImageUrls){
            System.out.println("The Image Urls of Recommended Movies are : "+ imageUrls.getAttribute("src"));
        }
        //Scroll down to the element by javascript   
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(5000);

        // Print the Name of 2nd Premium movie Using Locator "XPath" "(//div[@class='sc-7o7nez-0 fyTNyu'])[2]"
        WebElement secondPremiumMovieName = driver.findElementByXPath("(//div[@class='sc-7o7nez-0 fyTNyu'])[2]");
        System.out.println("The Second Premium Movie Name Is : " +secondPremiumMovieName.getText());

        // Print the Language of 2nd Premium movie Using Locator "XPath" "(//div[@class='sc-7o7nez-0 eeVqLW'])[2]"
        WebElement secondPremiumMovieLang = driver.findElementByXPath("(//div[@class='sc-7o7nez-0 eeVqLW'])[2]");
        System.out.println("The second Premium Language Is : "+secondPremiumMovieLang.getText());

        
    }


}
