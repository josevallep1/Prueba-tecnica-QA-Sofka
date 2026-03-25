Feature:Comprar en el sitio web de Demoblaze

  Como cliente de la tienda
  Quiero agregar varios artículos a mi carrito y realizar el pago
  Para asegurar que el flujo del comercio electrónico funcione correctamente

  @test
  Scenario: Realizar una compra exitosa
    Given el usuario está en la página de inicio de Demoblaze
    When agrega productos al carrito
    Then completa exitosamente la compra de los productos