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

import page.DocesPage;

public class Doces {

	@Rule
	public TestName testName = new TestName(); // Devolve o nome do meu @Teste
	WebDriver driver;
	DocesPage doces;
	public static final Logger logger = Logger.getLogger(Doces.class);
	long inicioTeste;
	long fimTeste;

	/**
	 * Este método visa confrigurar o drive. Esta classe será possível ser excutada
	 * em ambiente Windows e Linux.
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
		doces = new DocesPage(driver);
		doces.abrirURL("https://shopcart-challenge.4all.com/");
	}

	@Test
	public void selecionarDoces() throws InterruptedException, IOException {
		doces.listaDoces();
		doces.carrinho();
	}

	public void validarMensagem() {
		Assert.assertEquals("Pedido realizado com sucesso!", doces.getMensagem());
	}

	public void fecharPage() {
		doces.fecharPoupup();
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