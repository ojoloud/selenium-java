package extend.basic;

public enum TargetPlatform {
    CHROME("chrome", "org.openqa.selenium.chrome.ChromeDriver", "org.openqa.selenium.chrome.ChromeProfile", "org.openqa.selenium.chrome.ChromeOptions"),
    FIREFOX("firefox", "org.openqa.selenium.firefox.FirefoxDriver", "org.openqa.selenium.firefox.FirefoxProfile", "org.openqa.firefox.FirefoxOptions"),
    SAFARI("safari", "org.openqa.selenium.safari.SafariDriver", "org.openqa.selenium.safari.SafariProfile", "org.openqa.selenium.safari.SafariOptions"),
    IE("ie", "org.openqa.selenium.ie.InternetExplorerDriver", "org.openqa.selenium.ie.InternetExplorerProfile", "org.openqa.selenium.ie.InternetExplorerOptions"),
    ANDROID("android", "io.appium.java_client.AppiumDriver", "", "");

    private String platform;
    private String driverClassName;
    private String profileClassName;
    private String optionsClassName;

    public String getPlatform() {
        return platform;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getProfileClassName() {
        return profileClassName;
    }

    public String getOptionsClassName() {
        return optionsClassName;
    }

    TargetPlatform(String platform, String driverClassName, String profileClassName, String optionsClassName) {
        this.platform = platform;
        this.driverClassName = driverClassName;
        this.profileClassName = profileClassName;
        this.optionsClassName = optionsClassName;
    }
}