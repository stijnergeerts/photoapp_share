package dom;

/**
 * Created by stijnergeerts on 8/05/17.
 */
public class EventText {

    public String eventName;
    public String logo;
    public String textUpper;
    public String textUnderPhoto;
    public String textBottom;
    public String textColor;
    public String backgroundColor;
    public String backgroundImage;
    public boolean backgroundImageToggle;
    public String cloudinaryDirectory;
    public String qrCodeImage;

    public EventText(String textUpper, String textUnderPhoto, String textBottom, String textColor) {
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
        this.textColor = textColor;
    }



    public EventText(String textUpper, String textUnderPhoto, String textBottom, String textColor, String cloudinaryDirectory) {
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
        this.textColor = textColor;
        this.cloudinaryDirectory = cloudinaryDirectory;
    }

    public EventText(String textUpper, String textUnderPhoto, String textBottom, String textColor, String backgroundColor, String cloudinaryDirectory) {
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.cloudinaryDirectory = cloudinaryDirectory;
    }

    public EventText(String textUpper) {
        this.textUpper = textUpper;
    }

    public EventText(String textUpper, String textUnderPhoto) {
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
    }

    public EventText(String textUpper, String textUnderPhoto, String textBottom) {
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
    }

    public EventText(String eventName, String logo, String textUpper, String textUnderPhoto, String textBottom, String textColor, String backgroundColor, String cloudinaryDirectory, String qrCodeImage) {
        this.eventName = eventName;
        this.logo = logo;
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.cloudinaryDirectory = cloudinaryDirectory;
        this.qrCodeImage = qrCodeImage;
    }

    public EventText(String eventName, String logo, String textUpper, String textUnderPhoto, String textBottom, String textColor, String backgroundColor, String backgroundImage, String cloudinaryDirectory, String qrCodeImage) {
        this.eventName = eventName;
        this.logo = logo;
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.backgroundImage = backgroundImage;
        this.cloudinaryDirectory = cloudinaryDirectory;
        this.qrCodeImage = qrCodeImage;
    }

    public EventText(String eventName, String logo, String textUpper, String textUnderPhoto, String textBottom, String textColor, String backgroundColor, String backgroundImage, boolean backgroundImageToggle, String cloudinaryDirectory, String qrCodeImage) {
        this.eventName = eventName;
        this.logo = logo;
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.backgroundImage = backgroundImage;
        this.backgroundImageToggle = backgroundImageToggle;
        this.cloudinaryDirectory = cloudinaryDirectory;
        this.qrCodeImage = qrCodeImage;
    }

    public EventText() {
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTextUpper() {
        return textUpper;
    }

    public void setTextUpper(String textUpper) {
        this.textUpper = textUpper;
    }

    public String getTextUnderPhoto() {
        return textUnderPhoto;
    }

    public void setTextUnderPhoto(String textUnderPhoto) {
        this.textUnderPhoto = textUnderPhoto;
    }

    public String getTextBottom() {
        return textBottom;
    }

    public void setTextBottom(String textBottom) {
        this.textBottom = textBottom;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getCloudinaryDirectory() {
        return cloudinaryDirectory;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public boolean isBackgroundImageToggle() {
        return backgroundImageToggle;
    }

    public void setBackgroundImageToggle(boolean backgroundImageToggle) {
        this.backgroundImageToggle = backgroundImageToggle;
    }

    public void setCloudinaryDirectory(String cloudinaryDirectory) {
        this.cloudinaryDirectory = cloudinaryDirectory;
    }

    public String getQrCodeImage() {
        return qrCodeImage;
    }

    public void setQrCodeImage(String qrCodeImage) {
        this.qrCodeImage = qrCodeImage;
    }

}
