@driver:chrome
Feature: Realizar compra de Articulo

  Scenario: Iniciar sesion usuario registrado
    Given el usuario se registra en el sitio web
    When ingresa username y password
    Then la aplicacion muestra mensaje Sign up successful


  Scenario: Añadir productos al carrito y completar la compra
    Given que me encuentro logueado con "user12499" y "12345"
    When selecciono el producto "MacBook air"
    And anado la "MacBook air" al carrito de compras
    And navego al carrito de compras para validar orden
    And completo la informacion tomar la orden y compra
    Then deberia recibir una confirmacion de compra exitosa