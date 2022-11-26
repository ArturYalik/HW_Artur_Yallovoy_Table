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
    public void tableHW() {
        WebElement row4 = wd.findElement(By.cssSelector("#customers tr:nth-child(4)"));
        String text = row4.getText();
        Assert.assertTrue(text.contains("Mexico"));
        System.out.println(row4.getText());

        WebElement row4_1 = wd.findElement((By.xpath("//*[@id='customers']//tr[4]")));
        String txt = row4_1.getText();
        Assert.assertTrue(txt.contains("Mexico"));
        System.out.println(row4_1.getText());

        List<WebElement> row4_2 = wd.findElements((By.xpath("//*[@id='customers']//tr")));
        for (WebElement e : row4_2) {
            if (e.getText().contains("Mexico")) {
                System.out.println(e.getText());
            }
        }


    }

    @Test
    public void tableHW2() {
        List<WebElement> rows = wd.findElements(By.cssSelector("#customers tr"));
        System.out.println(rows.size());
        Assert.assertEquals(rows.size(), 9);

        List<WebElement> rows1 = wd.findElements(By.xpath("//*[@id='customers']//tr"));
        System.out.println(rows.size());
        Assert.assertEquals(rows.size(), 9);

        List<WebElement> rows2 = wd.findElements(By.xpath("//*[@id='customers']//tr"));
        int count = 0;
        for (int i = 0; i < rows2.size(); i++) {
            count = i + 1;
        }
        System.out.println(count);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        List<WebElement> cols = wd.findElements(By.cssSelector("#customers th"));
        System.out.println(cols.size());
        Assert.assertEquals(cols.size(), 3);

        List<WebElement> cols1 = wd.findElements(By.xpath("//*[@id='customers']//th"));
        System.out.println(cols.size());
        Assert.assertEquals(cols.size(), 3);

        List<WebElement> cols2 = wd.findElements(By.xpath("//*[@id='customers']//th"));
        int count1 = 0;
        for (int i = 0; i < cols2.size(); i++) {
            count1 = i + 1;
        }
        System.out.println(count1);
        //////////////////////////////////////////////////////////////////////////////////////////////////
        WebElement row3 = wd.findElement(By.cssSelector("#customers tr:nth-child(3)"));
        System.out.println(row3.getText());

        WebElement row3_1 = wd.findElement(By.xpath("//*[@id='customers']//tr[3]"));
        System.out.println(row3_1.getText());

        List<WebElement> row3_2 = wd.findElements(By.xpath("//*[@id='customers']//tr"));
        for (WebElement e : row3_2) {
            if (e.getText().contains("Christina Berglund")) {
                System.out.println(e.getText());
            }
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////
        List<WebElement> lastCol = wd.findElements(By.cssSelector("#customers td:last-child"));
        for (WebElement e : lastCol) {
            System.out.println(e.getText());
        }

        List<WebElement> lastCol1 = wd.findElements(By.xpath("//*[@id='customers']//td[last()]"));
        for (WebElement e : lastCol1) {
            System.out.println(e.getText());
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////
        List<WebElement> rowName = wd.findElements(By.cssSelector("#customers tr"));
        for (int i = 0; i < rowName.size(); i++) {
            if (rowName.get(i).getText().contains("Philip Cramer")) {
                System.out.println(i + 1);
            }
        }

        List<WebElement> rowName1 = wd.findElements(By.xpath("//*[@id='customers']//tr"));
        for (int i = 0; i < rowName1.size(); i++) {
            if (rowName1.get(i).getText().contains("Philip Cramer")) {
                System.out.println(i + 1);
            }
        }
    }


    @AfterMethod
    public void tearDuwn() {
        wd.quit();

    }

}