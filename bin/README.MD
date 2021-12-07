

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
