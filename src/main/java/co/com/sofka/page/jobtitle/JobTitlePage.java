package co.com.sofka.page.jobtitle;

import co.com.sofka.model.jobtitle.JobTitleModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static java.lang.Math.random;

public class JobTitlePage extends CommonActionOnPages {

    public JobTitlePage(WebDriver driver, JobTitleModel jobTitleModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.jobTitleModel = jobTitleModel;
    }

    public static final Logger LOGGER = Logger.getLogger(JobTitlePage.class);

    private JobTitleModel jobTitleModel;

    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    //Localizadores


    @CacheLookup
    @FindBy(xpath = "html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[1]/input")
    private WebElement jobTitle;

    @CacheLookup
    @FindBy(name = "jobTitle[jobDescription]")
    private WebElement jobDescription;

    @CacheLookup
    @FindBy(name = "jobTitle[note]")
    private WebElement jobSpec;



    @CacheLookup
    @FindBy(id = "jobTitle_note")
    private WebElement note;

    @CacheLookup
    @FindBy(name = "btnSave")
    private WebElement btnSave;


    public void fillJobTitleForm() throws InterruptedException {



        clickOn(jobTitle);
        typeOn(jobTitle,"prueba"+random());




        clickOn(jobDescription);
        typeOn(jobDescription, "saludo");



        clickOn(note);
        typeOn(note, "esto es una nota");




        doSubmit(btnSave);

    }

    public String insert (WebDriver driver){
        WebElement element = driver.findElement(By.xpath("//form/div[2]"));
        String texto = element.getText().trim();
        return texto;
    }



}