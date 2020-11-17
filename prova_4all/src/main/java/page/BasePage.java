package page;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Abrir a URL
	 * 
	 * @param url a ser aberta
	 */
	public void abrirURL(String url) {
		driver.get(url);
	}

	public void takeScreenShot(String nomeMetodo) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver; // Criando um obj do TakesScreenshot, recebendo um driver
		File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("output" + File.separator + nomeMetodo + ".jpg"));

	}

}