import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestTable {
    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }


    @Test
    public void tableHW(){
        WebElement row4 = wd.findElement(By.cssSelector("#customers tr:nth-child(4)"));
        System.out.println(row4.getText());
        String text = row4.getText();
        Assert.assertTrue(text.contains("Mexico"));
    }

    @Test
    public void tableHW2(){
        List<WebElement> rows = wd.findElements(By.cssSelector("#customers tr"));
        System.out.println(rows.size());
        Assert.assertEquals(rows.size(),9);

        List<WebElement> cols = wd.findElements(By.cssSelector("#customers th"));
        System.out.println(cols.size());
        Assert.assertEquals(cols.size(),3);

        WebElement row3 = wd.findElement(By.cssSelector("#customers tr:nth-child(3)"));
        System.out.println(row3.getText());

        WebElement lastCol = wd.findElement(By.cssSelector("#customers tr:last-child td:last-child"));
        System.out.println(lastCol.getText());

//        List<WebElement> rowName = wd.findElements(By.cssSelector("#customers tr:nth-child(7) td"));
//        System.out.println(rowName);
        // print number of row with name "Philip Cramer"
    }


    @AfterMethod
    public void tearDuwn() {
        wd.quit();

    }

}