package utils;


import com.hrms.testbase.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class CommonMethods extends PageInitializer {


    /**
     * This method will clear a text box and send given text
     *
     * @param element
     * @param text
     */
    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * This method will return an object of Explicit Wait with time
     * set to 10 seconds
     *
     * @return WebDriverWait
     */
    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    /**
     * This method will wait for an element to be clickable before clicking
     *
     * @param element
     */
    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method will wait until element is clickable, then click
     *
     * @param element
     */
    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    /**
     * This method will click on a radio button or checkbox by the given
     * list of webelements and your specified attribute value
     *
     * @param checkboxes
     * @param value
     */
    public static void clickRadioOrCheckboxByValue(List<WebElement> checkboxes, String value) {

        for (WebElement checkbox : checkboxes) {
            String actualValue = checkbox.getAttribute("value").trim();
            if (checkbox.isEnabled() && actualValue.equals(value)) {
                click(checkbox);
                break;
            }
        }

    }

    public static void clickRadioOrCheckboxByText(List<WebElement> checkboxes, String text) {

        for (WebElement checkbox : checkboxes) {
            String actualText = checkbox.getText().trim();
            System.out.println(actualText);
            if (actualText.equals(text)) {
                click(checkbox);
                break;
            }
        }

    }

    public static String generateRandomstring(String username) {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        username = generatedString;

        return username;
    }

        private static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    public static void jsSendText(WebElement element, String text) {
        waitForClickability(element);
        getJSExecutor().executeScript("arguments[0].value='" + text + "';", element);
    }

    /**
     * This method creates screenshot and outputs to screenshots
     *
     * @param fileName
     */
    public static byte[] takeScreenshot(String fileName) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOTS_FILEPATH + fileName + getTimeStamp() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }

    public static String getTimeStamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return sdf.format(date);
    }

    public static void dropdownSelectByText(WebElement element, String text) {

        try {
            Select select = new Select(element);

            List<WebElement> listOfOptions = select.getOptions();

            for (WebElement option : listOfOptions) {
                if (option.getText().equals(text)) {
                    select.selectByVisibleText(text);
                    break;
                }
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }


    public static void dropdownSelectByValue(WebElement element, String value) {
        try {
            Select select = new Select(element);

            List<WebElement> listOfOptions = select.getOptions();

            for (WebElement option : listOfOptions) {
                if (option.getAttribute("value").equals(value)) {
                    select.selectByValue(value);
                    break;
                }
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }

    public static void switchToFrameByElement(WebElement frameElement) {
        try {
            driver.switchTo().frame(frameElement);
        } catch (NoSuchFrameException nsf) {
            nsf.printStackTrace();
        }
    }

    public static void switchToFrameByIndex(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (NoSuchFrameException nsf) {
            nsf.printStackTrace();
        }
    }

    public static void switchToFrameByName(String name) {
        try {
            driver.switchTo().frame(name);
        } catch (NoSuchFrameException nsf) {
            nsf.printStackTrace();
        }
    }

    public static void switchToFrameByID(String id) {
        try {
            driver.switchTo().frame(id);
        } catch (NoSuchFrameException nsf) {
            nsf.printStackTrace();
        }
    }

    public static void dropdownSelectByIndex(WebElement element, int index) {
        Select select = new Select(element);

        List<WebElement> listOfOptions = select.getOptions();
        int listSize = listOfOptions.size();

        if (listSize > index) {
            select.selectByIndex(index);
        }

    }

    public static boolean switchToChildWindow() {
        boolean isChildHandle = false;
        String parentHandle = driver.getWindowHandle();

        Set<String> allHandles = driver.getWindowHandles();

        for (String handle : allHandles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                isChildHandle = true;
                break;
            }
        }

        return isChildHandle;

    }

    //HW create method that switches back to parent if sw

    public static void switchBackToParent() {

        if (switchToChildWindow()) {
            String childHandle = driver.getWindowHandle();

            Set<String> allHandles = driver.getWindowHandles();

            for (String handle : allHandles) {
                if (!handle.equals(childHandle)) {
                    driver.switchTo().window(handle);
                }
            }

        }

    }

    public static List<String> getDropdownOptionStrings(WebElement dropdown) {
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        List<String> dropDownOptionText = new ArrayList<>();

        for (WebElement option : options) {
            dropDownOptionText.add(option.getText());
        }

        return dropDownOptionText;
    }

    public static List<String> getDropdownOptionsSkipFirstOption(WebElement dropdown, String firstOption) {
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        List<String> dropDownOptionText = new ArrayList<>();

        for (WebElement option : options) {
            if (option.getText().equals(firstOption)) {
                continue;
            }
            dropDownOptionText.add(option.getText());
        }

        return dropDownOptionText;
    }


}

