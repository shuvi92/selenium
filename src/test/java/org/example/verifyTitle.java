package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyTitle {
    /*Automation Practice Assignment
1. Write an Automation Script to verify the Title of the
www.automationpractice.com
Hint: Define a String as Expected value, then get the Title of the page using WebDriver  to compare between then using Assert between the values.
2. Write an Automation Script to search the Dress code as “Saree”. Verify  there is no record for the Dress with message “0 results have been found”
3. Verify, the Shopping cart is empty initially , when clicked on empty  shopping cart , it brings to you Shopping-cart summary page with  message as “Your cart is empty”
4. Verify My Account Footer section has Links using an Array String
My orders
My credit slips
My addresses
My personal info
5. Verify the NewsLetter section works.
Hint: provide wrong email address eg: without @ or .com, there should be  message Newsletter : Invalid email address. on the below the Tab Menu. And if the email is right  Newsletter : “You have successfully subscribed to this newsletter” message must be  shown.
6. Scroll Bar
Click on Women menu
Change the Price range using Automation to Maximum $53 to $53
Page 1 of 5
7. Image Handling
Click on Dresses
Change the view type to List from Grid
Click on the 4th Image of the Gallery
Again click to see the view the Larger Picture Gallery
Click next to see scroll all the images
Finally close the image clicking on close button
8. Verify Add to Cart Works
Select the 3rd listed product from index page and add to cart. Verify after  adding to the card, The status of the cart on top right corner changes from  empty to 1.
9. Verify Cart Functionality Works
Click on Dresses
Click on the Last Image of the Gallery
 Again click to see the view the Larger Picture Gallery
 Change the no of quantity to 3
 Size to Large
 Click to Add to Cart button
 Verify the pop up with Size, Quantity and Total price
 Close the button and Close the Web Driver.
10. Alert Box
1. Navigate to https://www.toolsqa.com/handling-alerts-using-selenium webdriver/
Page 2 of 5
2. Click on Simple Alert Button to show the alert box
3. Verify the message is “A Simple Alert”
4. Click Ok
5. Click on Confirm Pop Up Button to show the alert box
6. Verify the message is “Confirm pop up with OK and Cancel button” 7. Click Cancel Button
8. Click on Prompt Pop Up Button to show the alert box
9. Verify the message is “Do you like toolsqa?”
10. Verify Yes/No is selected as default
11. change Yes/No to Confirm
12. Click Ok
11.Toolsqa.com
https://www.toolsqa.com/automation-practice-form/
1. Verify the partial link test exists and it links to /automation-practice-form/  2. Verify Link Test text exists and links to /automation-practice-table  3. Enter first name
4. Enter last name
5. Choose Sex as Female
6. Year of Experience should be 5 only
7. Put date of todays date, read system date
8. Professional should be manual and automation both
9. Verify download links for both links
10.Automation tool should be QTP and Selenium WebDriver  11.Continent should be north America and Europe
12.Selenium commands should All in the List
13.Don’t click just verify 4 buttons are present and click button 3  14.Count the list items of drinks (here 4)
12.Drag and Drop Example
Navigate to: http://demo.guru99.com/test/drag_drop.html
Page 3 of 5
Drag the Bank block to Debit Side on Account [ Verify Debit movement 0,  Credit Movement 0]
Drag 5000 Block to Debit Side on Amount [verify Debit movement 5000,  Credit Movement 0]
Drag the Sales block to Credit Side on Account [ Verify Debit movement 0,  Credit Movement 0]
Drag the 5000 block to Credit Side on Account [ Verify Debit movement 0,  Credit Movement 5000] and Perfect Button is displayed
13. Screen Shot Example
Screenshot are proof for testers. So Automation Script should be able to  track screenshots for every Actions the web driver performs.
1st Test Script
Try logging to gmail with happy path, capture screenshots for 3 pages  Email Page
Password Page
Profile page
2nd Test Script
Try logging to Gmail, capture screenshots only, When there is Failure on  any of the pages, with 1st Test script
Ie:
Email Page (invalid Email), Take screenshot of failure to login  Password Page (invalid Password), Take screenshot of failure of test case  Only take single screenshot
14. Data Driven Testing with Excel
Page 4 of 5
Create an excel Sheet where all the testing data are stored. The script  written should get data from ExcelSheet ie: Source.xlsx and perform the  login operation for valid user and password.
Source.xlsx
Site https://www.gmail.com
User ABC
Password
****


Hint: Use Apache POI api to read values form Excel Sheet
15. Finally, Keep all your assignment to your github.com and share the address  of that Repo.
Page 5 of 5
*/

    WebDriver driver;
    @Before
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?");
        driver.manage().window().maximize();
    }

    @Test
    public void title() throws InterruptedException{
        String title = driver.getTitle();
        String expected = "My Store";
        Assert.assertEquals(title,expected);
    }

    @After
    public void quit(){driver.close();}
}
