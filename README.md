# sofkau-challenge

Juego de preguntas y respuestas, donde se puede responder y crear cuestionarios.
Reto desarrollado en Java para el proceso de selección del Training League de desarrollo de software de SofkaU.

## Configuración base de datos
Se utilizó una base de datos relacional con MySQL
### Montar base de datos:
-> Importar y ejecutar el Script de SQL db/EntityRelationshipModel.sql
### Configurar credenciales:
-> Editar las credenciales PASSWORD y USER en el archivo src/Model/Config.java --- Los atributos SERVER, PORT y USER tienen los valores por defecto de MySQL, deben modificarse de ser necesario. No editar el atributo DB.

#### Otros:
-> MySQL Connector/J versión 8.0.27 - Descargado desde https://downloads.mysql.com/archives/c-j/)
