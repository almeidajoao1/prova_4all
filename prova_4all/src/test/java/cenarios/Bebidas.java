package cenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.BebidasPage;

public class Bebidas {

	WebDriver driver;
	BebidasPage bebidas;

	/**
	 * Este método visa confrigurar o drive. Esta classe será possível ser excutada
	 * em ambiente windows e Linux.
	 */
	public void verificaSistemaOperacionalESetaChromeDriver() {
		System.out.println(System.getProperty("os.name"));
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			System.setProperty("webdriver.chrome.driver", "chromedriverWin/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "chromedriverLix/chromedriver");
		}
	}

	public void setupChrome() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Before
	public void abrirJanela() {
		verificaSistemaOperacionalESetaChromeDriver();
		setupChrome();
		bebidas = new BebidasPage(driver);
		bebidas.abrirURL("https://shopcart-challenge.4all.com/");
	}

	@Test
	public void selecionarDoces() throws InterruptedException, IOException {
		bebidas.listaBebidas();
		bebidas.carrinho();
	}

	public void validarMensagem() {
		Assert.assertEquals("Pedido realizado com sucesso!", bebidas.getMensagem());
	}

	@After
	public void fecharPagina() {
		driver.quit();
	}
}