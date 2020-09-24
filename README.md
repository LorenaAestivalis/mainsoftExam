# mainsoftExam

El desarrollo del API REST esta basado en en los contraladores:
  -ClienteController
    *Agregar
  -VentaController
    *Agregar
    *Listar
  -ProductoController
    *
El consumo de duchos servicios requiere Loggearse y adquirir el Token por  http://localhost:8080/login considerando las credenciales que estan en el documento user.txt, asi el metodo POST respondera con el token.
Cada vez que use un servicio deben incluir el token en el header;Por lo que entiende que la seguridad del proyecto esta basada en JTW.
Asi mismo se Logs para todos los contrladores c/u con Log4j2.

En el manejo de errores tenemos la clase ErrorManager con
HttpStatus Message

 Docker File.


