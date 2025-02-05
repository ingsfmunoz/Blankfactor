package pages;

public class ContactPage extends BasePage {

    public ContactPage() {
        super(driver);
    }

    private String becomeAClientButton = ".contact-btn-wrap";
    private String firstNameField = "[name='First_name__c']";
    private String lastNameField = "[name='Last_Name__c']";
    private String companyField = "[name='Company']";
    private String emailField = "[name='Email']";
    private String phoneField = "[name='Phone']";
    private String projectField = "[name='Message__c']";
    private String PrivacyPolicy = "#policy";
    private String getStartedButton = "button[class*='btn btn-large']";

    public void clickOnBecomeClient() {
        try {
            if (elementDisplayed(becomeAClientButton)) {
                clickElement(becomeAClientButton);
            }
        } catch (Exception e) {
            System.out.println("Button is not visible");
        }
    }

    public void enterFirtsName(String first_name) {
        write(firstNameField, first_name);
    }

    public void enterLastName(String last_name) {
        write(lastNameField, last_name);
    }

    public void enterCompany(String company) {
        write(companyField, company);
    }

    public void enterEmail(String email) {
        write(emailField, email);
    }

    public void enterPhone(String phone) {
        write(phoneField, phone);
    }

    public void enterProject(String project) {
        write(projectField, project);
    }

    public void checkPrivacyPolicy() {
        clickElement(PrivacyPolicy);
    }

    public void clickOnGetStarted() {
        try {
            if (elementDisplayed(getStartedButton)) {
                clickElement(getStartedButton);
            }
        } catch (Exception e) {
            System.out.println("Button is not visible");
        }
    }

}
