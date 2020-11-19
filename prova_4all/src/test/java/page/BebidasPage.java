package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BebidasPage extends BasePage {

	public BebidasPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	final String LISTA = "//*[@id=\"open-categories-btn\"]";
	final String BEBIDAS = "//*[@id=\"category-0\"]";
	final String CARRINHO1 = "//*[@id=\"add-product-0-btn\"]";
	final String CARRINHO2 = "//*[@id=\"add-product-1-btn\"]";
	final String CARRINHO3 = "//*[@id=\"add-product-2-btn\"]";
	final String TODOS = "//*[@id=\"category-all\"]";
	final String RISSOLE = "//*[@id=\"add-product-3-btn\"]";
	final String CARRINHO = "//*[@id=\"cart-products-qtd\"]";
	final String AUMENTAR = "//*[@id=\"add-product-3-qtd\"]/span";
	final String DIMINUIR = "//*[@id=\"remove-product-3-qtd\"]/span";
	final String FINALIZAR = "//*[@id=\"finish-checkout-button\"]";
	final String FECHAR = "//*[@id=\"root\"]/div[3]/div/div/div/button";

	/**
	 * Este método seleciona, dentro da lista, o tipo "Bebidas". Adiciona todos os
	 * produtos no carrinho e segue para a tela de checkout. Na tela de checkout,
	 * irei Finalizar a Compra.
	 * 
	 * @throws InterruptedException
	 */
	public void listaBebidas() throws InterruptedException {

		driver.findElement(By.xpath(LISTA)).click();
		driver.findElement(By.xpath(BEBIDAS)).click();
		driver.findElement(By.xpath(CARRINHO1)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CARRINHO2)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CARRINHO3)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(LISTA)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(TODOS)).click();
		driver.findElement(By.xpath(RISSOLE)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CARRINHO)).click();
		Thread.sleep(2000);
	}
	
	public void carrinho() throws InterruptedException, IOException {
		driver.findElement(By.xpath(AUMENTAR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AUMENTAR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AUMENTAR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AUMENTAR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AUMENTAR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AUMENTAR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AUMENTAR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AUMENTAR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(DIMINUIR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(DIMINUIR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(DIMINUIR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(DIMINUIR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(FINALIZAR)).click();
		takeScreenShot("bebidas_e_rissole"); //os arquivos do print vão para a pasta "output
		driver.findElement(By.xpath(FECHAR)).click();
	}
}