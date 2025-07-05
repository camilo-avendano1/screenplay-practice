#Author: Camilo Avendano
  #language: en

  Feature: Autenticacion de usuario
    Como usuario del sistema Automation Exercise
    Quiero iniciar sesion con mis credenciales
    Para acceder a las funcionalidades privadas de mi cuenta

    Scenario: Login exitoso con credenciales validas
      Given Estoy en la pagina principal
      When doy click en el botón de inicio de sesion
      And ingreso el correo de usuario "test-camilo@test.com"
      And ingreso la contraseña "test1234"
      And hago clic en el boton de login
      Then deberia ver el texto "Logged in as test-camilo"
