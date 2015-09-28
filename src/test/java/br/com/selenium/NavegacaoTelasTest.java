package br.com.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NavegacaoTelasTest {

	private static final String CHROME_DRIVER = "~/chromedriver";

	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	public void deveNavenarParaAPaginaIndex() {
		driver.navigate().to("http://localhost:8080/selenium/index.jsp");
		Assert.assertEquals("Pagina Index", driver.getTitle());
	}

	@Test
	public void deveNavenarDaPaginaIndexParaPagina1() {
		driver.navigate().to("http://localhost:8080/selenium/index.jsp");
		Select select = new Select(driver.findElement(By.id("pagina")));
		select.selectByValue("pagina1");
		driver.findElement(By.tagName("form")).submit();
		Assert.assertEquals("Pagina 1", driver.getTitle());
	}

	@Test
	public void deveNavenarDaPaginaIndexParaPagina2() {
		driver.navigate().to("http://localhost:8080/selenium/index.jsp");
		Select select = new Select(driver.findElement(By.id("pagina")));
		select.selectByValue("pagina2");
		driver.findElement(By.tagName("form")).submit();
		Assert.assertEquals("Pagina 2", driver.getTitle());
	}

}
