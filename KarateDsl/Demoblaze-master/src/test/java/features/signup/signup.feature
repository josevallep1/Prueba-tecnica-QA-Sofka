Feature:
for  Test signup: Crear un nuevo usuario en signup y Intentar crear un usuario ya existente

  Background:
    * url base_url
    * def randomData = Java.type('utils.RandomData')
    * def requestBody = read('classpath:requestsBody.json')

  Scenario:  Crear un nuevo usuario en signup
    * def usernameRandom = randomData.randomFirstName() + randomData.randomLastName() + randomData.randomNumber()
    * set requestBody.bodyGeneral.username = usernameRandom
    Given path 'signup'
    And request requestBody.bodyGeneral
    When method POST
    Then status 200

  Scenario: Intentar crear un usuario ya existente
    Given path 'signup'
    And request requestBody.bodyGeneral
    When method post
    Then status 200
    And match response.errorMessage == 'This user already exist.'
