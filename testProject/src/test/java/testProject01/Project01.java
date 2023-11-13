package testProject01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Project01 {
    static WebDriver cdriver;

    //Elements
    static WebElement productsButton;
    static WebElement viewProductButton;
    static String expectedAllProducts = "ALL PRODUCTS";
    static String actualAllProducts;
    static String expectedWriteYourReview = "WRITE YOUR REVIEW";
    static String actualWriteYourReview;
    static String expectedReviewMessage = "Thank you for your review.";
    static String actualReviewMessage;
    static WebElement nameLabel;
    static WebElement emailAddressLabel;
    static WebElement reviewCommentLabel;
    static WebElement submitButton;
    static String name = "John";
    static String emailAddress = "john@test.com";
    static String reviewComment = "NİCE!!!";

    @BeforeClass
    public static void setUp() {
        cdriver = new ChromeDriver();
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        cdriver.get("http://automationexercise.com");
    }
    @AfterClass
    public static void tearDown() {
        cdriver.quit();
    }
    @Test
    public void test01() {
        productsButton = cdriver.findElement(By.cssSelector("a[href='/products']"));
        productsButton.click();
    }
    @Test
    public void test02() {
        actualAllProducts = cdriver.findElement(By.xpath("//h2[text()='All Products']")).getText();
        Assert.assertEquals(actualAllProducts,expectedAllProducts);
        System.out.println("Actual All Products: " + actualAllProducts);
    }
    @Test
    public void test03() {
        viewProductButton = cdriver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]"));
        viewProductButton.click();
    }
    @Test
    public void test04() {
        actualWriteYourReview = cdriver.findElement(By.xpath("//a[text()='Write Your Review']")).getText();
        Assert.assertEquals(actualWriteYourReview,expectedWriteYourReview);
        System.out.println("Actual Write Your Review: " + actualWriteYourReview);
    }
    @Test
    public void test05() {
        nameLabel = cdriver.findElement(By.xpath("//input[@id='name']"));
        emailAddressLabel = cdriver.findElement(By.xpath("//input[@id='email']"));
        reviewCommentLabel = cdriver.findElement(By.xpath("//textarea[@id='review']"));
        nameLabel.sendKeys(name);
        emailAddressLabel.sendKeys(emailAddress);
        reviewCommentLabel.sendKeys(reviewComment);
        submitButton = cdriver.findElement(By.xpath("//button[@id='button-review']"));
        submitButton.click();
    }
    @Test
    public void test06() {
        actualReviewMessage = cdriver.findElement(By.xpath("//span[text()='Thank you for your review.']")).getText();
        Assert.assertEquals(actualReviewMessage,expectedReviewMessage);
        System.out.println("Actual Review Message: " + actualReviewMessage);
    }
}
