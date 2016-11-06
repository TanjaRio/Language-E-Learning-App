package no.westerdals.utils.web;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.fail;

/**
 * Same from PG5100
 */
public class WebTestBase {

    private static final AtomicLong counter = new AtomicLong(System.currentTimeMillis());

    private static WebDriver driver;


    protected WebDriver getDriver(){
        return driver;
    }

    protected String getPageSource(){
        return driver.getPageSource();
    }


    private static boolean tryToSetDriverIfExists(String property, Path path) {
        if (Files.exists(path)) {
            System.setProperty(property, path.toAbsolutePath().toString());
            return true;
        }
        return false;
    }

    private static void setupDriverExecutable(String executableName, String property) {
        String homeDir = System.getProperty("user.home");

        //first try Linux/Mac executable
        if (!tryToSetDriverIfExists(property, Paths.get(homeDir, executableName))) {
            //then check if on Windows
            if (!tryToSetDriverIfExists(property, Paths.get(homeDir, executableName + ".exe"))) {
                fail("Cannot locate the " + executableName + " in your home directory " + homeDir);
            }
        }
    }

    private static WebDriver getChromeDriver() {

        /*
            Need to have Chrome (eg version 53.x) and the Chrome Driver (eg 2.24),
            whose executable should be saved directly under your home directory

            see https://sites.google.com/a/chromium.org/chromedriver/getting-started
         */

        setupDriverExecutable("chromedriver", "webdriver.chrome.driver");

        return new ChromeDriver();
    }

    @BeforeClass
    public static void initDriver() throws InterruptedException {

        driver = getChromeDriver();

        /*
            When the integration tests in this class are run, it might be
            that WildFly is not ready yet, although it was started. So
            we need to wait till it is ready.
         */
        JBossUtil.waitForJBoss(30);
    }

    protected static String getUniqueId() {
        return "foo" + counter.incrementAndGet();
    }


    @AfterClass
    public static void stopDriver() {
        driver.close();
    }

    protected Boolean waitForPageToLoad() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 10); //give up after 10 seconds

        //keep executing the given JS till it returns "true", when page is fully loaded and ready
        return wait.until((ExpectedCondition<Boolean>) input -> {
            String res = jsExecutor.executeScript("return /loaded|complete/.test(document.readyState);").toString();
            return Boolean.parseBoolean(res);
        });
    }
}
