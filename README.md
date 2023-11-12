# PRUEBAQUIPUX


1. Implemente utilizando MAVEN, JPA, en su IDE Favorito y usando las
bibliotecas Java de su elección un conjunto de API cuyo contrato se detalla
a continuación:

HTTP Plantilla URI Descripción
POST /lists Añadir una nueva lista de reproducción.
Si se añade satisfactoriamente, devuelve “201
Created” con la referencia a la URI y el contenido de
la lista.
Si el nombre de la lista no es válido (ej: null) debe
devolver
un error “400 Bad Request”.

GET /lists Ver todas las listas de reproducción existentes
/lists/{listName} Ver descripción de una lista de reproducción

seleccionada.
Si la lista no existe, debe devolver un “404 Not
Found”.

DELETE /lists/{listName} Borrar una lista de reproducción.

Si se realiza correctamente, debe devolver un
“204 No Content”.
Si la lista no existe debe devolver un “404 Not
Found”.

Para la implementación de la API, tener en cuenta:
● La representación JSON de los recursos del servicio es:

Lista de Reproducción: Una lista de reproducción tiene nombre, descripción y un
conjunto de canciones.
{
"nombre": "Lista 1",
"descripcion": "Lista de canciones de Spotify",
"canciones": [
{
"titulo": "",
"artista": """album": "",
"anno": "",
"genero": ""
},
{

"titulo": "",
"artista": "",
"album": "",
"anno": "",
"genero": ""
},
...
]
}
Canción: Cada canción tiene un título, nombre del artista, álbum, año y género.
{
"titulo": "",
"artista": "",
"album": "",
"anno": "",
"genero": ""
}
● Implementar autenticación y autorización (preferiblemente con JWT).

● Implemente una capa de persistencia en una base de datos runtime
(Sugerencia h2).

● Probar la aplicación usando alguna de las extensiones para REST en el
navegador (ej Advanced REST Client para Chrome o Postman) y entregar
cliente configurado.

● Implementar pruebas unitarias.

● Para el género se debe consumir el servicio de spotify, el cual le retornará una lista
de géneros, para esto se debe crear una cuenta que no tarda más de 10 minutos y
con la colección de postman adjunta se pueden guiar en la implementación del
consumo desde java, este servicio es para tenerl a nível de back y será insumo para
el siguiente ejercicio.

Url configuración developer spotify (Creación de cuenta y obtener token)
https://stackoverflow.com/questions/60659902/how-to-get-oauth-token-from-spotify
Postman con categorías musicales
https://api.postman.com/collections/8508934-a390d52e-6914-4c62-916e-8b60bc86e
006?access_key=PMAT-01GR5906WDGQCZ5Q9XFH2GN6XM

2. Implementar un proyecto Web (Angular, Vue, Jsf, etc) en el cual se
visualicen formularios que le permitan interactuar con las APIs creadas en
el ejercicio anterior.
Nota: se debe enviar la ruta del repositorio gitlab o github, donde se
evidencia los commits realizados.
