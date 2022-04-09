package co.com.sofka.page.jobtitle;

import co.com.sofka.model.jobtitle.JobTitleModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
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
        typeOn(jobTitle,"Job"+random());

        clickOn(jobDescription);
        typeOn(jobDescription, "And this is a description");

        clickOn(note);
        typeOn(note, "And this is a note");

        //sikuli
        clickOn(jobSpec);
        clickOn(SELECT_PICTURE_PATCH);
        insertInto(FILE_NAME_TEXT_BOX_PATCH, USER_DIR.value() + "\\src\\test\\resources\\images\\happy.png");
        clickOn(SELECT_OPEN_PATCH);

       doSubmit(btnSave);

    }

    //Sikulix elements.

    private static final String ATTACHMENT_FILE_PATCH = USER_DIR.value() + "\\src\\test\\resources\\images\\happy.png";

    private static final String PAGE_BASE_PATCH = USER_DIR.value() + "\\src\\main\\resources\\page\\";
    private static final String SELECT_PICTURE_PATCH = PAGE_BASE_PATCH + "selectPicture.PNG";
    private static final String SELECT_OPEN_PATCH = PAGE_BASE_PATCH + "openWindows.PNG";
    private static final String FILE_NAME_TEXT_BOX_PATCH = PAGE_BASE_PATCH + "fileNameWindows.PNG";

    public String response (WebDriver driver){
        WebElement element = driver.findElement(By.xpath("//form[@id='frmList_ohrmListComponent']/div[2]"));
        String texto = element.getText().trim();
        return texto;
    }

}