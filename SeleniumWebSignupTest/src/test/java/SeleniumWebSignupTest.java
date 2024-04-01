import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {

    //Import selenium webDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //Locate where the chromeDriver is
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        //1. open Chrome browser
        driver = new ChromeDriver();
        //2. Input your selenium demo web browser page URL
        driver.get("https://selenium-blog.herokuapp.com/");
        //Test1. Verify that user inputs the right URL and is on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            //Pass
            System.out.println("correct webpage");
        else
            //Fail
            System.out.println("wrong webpage");
        Thread.sleep(5000);
        //3. Maximise the browser
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void positiveSignup() throws InterruptedException {
        //4. Click on signup button to open signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //Test2, Verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedURL = "https://selenium-blog.herokuapp.com/signup";
        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains("expectedURL"))
            //Pass
            System.out.println("correct webpage");
        else
            //Fail
            System.out.println("wrong webpage");
    }

    @Test(priority = 1)
    public void Signup() throws InterruptedException {
        //Test3. Verify that user is successfully signed up when valid details are inputted
        //5. Input your username in the username field
        driver.findElement(By.id("user_username")).sendKeys("Seke0987");
        //6. Input your email in the email field
        driver.findElement(By.id("user_email")).sendKeys("Seke0987@mailnator.com");
        //7. Input your password in the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void clickUser1Item() throws InterruptedException {
        //9. Click on the User1Item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        Thread.sleep(5000);
        //Test4. Verify that User1Item is present on the item list page
        String expectedUrl = "https://selenium-blog.herokuapp.com/users.3314";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("correct User1page");
        else
            //Fail
            System.out.println("wrong User1page");
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void verifyItem() throws InterruptedException {
        //10. Search for an item (using python with selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        //Test5. Verify that the item searched for on the user1 item page is present
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("correct webpage");
        else
            //Fail
            System.out.println("wrong webpage");
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void LogoutSuccessfully() throws InterruptedException {
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        //11. Click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test6. Verify that when user clicks on logout, he/she is directed to the login page
        String expectedTitle = "https://selenium-blog.herokuapp.com";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
            //Pass
            System.out.println("correct webpage");
        else
            //Fail
            System.out.println("wrong webpage");
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    public void NegativeSignup() throws InterruptedException {
        //1. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test7.Verify that user cannot Sign up with username less than 3 characters
        //2. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("bb");
        //3. Input an Email address in the email field
        driver.findElement(By.id("user_email")).sendKeys("Aseke0987@mailnator.com");
        //4. Input Your password in the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //5. Click on Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //6. Click on Login button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 6)
    public void negativeSignup1() throws InterruptedException {
        //1. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //2. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Seke3789");
        //Test8.Verify that user cannot Sign UP with invalid email address
        //3. Input an Email address in the email field
        driver.findElement(By.id("user_email")).sendKeys("3789mailnator.com");
        //4. Input Your password in the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //5. Click on Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //6. Click on Login button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 7)
    public void negativeSignup2() throws InterruptedException {
        //Test9.Verify that user cannot Signup with either/all the fields blank
        //1. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //2. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys(",.");
        //3. Input an Email address in the email field
        driver.findElement(By.id("user_email")).sendKeys(",.");
        //4. Input Your password in the password field
        driver.findElement(By.id("user_password")).sendKeys(",.");
        //5. Click on Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //6. Click on Login button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 8)
    public void negativeSignup3() throws InterruptedException {
        //1. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //2. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Aseke0765");
        //3. Input an Email address in the email field
        driver.findElement(By.id("user_email")).sendKeys("Aseke0765@mailnator.com");
        //Test10.Verify that user cannot login with password less than or equal to one character
        //4. Input Your password in the password field
        driver.findElement(By.id("user_password")).sendKeys("j");
        //5. Click on Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //6. Click on Login button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser() {
        //12. Quit the browser
        driver.quit();
    }
}