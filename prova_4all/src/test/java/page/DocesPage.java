package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocesPage extends BasePage {

	public DocesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	final String LISTA = "//*[@id=\"open-categories-btn\"]";
	final String DOCES = "//*[@id=\"category-1\"]";
	final String CARRINHO1 = "//*[@id=\"add-product-4-btn\"]";
	final String CARRINHO2 = "//*[@id=\"add-product-5-btn\"]";
	final String TODOS = "//*[@id=\"category-all\"]";
	final String CARRINHO = "//*[@id=\"cart-btn\"]/img";
	final String AUMENTAR = "//*[@id=\"add-product-4-qtd\"]/span";
	final String FINALIZAR = "//*[@id=\"finish-checkout-button\"]";
	final String FECHAR = "//*[@id=\"root\"]/div[3]/div/div/div/button";

	/**
	 * Este método seleciona, dentro da lista, o tipo "Doces". Adiciona todos os
	 * produtos no carrinho e segue para a tela de checkout. Na tela de checkout,
	 * irei Finalizar a Compra.
	 * 
	 * @throws InterruptedException
	 */
	public void listaDoces() throws InterruptedException {

		driver.findElement(By.xpath(LISTA)).click();
		driver.findElement(By.xpath(DOCES)).click();
		driver.findElement(By.xpath(CARRINHO1)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CARRINHO2)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(LISTA)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(TODOS)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CARRINHO)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AUMENTAR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AUMENTAR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AUMENTAR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(FINALIZAR)).click();
		driver.findElement(By.xpath(FECHAR)).click();
	}
}