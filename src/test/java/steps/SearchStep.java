package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class SearchStep extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    WebDriver driver;

    @Given("booking search page is opened")
    public void bookingSearchPageIsOpened() {
        searchHomePage.openMainPage();
    }

    @When("user searches for {string}")
    public void userSearchesFor(String hotel) throws InterruptedException {
        sleep(2000);
        searchHomePage.inputFieldSearch(hotel);
        sleep(2000);
        searchHomePage.clickButtonSearch();
    }

    @Then("{string} hotel is shown")
    public void hotelIsShown(String expectedResult) {
        String hotel = searchHomePage.getHotelName(expectedResult);
        boolean isHotelFound = hotel.equals(expectedResult);
        Assert.assertTrue(isHotelFound);
    }

    @And("{string} hotel has a rating of {string}")
    public void hotelHasARatingOf(String hotelExpectedResult, String ratingExpectedResult) {
//        String hotel = searchHomePage.getHotelName(hotelExpectedResult);
//        boolean isHotelFound = hotel.equals(hotelExpectedResult);
//        softAssert.assertTrue(isHotelFound);

        String rating = searchHomePage.getRatingHotel(hotelExpectedResult,ratingExpectedResult);
        boolean isRatingCorrect = rating.equals(ratingExpectedResult);
        softAssert.assertTrue(isRatingCorrect);
//        softAssert.assertAll();
    }

//    @Then("{string} hotel has a rating of {string}")
//    public void hotelHasARatingOf(String hotelExpectedResult, String ratingExpectedResult) {
//        String hotel = searchHomePage.getHotelName(hotelExpectedResult);
//        boolean isHotelFound = hotel.equals(hotelExpectedResult);
//        softAssert.assertTrue(isHotelFound);
//
//        String rating = searchHomePage.getRatingHotel(hotelExpectedResult,ratingExpectedResult);
//        boolean isRatingCorrect = rating.equals(ratingExpectedResult);
//        softAssert.assertTrue(isRatingCorrect);
//        softAssert.assertAll();
//    }

    @After
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }


}
