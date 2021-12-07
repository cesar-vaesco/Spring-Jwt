

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
          - access_token
          - token_type
          - expires_in
        - opcionales
          - refresh_token
          - scope

        - https://www.oauth.com/oauth2-servers/access-tokens/access-token-response/
