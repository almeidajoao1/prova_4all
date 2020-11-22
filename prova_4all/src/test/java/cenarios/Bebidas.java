package cenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.BebidasPage;

public class Bebidas {

	@Rule
	public TestName testName = new TestName(); // Devolve o nome do meu @Teste
	WebDriver driver;
	BebidasPage bebidas;
	public static final Logger logger = Logger.getLogger(Doces.class);
	long inicioTeste;
	long fimTeste;

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

	public void fecharPage() {
		bebidas.fecharPoupup();
	}

	public Long calculaTempoExecucao(long inicio, long fim) {
		return (fim - inicio) / 1000;
	}

	@After
	public void fecharPagina() {
		driver.quit();
		fimTeste = System.currentTimeMillis();
		logger.info("Teste: " + testName.getMethodName() + " Finalizado com Sucesso!");
		logger.info("Tempo de execução: " + calculaTempoExecucao(inicioTeste, fimTeste) + " - segundos");
	}
}