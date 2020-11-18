package cenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.BebidasPage;

public class Bebidas {

	public void verificaSistemaOperacionalESetaChromeDriver() {
		System.out.println(System.getProperty("os.name"));
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			System.setProperty("webdriver.chrome.driver", "chromedriverWin/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "chromedriverLix/chromedriver");
		}
	}

	WebDriver driver = new ChromeDriver();
	BebidasPage bebidas;

	@Before
	public void abrirJanela() {
		driver.manage().window().maximize();
		bebidas = new BebidasPage(driver);
		bebidas.abrirURL("https://shopcart-challenge.4all.com/");
	}

	@Test
	public void selecionarDoces() throws InterruptedException {
		bebidas.listaBebidas();
		Thread.sleep(5000);
	}

	@After
	public void fecharPagina() {
		driver.quit();
	}

}