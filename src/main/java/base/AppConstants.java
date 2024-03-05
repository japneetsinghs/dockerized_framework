package base;

public class AppConstants
{
    //Defaults to be used if no parameters provided from mvn test -DbrowserName or
    // mvn test -Dplatform or
    // mvn test -DbrowserName=firefox -Dplatform=remote
    public static final String browserName = System.getProperty("browserName", "chrome");
    public static final String platform = System.getProperty("platform", "remote_git");

    //public static final String enableBrowserOptions = System.getProperty("enableBrowserOptions", "false");


}
