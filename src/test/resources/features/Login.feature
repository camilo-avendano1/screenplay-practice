#Author: Camilo Avendano
  #language: en

  Feature: Autenticacion de usuario
    Como usuario del sistema Automation Exercise
    Quiero iniciar sesion con mis credenciales
    Para acceder a las funcionalidades privadas de mi cuenta

    Scenario: Intento de login fallido con credenciales inválidas
      Given Estoy en la página de inicio de sesión
      When intento iniciar sesión con correo "usuario_inexistente@test.com" y contraseña "incorrecta"
      Then el sistema muestra un mensaje de error "Your email or password is incorrect!"


    Scenario: Login exitoso con credenciales validas
      Given Estoy en la pagina principal
      When intento iniciar sesión con correo "test-camilo@test.com" y contraseña "test1234"
      Then deberia ver el texto "Logged in as test-camilo"

