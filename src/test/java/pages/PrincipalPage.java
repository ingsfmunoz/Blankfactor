package pages;

public class PrincipalPage extends BasePage {

    private String accepAllButtonPrivacy = "#menu-item-4436";
    private String policyBanner = ".cky-consent-bar4";

    public PrincipalPage() {
        super(driver);
    }

    public void navigateToBlankFactorPage(String url) {
        nagivateTo(url);
    }

    public void acceptOurPolicy() {
        try {
            if (elementDisplayed(accepAllButtonPrivacy)) {
                clickElement(accepAllButtonPrivacy);
            }
        } catch (Exception e) {
            System.out.println("No policy pop-up displayed or already accepted.");
        }
    }

    public void policyBannerIsNotVisible() {
        boolean isPolicyDisplayed;
        try {
            isPolicyDisplayed = elementDisplayed(policyBanner);
        } catch (Exception e) {
            isPolicyDisplayed = false;
        }
        assert !isPolicyDisplayed : "The policy banner is still visible!";
    }

}
