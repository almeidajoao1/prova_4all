package cenarios;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.DocesPage;

public class Doces {

	/**
	 * Este método visa confrigurar o drive. Esta classe será possível ser excutada
	 * em ambiente windows e linux.
	 */
	public void verificaSistemaOperacionalESetaChromeDriver() {
		System.out.println(System.getProperty("os.name"));
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			System.setProperty("webdriver.chrome.driver", "chromedriverWin/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "chromedriverLix/chromedriver");
		}
	}

	WebDriver driver = new ChromeDriver();
	DocesPage doces;

	@Before
	public void abrirJanela() {
		driver.manage().window().maximize();
		doces = new DocesPage(driver);
		doces.abrirURL("https://shopcart-challenge.4all.com/");
	}

	@Test
	public void selecionarDoces() throws InterruptedException, IOException {
		doces.listaDoces();
		doces.carrinho();
		Thread.sleep(5000);
	}

	@After
	public void fecharPagina() {
		driver.quit();
	}

}