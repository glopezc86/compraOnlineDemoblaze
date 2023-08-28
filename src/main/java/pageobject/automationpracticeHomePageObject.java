package pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


@DefaultUrl(value ="https://demoblaze.com")
public class automationpracticeHomePageObject extends PageObject {
    @FindBy(id="sign-username")
    protected WebElementFacade txt_sign_username;

    @FindBy(id="sign-password")
    protected WebElementFacade txt_sign_password;

    @FindBy(xpath = "//button[normalize-space()='Sign up']")
    protected WebElementFacade button_SignUp;

    @FindBy(id = "signin2")
    protected WebElementFacade index_signin2;

    @FindBy(id = "login2")
    protected WebElementFacade linkLogin;

    @FindBy(id = "loginusername")
    protected WebElementFacade txtLoginUsername;

    @FindBy(id = "loginpassword")
    protected WebElementFacade txtLoginPassword;

    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
    protected WebElementFacade btnLogin;

    @FindBy(id = "itemc")
    protected WebElementFacade LinkCategoria;

    @FindBy(partialLinkText = "MacBook air")
    protected WebElementFacade linkProducto;

    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    protected WebElementFacade btnAddtoCart;

    @FindBy(xpath = "//a[@id='cartur']")
    protected WebElementFacade btnCart;

    @FindBy(xpath = "//td[normalize-space()='MacBook air']")
    protected WebElementFacade tableCarrito;

    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    protected WebElementFacade btnPlaceOrder;

    @FindBy(xpath = "//input[@id='name']")
    protected WebElementFacade inputPlaceOrderName;

    @FindBy(xpath = "//input[@id='country']")
    protected WebElementFacade inputPlaceOrderCountry;

    @FindBy(xpath = "//input[@id='city']")
    protected WebElementFacade inputPlaceOrderCity;

    @FindBy(xpath = "//input[@id='card']")
    protected WebElementFacade inputPlaceOrderCard;

    @FindBy(xpath = "//input[@id='month']")
    protected WebElementFacade inputPlaceOrderMonth;

    @FindBy(xpath = "//input[@id='year']")
    protected WebElementFacade inputPlaceOrderYear;

    @FindBy(xpath = "//button[normalize-space()='Purchase']")
    protected WebElementFacade btnPurchase;

    @FindBy(xpath = "//h2[normalize-space()='Thank you for your purchase!']")
    protected WebElementFacade textCompraExitosa;

    public void addSingUp(String username, String password){
        index_signin2.click();
        txt_sign_username.sendKeys(username);
        txt_sign_password.sendKeys(password);
        button_SignUp.click();
    }

    public String clickAceptarAlert(WebDriver driver ) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 15);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String msg = alert.getText();
        System.out.println(alert.getText());
        alert.accept();
        return msg;
    }


    public void loguearse(String username, String contraseia) {

        if (existeElemento(linkLogin)) {
            linkLogin.click();
            txtLoginUsername.sendKeys(username);
            txtLoginPassword.sendKeys(contraseia);
            btnLogin.click();
            existeElemento(LinkCategoria);
        } else {

        }
        resetImplicitTimeout();
    }

    public void addCart(){
        existeElemento(btnAddtoCart);
        btnAddtoCart.click();
    }

    public void clickBtnCart(){
        btnCart.click();
    }

    public void validarCarrito(){
        existeElemento(tableCarrito);
    }

    public void clickPlaceOrder(){
        btnPlaceOrder.click();
    }

    public void ingresarDatosPlaceOrder(){
        inputPlaceOrderName.sendKeys("Pablito Clavo Clavito");
        inputPlaceOrderCountry.sendKeys("Colombia");
        inputPlaceOrderCity.sendKeys("Medellin");
        inputPlaceOrderCard.sendKeys("3000589912349876");
        inputPlaceOrderMonth.sendKeys("12");
        inputPlaceOrderYear.sendKeys("28");
    }

    public void clickPurchase(){
        btnPurchase.click();
    }

    public boolean validarCompra(){
        return existeElemento(textCompraExitosa);
    }

    private boolean existeElemento(WebElementFacade xpathElemento) {
        boolean estaPresente;
        try {
            estaPresente = xpathElemento.isCurrentlyVisible();
        } catch (Exception e) {
            return false;
        }
        return estaPresente;
    }


    public void selecciono_el_producto(String nombreProducto, WebDriver driver) {
        seleccionoCategoria("Laptops");
        //WebElement producto = findAll(By.xpath("//div[contains(@class, 'col-lg-4')]")).stream()
          //      .filter(element -> element.findElement(By.xpath("(//a[normalize-space()='MacBook air'])[1]")).getText().equals(nombreProducto))
             //   .findFirst()
               // .orElseThrow(() -> new RuntimeException("No se encontró el producto con el nombre: " + nombreProducto));

        WebElement producto = driver.findElement(By.xpath("//a[normalize-space()='MacBook air']"));
        System.out.println("Este es el texto: "+ producto.getText());
        producto.click();
    }

    public void seleccionoCategoria(String nombreCategoria) {
        System.out.println("estoy en categoria");
        WebElement producto = findAll(By.xpath("//a[contains(text(),'Laptops')]")).stream()
                .filter(element -> element.findElement(By.xpath("//a[contains(text(),'Laptops')]")).getText().equals(nombreCategoria))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró el producto con el nombre: " + nombreCategoria));

        producto.click();
    }
}
