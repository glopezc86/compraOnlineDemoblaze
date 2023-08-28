package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import steps.AgregarProductoCarritoStep;

public class AgregarProductoCarritoDefinitions {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    AgregarProductoCarritoStep pasos;

    @Given("^el usuario se registra en el sitio web$")
    public void el_ingreso_a_la_tienda_virtual() {
        pasos.abrir_en_navegador_la_aplicacion(driver);
    }


    @When("^ingresa username y password$")
    public void ingreso_usuario_y_clave() {
        pasos.singUP("user12785","12345");
    }
    @Then("la aplicacion muestra mensaje Sign up successful")
    public void la_aplicacion_muestra_mensaje_Sign_up_successful() {
        MatcherAssert.assertThat("Sign up successful.", Matchers.equalTo(pasos.validarAlert(driver)));
    }

    /******************************* Compra productos *******************************/

    @Given("^que me encuentro logueado con \"([^\"]*)\" y \"([^\"]*)\"$")
    public void que_me_encuentro_logueado_con_y(String user, String password) {
        pasos.abrir_en_navegador_la_aplicacion(driver);
        pasos.loguearse(user, password);
    }

    @When("^selecciono el producto \"([^\"]*)\"$")
    public void selecciono_el_producto(String arg1) {
        pasos.agregarProducto(arg1,driver);
    }

    @When("^anado la \"([^\"]*)\" al carrito de compras$")
    public void anado_la_al_carrito_de_compras(String arg1) {
        pasos.addToCart();
        pasos.validarAlert(driver);
    }

    @When("^navego al carrito de compras para validar orden$")
    public void navego_al_carrito_de_compras_para_validar_orden() {
        pasos.clickBtnCart();
        pasos.validarCarrito();
        pasos.clickPlaceOrder();
    }

    @When("^completo la informacion tomar la orden y compra$")
    public void completo_la_informacion_tomar_la_orden_y_compra() {
        pasos.ingresarDatosPlaceOrder();
        pasos.clickPurchase();
    }

    @Then("^deberia recibir una confirmacion de compra exitosa$")
    public void deberia_recibir_una_confirmacion_de_compra_exitosa() {
        Assert.assertTrue(pasos.validarCompra());
    }
}
