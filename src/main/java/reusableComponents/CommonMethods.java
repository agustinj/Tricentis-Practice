package reusableComponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CommonMethods {

    //Common method for dropdown values
    public void selectDropdownOption(WebElement element, String valueToBeSelected) throws Exception {
        Select os = new Select(element);
        try {
            os.selectByVisibleText(valueToBeSelected);
        } catch(Exception e) {
            throw new Exception("Value is not present in dropdown for WebElement: "+element + "Value to be selected is: "+valueToBeSelected);
        }
    }

    //Common method for radio buttons
    public void selectRadioButtonValue(List<WebElement> element, String valueToBeSelected) {
        for (WebElement ref : element) {
            if(ref.getText().equalsIgnoreCase(valueToBeSelected)) {
                ref.click();
                break;
            }

        }
    }

    //Selecting check boxes
    public void selectCheckBoxes(List<WebElement> element, String checks) {
        String[] checksArray = checks.split(",");
        for (String str : checksArray) {   //speeding, Other
            for (WebElement ele : element) {
                if(ele.getText().equalsIgnoreCase(str)) {
                    ele.click();
                    break;
                }
            }
        }

    }

    //get dropdown options as list of string for comparison
    public List<String> getDropDownOptionsAsList(WebElement element) {
        Select os = new Select(element);
        List<WebElement> list_webElement_model = os.getOptions();
        List<String> actualContents = new ArrayList<String>();

        for (WebElement ref : list_webElement_model) {
            actualContents.add(ref.getText());
        }
        return actualContents;
    }


}
