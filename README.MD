

 #### 1.- Estructura del proyecto
    - Dando estructura inicial al proyecto
    - Creando el método login

#### 2.- Obteniendo respuesta probando en 'POSTMAN' el método login
    - Identificando el puerto de salida
    - Indentificando la ruta del handler de nuestro login
    - Pasando el parametro del método, para el ejemplo es client_credentials
    - Agregando las palabras clave client_id y cliente_secret
    - La url queda de la siguiente manera:
      - http://localhost:8585/v1.0/oauth/client_credential/accesstoken?grant_type=client_credentials
    - Se debe obtener como respuesta http: 200

#### 3.- Información que debe de contener el response al pedir el token - DTO JwtResponse.java

    - Si la solicitud de un token de acceso es válida, el servidor de autorización debe generar un token de acceso (y un token de actualización opcional) y devolverlos al cliente, normalmente junto con algunas propiedades adicionales sobre la autorización.
    - La respuesta con un token de acceso debe contener las siguientes propiedades:
        - recomendados
          - String: access_token
          - String: token_type
          - int: expires_in
        - opcionales
          - String: refresh_token
          - String: scope

        - https://www.oauth.com/oauth2-servers/access-tokens/access-token-response/


#### 4.- Verificando que se obtenga respuesta al pedir el token

    -   AuthServices: se crea el servicio el cual va a entregar la respuesta a la solicitud del token utilizando los atributos de la clase JwtResponse
    -   Se refactoriza el método login para ontener los datos de la solicitud del token
     *** Los datos obtenidos en la respuesta son de prueba ***


#### 5.- Estructura de propiedades del jwt
    - Se crea la clase JwtIOProperties en la cual se crean varias clases estaticas para conformar la estructura


#### 6.- Configuración de properties
    - En el archivo properties.yml se han configurado el valor de las propiedades que se han declarado en la clase JwtIOProperties

    - Se agrega la dependencia spring-boot-configuration-processor en el archivo pom.xml para que el proyecto pueda leer las propiedades declaradas en el archivo JwtIOProperties

    - En properties.yml se agrega la siguiente instrucción para quitar el trace en la respuesta al cachar la excepción:
  ```
      server:
        port: 8585
        error:
            include-stacktrace: never
```

#### 7.- Utils

    * La clase Date de la librería Utils sirve para representar y dar formato a una fecha
    - DateUtils
      - En esta clase se han declarado tres métodos los cuales tienen por finalidad:
      - Dar formato a la fecha
      - Obtener la fecha en el momento en que se genere el token
      - Convertir la fecha de generación del token en milisegundos

    * Gson es una librería para Java que permite convertir nuestros objetos en representación Json y viceversa
    *
    - Gson Utils
      - En esta clase se han declarado tres métodos estaticos los cuales:
      - Dan formato json a cadena de tipo string y viceversa

#### 8.- Validators

    - Se ha agregado una excepción personalizada mandando código de respuesta y tipo de excepcion generada al momento de generar el token con datos erroneos.
    - Se ha creado la clase AuthValidator en la cual se busca validar con el método validate que:
      - CLIENT_CREDENTIALS cuente con el valor correcto
      - grantType no venga vacio y que su valor sea igual a CLIENT_CREDENTIALS
      - ParamMap(Colección de parametros) no vengan invalidados o vacios
    - En el método login (AuthController) se ha agregado el método  validator.validate(paramMap, grantType);



#### 9.- Agregando JWT a nuestro proyecto

    - El proyecto/libreria usado es fusionauth/fusionauth-jwt
      - Repo: https://github.com/fusionauth/fusionauth-jwt
    - https://jwt.io/libraries?language=Java

    - En el pom.xml se agrega la librería de JWT

    - Se crea archivo JwtIo en paquete security y los atributos de este archivo se valuan con los valores de el archivo aplication.yml dandole valores por defecto
      - En este archivo se crea el método que genera el token generateToken(Object src)
    - En class AuthServices se modifican los valores en duro por valores asignados en variables
    *** Hasta este punto, ya se puede verificar la generación del token a través de postman y verificar el contenido del token usando el debugger de jwt.io***


    - Se continua con la implementación de la clase JwtIO crando el método que valida el token
    - Se configura el método que carga(getPayload) la información del Jwt

    - En el paquete security se crea la clase InterceptorJwtIO en el cual se crea la funcionalidad que permite limitaro validar  las rutas a las cuales se tiene permiso con el token

    - Se crea la clase JwtController en la cual se hace la primera prueba de las rutas a interceptar; para efectos de la practica de momento es permitido el accesoS
#### 10.-
