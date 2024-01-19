package com.ecom.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.Base.TestBase;

public class StorefrontHomepage extends TestBase {
	// tab-sectin: cat names
	// div[@class="tabs-sec"]//div[@class="tab-items"]//ul//li//a[text()=" Gin "]

	// div[@class="prdct-crd p-2 cursor-pointer"][1]//div[@class="item-info"]//h5
	// div[@class="prdct-crd p-2
	// cursor-pointer"][1]//div[@class="item-info"]//div[@class="item-desc"]
	// div[@class="prdct-crd p-2
	// cursor-pointer"][1]//div[@class="item-info"]//div[@class="price-addcart"]//h6

	// cat_tabs
	@FindBy(xpath = "//div[@class=\"tabs-sec\"]//div[@class=\"tab-items\"]//ul//li//a")
	List<WebElement> cat_tabs;

	@FindBy(xpath = "//div[@class=\"item-header\"]//h6")
	WebElement Item_count_in_each_catgry;

	@FindBy(xpath = "//div[@title=\"Next\"]")
	WebElement next_page;

	@FindBy(xpath = "//div[@class=\"modal-box\"]//div//button[1]")
	public WebElement cookie_Accept;

	@FindBy(xpath = "//div[@class=\"modal-box\"]//div//button[1]")
	public WebElement consent_popup;

	@FindBy(xpath = "//div[@class=\"prd-pagination\"]//div[@class=\"page-nums\"]//ul//li")
	public WebElement pagination_count;

	// Initializing the Page Objects:
	public StorefrontHomepage() {
		PageFactory.initElements(driver, this);
	}

	public int Cat_count() throws InterruptedException {
		Thread.sleep(12000);
		Pattern p = Pattern.compile("(\\d+)");
		Matcher m = p.matcher(Item_count_in_each_catgry.getText().trim());

		while (m.find()) {
			Integer.valueOf(m.group(1));
		}
		return Integer.valueOf(m.group(1));
	}

	// Item_name
	@FindBy(xpath = "//div[@class=\"prdct-crd p-2 cursor-pointer\"]//div[@class=\"item-info\"]//h5")
	List<WebElement> Item_name;

	// Item_name
	@FindBy(xpath = "//div[@class=\"prdct-crd p-2 cursor-pointer\"]//div[@class=\"item-info\"]//div[@class=\"item-desc\"]")
	List<WebElement> Item_description;

	// Item_name
	@FindBy(xpath = "//div[@class=\"prdct-crd p-2 cursor-pointer\"]//div[@class=\"item-info\"]//div[@class=\"price-addcart\"]//h6")
	List<WebElement> Item_Price;

	@FindBy(xpath = "//div[@class=\"prd-pagination\"]//div[@class=\"page-nums\"]//ul//li")
	public List<WebElement> pages;

	List<WebElement> each_cat_pages;

	
	
	public void Extract_Inventry() throws InterruptedException {
		List<Products> list_ltems = null;
		Products prod;
		Map<String, List<Products>> map;
		for (int i = 1; i < cat_tabs.size(); i++) {

			System.out.println("categry size:" + cat_tabs.size());
			String cat_tab_name = cat_tabs.get(i).getText(); // cat_tab_name
			System.out.println("cat_tab_name::" + cat_tab_name);
			each_cat_pages = driver
					.findElements(By.xpath("//div[@class=\"prd-pagination\"]//div[@class=\"page-nums\"]//ul//li"));
			// ScrollIntoView(pagination_count);
			prod = new Products();
			map = new HashMap<>();
			list_ltems = new ArrayList<Products>();

			for (int p = 1; p <= each_cat_pages.size(); p++) {

				if (p != 1) {
					driver.findElement(
							By.xpath("//div[@class=\"prd-pagination\"]//div[@class=\"page-nums\"]//ul//li[text()=\" "
									+ p + " \"]"))
							.click();
					Thread.sleep(3000);
				}

				ScrollIntoView(pagination_count);
				for (int j = 1; j <= Item_name.size(); j++) {

					String Item_name = driver.findElement(By.xpath(
							"//div[@class=\"prdct-crd p-2 cursor-pointer\"][" + j + "]//div[@class=\"item-info\"]//h5"))
							.getText();
					String Item_desc = driver.findElement(By.xpath("//div[@class=\"prdct-crd p-2 cursor-pointer\"][" + j
							+ "]//div[@class=\"item-info\"]//div[@class=\"item-desc\"]")).getText();
					String Item_price = driver.findElement(By.xpath("//div[@class=\"prdct-crd p-2 cursor-pointer\"]["
							+ j + "]//div[@class=\"item-info\"]//div[@class=\"price-addcart\"]//h6")).getText();

					prod.setP_name(Item_name);
					prod.setP_des(Item_desc);
					prod.setP_price(Item_price);
					list_ltems.add(prod);

					System.out.println("prod.getname():" + prod.getP_name() + "  Prod price:" + prod.getP_price());

				}

			}

			map.put(cat_tab_name, list_ltems);
			
			if(i!=1) {
			System.out.println("CLick on Category...!!");
				driver.findElement(By.xpath("(//div[@class=\"tabs-sec\"]//div[@class=\"tab-items\"]//ul//li//a)["+i+"]")).click();

			}
		
		}

	}
	
}
