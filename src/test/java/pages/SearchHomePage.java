package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class SearchHomePage {

    private String BUTTON_SEARCH = "//button[@type = 'submit']";
    private String FIELD_SEARCH = "//input[@name = 'ss']";
    private String ALL_TITLES = "//*[@data-testid='title']";
    private String RATING_OF_HOTEL = "//*[text() = '%s']" +
            "/ancestor::div[@data-testid = 'property-card']//div[text() = '%s']";


    public SearchHomePage openMainPage(){
        open("https://www.booking.com/");
        return this;
    }

    public SearchHomePage clickButtonSearch(){
        $x(BUTTON_SEARCH).click();
        return this;
    }

    public SearchHomePage inputFieldSearch(String hotel){
        $x(FIELD_SEARCH).setValue(hotel);
        return this;
    }

    public String getHotelName(String hotel){
        return  $$x(ALL_TITLES).find(Condition.text(hotel)).getText();
    }

    public String getRatingHotel(String hotel,String rating){
        return $x(String.format(RATING_OF_HOTEL,hotel,rating)).getText();
    }
}
