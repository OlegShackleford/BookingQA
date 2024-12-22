package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import static org.testng.Assert.assertEquals;

public class SearchTestNotCucumber extends BaseTest {

    @Test
    public void checkSearchHotelName(){
        searchHomePage.openMainPage().inputFieldSearch("Akra Kemer").clickButtonSearch();
        String hotelName = searchHomePage.getHotelName("Akra Kemer - Ultra All Inclusive");
        assertEquals(hotelName,"Akra Kemer - Ultra All Inclusive","Incorrect hotel name");
    }

    @Test
    public void checkSearchHotelNameAndRating(){
        searchHomePage.openMainPage().inputFieldSearch("Akra Kemer").clickButtonSearch();
        String hotelRating = searchHomePage
                .getRatingHotel("Akra Kemer - Ultra All Inclusive","9,2")
                .substring(10).trim();

        assertEquals(hotelRating,"9,2","Incorrect rating of hotel");
    }
}
