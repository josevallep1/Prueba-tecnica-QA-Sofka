Feature:
  for  Test login: Usuario y password correcto en login y Usuario y password incorrecto en login

  Background:
    * url base_url
    * def requestBody = read('classpath:requestsBody.json')

  Scenario: Usuario y password correcto en login
    Given path 'login'
    And request requestBody.bodyGeneral
    When method post
    Then status 200
    * match response == '#string'
    * match response contains 'Auth_token'

  Scenario: Acceder con usuario y clave incorrecto API login
    * set requestBody.bodyGeneral.password = "12345678Errado"
    Given path 'login'
    And request requestBody.bodyGeneral
    When method post
    Then status 200
    And match response.errorMessage == 'Wrong password.'