# Generador y Comprobador de Contraseñas
<p align="center">
  <img src="https://github.com/IS-G1-23-34/CypherKey/blob/main/src/main/resources/static/img/logo.png" width="200" align="middle" />
</p>
 Este proyecto es una herramienta simple que te permite generar contraseñas seguras y comprobar la fortaleza de las contraseñas existentes. Es útil para garantizar la seguridad de tus cuentas en línea y proteger tus datos personales.

## Características

- Generación de Contraseñas: Crea contraseñas aleatorias y seguras con diferentes longitudes y opciones de caracteres.

- Comprobación de Fortaleza: Evalúa la fortaleza de una contraseña existente y proporciona consejos para mejorarla.

- Interfaz Fácil de Usar: Una interfaz sencilla y amigable para los usuarios, incluso si no tienes experiencia técnica.

## Instalación mediante Docker
```bash
git clone https://github.com/IS-G1-23-34/CypherKey
cd CypherKey
sudo docker build -t cypher-key:spring-docker .
sudo docker run -p 8080:8080 cypher-key:spring-docker .
```

## Cómo Usar

 Una vez dentro de la página, la web contendrá, por un lado, la opción de generador y, por otro, la opción de comprobador.

 El generador funcionará inicialmente tal que se presiona un botón y automáticamente genere una contraseña de 12 caracteres aleatorios.
 
 El comprobador de contraseñas recibirá una entrada escrita y devolverá una serie de pautas a corregir para que dicha contraseña sea segura.

## Versión de escritorio

Existe una versión de CypherKey descargable de manera gratuita.

Para obtenerla, accede a https://github.com/IS-G1-23-34/CypherKeyDesktop/releases/tag/v1.0.1

En este repositorio, podrás descargar CypherKey-win32-x64.zip haciendo click sobre el fichero.

Una vez descomprimido tras descargar, dentro de la carpeta, ejecuta CypherKey.exe para empezar a utilizar la aplicación en su versión de escritorio.

Puedes crear un acceso directo en Escritorio para hacer más fácil su utilización.
