import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MyAppUITest extends BaseConfig {

    @Test
    public void TestTitleClick() throws InterruptedException {

         org.openqa.selenium.WebElement element;

         Thread.sleep(10000);

         final String idTitleClick = "com.companyname.testapp:id/TitleLabel";
         element = driver.findElement(By.id((idTitleClick)));
         element.click();
         String elementText = element.getText();
         assertEquals("Вот молодец!",elementText);

    }

   @Test
    public void TestCentralButtonClick() throws  InterruptedException{
    //com.companyname.testapp:id/CounterButton
       org.openqa.selenium.WebElement element;

       Thread.sleep(10000);

       final String idCentralButton = "com.companyname.testapp:id/CounterButton";

       element = driver.findElement(By.id(idCentralButton));

       element.click();
       String text = element.getText();

       assertEquals("Количество нажатий: 1 раз", text);

       element.click();
       text = element.getText();

       assertEquals("Количество нажатий: 2 раз", text);

    }


    @Test
    public void TestBottomButtonsClick() throws  InterruptedException{
        org.openqa.selenium.WebElement element;

        Thread.sleep(10000);

        String xpath = "//android.widget.Button[@text=\"Увеличить\"]";
        element = driver.findElement(By.xpath(xpath));
        element.click();
        String value = "//android.widget.TextView[@text=\"Значение счётчика: 1\"]";
        element = driver.findElement(By.xpath(value));
        assertNotNull(element);
        String text = element.getText();
        assertEquals("Значение счётчика: 1", text);

        //Задаем переменной идентификатор, найденный с помощью апиум инспектора
        String idDecreaseButton = "com.companyname.testapp:id/DecreaseCounterButton";

        //Получаем этот элемент
        element=driver.findElement(By.id(idDecreaseButton));

        //Кликаем на найденный элемент
        element.click();

        //Получаем элемент со строкой по xpath
        String valueDecreaseButton = "//android.widget.TextView[@text=\"Значение счётчика: 0\"]";
        element = driver.findElement(By.xpath(valueDecreaseButton));

        //Убеждаемся, что элемент получен
        assertNotNull(element);

        //Получаем текст из элемента
        String textDecreaseButton = element.getText();

        //И убеждаемся, что текст корректный
        assertEquals("Значение счётчика: 0", textDecreaseButton);
    }

}
