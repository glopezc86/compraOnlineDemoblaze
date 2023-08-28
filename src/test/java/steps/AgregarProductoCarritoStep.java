package steps;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import pageobject.automationpracticeHomePageObject;

public class AgregarProductoCarritoStep {

    private automationpracticeHomePageObject paginaPrincipal;

    @Step
    public void abrir_en_navegador_la_aplicacion(WebDriver driver) {
        paginaPrincipal.open();
        driver.manage().window().maximize();
    }

    @Step
    public void singUP(String username, String contraseia){
        paginaPrincipal.addSingUp(username,contraseia);
    }

    @Step
    public String validarAlert(WebDriver driver){
        return paginaPrincipal.clickAceptarAlert(driver);
    }

    @Step
    public void loguearse(String username,String password){
        paginaPrincipal.loguearse(username,password);
    }

    @Step
    public void agregarProducto(String producto, WebDriver driver){
        paginaPrincipal.selecciono_el_producto(producto, driver);
    }

    @Step
    public void addToCart(){
        paginaPrincipal.addCart();
    }

    @Step
    public void clickBtnCart(){
        paginaPrincipal.clickBtnCart();
    }

    @Step
    public void validarCarrito(){
        paginaPrincipal.validarCarrito();
    }

    @Step
    public void clickPlaceOrder(){
        paginaPrincipal.clickPlaceOrder();
    }

    @Step
    public void ingresarDatosPlaceOrder(){
        paginaPrincipal.ingresarDatosPlaceOrder();
    }

    @Step
    public void clickPurchase(){
        paginaPrincipal.clickPurchase();
    }

    @Step
    public boolean validarCompra(){
        return paginaPrincipal.validarCompra();
    }

}