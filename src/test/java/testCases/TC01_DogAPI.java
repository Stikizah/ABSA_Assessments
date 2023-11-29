package testCases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import page.DogAPIPage;


public class TC01_DogAPI extends Base {

    public TC01_DogAPI(){
        super();
    }
    public WebDriver driver;
    public DogAPIPage dogAPIPage = new DogAPIPage(null);

    @Test(priority = 1)
    public void performAnAPIRequestToProduceListOfAllDogBreeds() {
        dogAPIPage.DiagramOne();
    }

    @Test(priority = 2)
    public void usingCodeToVerifySearchRetrieverBreedIsWithinTheList()
    {
        dogAPIPage.DiagramTwo();
    }

    @Test(priority = 3)
    public void performRequestToProduceListOfSubBreedsForRetriever() {
        dogAPIPage.DiagramThree();
    }

    @Test(priority = 4)
    public void performAnApiRequestToProduceRandomImageLinkForSubBreedGolden()
    {
        dogAPIPage.DiagramFour();
    }
}
