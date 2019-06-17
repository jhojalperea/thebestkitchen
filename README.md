PROYECTO RESTAURANTE LA MEJOR COCINA 

El proyecto usa el motor de base de datos de Mysql.

Los pasos para poner en ejecución el proyecto son los siguientes:

INSTALACION DE LA BASE DE DATOS:

1. Instalar el motor de base de datos de Mysql (la versión de base de datos que se uso fue la 5.7).

2. Ejecutar el Siguiente script para la creación de la base de datos Restaurant
CREATE DATABASE Restaurant CHARACTER SET utf8 COLLATE utf8_general_ci;

3. Se debe ejecutar el script de base de datos (Restaurant.sql) sobre Restaurant, cabe resaltar que dicho script posee la creación de un par de vistas que quedaron amarradas al servidor "localhost", si se requiere un servidor o ip distinta se debe cambiar "localhost" por la correspondiente ip o nombre de servidor.
Luego se debe reemplazar en el script que sigue el usuario: {user} y la base de datos:{dataBase} corespondiente. 

mysql -u{user} -p {dataBase} < Restaurant.sql

4. Estos pasos tambien se pueden realizar mediante la interfaz grafica de phpMyAdmin o cualquier otro cliente de Mysql


COMPILACION Y GENERACION DEL .jar (Ubicación archivos de configuración ./src/main/resources):

1. Se debe descargar el proyecto Restaurant en la maquina.
2. Se debe cambiar el archivo de application.yaml al perfil de produccion modificando su contenido de 
spring:
  profiles.active: development
 
spring:
  profiles.active: production
  
Con esto lo obligamos a que tome como archivo de configuración el archivo application-production.yaml

3. En el archivo de application-production.yaml se debe modificar lo siguiente:
  a) El puerto por el cual se desea que corra la aplicacionsi se desea
  server:
    port: {port}
    
  b) Cadena de conexion a la base de datos:
  spring:
    datasource:
      url: jdbc:mysql://{ipServerMysql}:{portServerMysql}/{dataBase}?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull
        username: {user}
        password: {pass}
  
  c) Para mostrar la ventas de los venderores por periodo, se debe indicar la fecha de apertura del restaturante en formato     yyyy-MM asi: 2019-03, se puede cambiar al de su elección.
  
  application:
    restaurant-opening-date: '2019-03'

  d) Se debe cambiar la ubicación en donde se desea se escriban los los logs de la aplicación
  
  logs:
    directory: {logPath}
    
  e) Las condiciones del logback se encuentran en el archivo logback-spring.xml tales como nombre del archivo de logs, rotación, nivel de logueo, compresión, en donde loguea, etc.

4. Si se posee eclipse o STS se puede abrir dicho proyecto como File -> Import -> Existing Maven Project y buscar la carpeta del proyecto (Esto agregara el proyecto en el Workspace) y luego sobre el proyecto:
  a) clic derecho Maven -> Update Project...
  b) clic derecho Run As... -> Maven clean
  c) clic derecho Run As... -> Maven install

En caso de no tener ninguno de los 2 se puede realizar la generacion del .jar si posee instalado el comando mvn en la maquina de la siguiente manera con los siguientes comando (esto se debe hacer estando dentro del proyecto por linea de comandos):

mvn clean install -U

De juntas maneras se crea dentro del proyecto un archivo .jar dentro de target/Restaurant-0.0.1.jar.


EJECUCIÓN DEL PROYECTO:

Se puede ejecutar el proyecto de varias maneras:
1. Desde el STS o Eclipse dandole clic derecho sobre le proyecto, Run As... -> Spring Boot App

2. Puede ejecutar mediante el comando java -jar {locationJar}/Restaurant-0.0.1.jar o dentro de un contenedor docker

3. Si se desea ejecutar en servidor Web tal como Tomcat, WebLogic, JBoss es necesario hacer lo siguiente al proyecto:
  a) Agregar al POM la dependencia 
  <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
	</dependency>
  
  b) Agregar en el POM la siguiente linea 
  
  <packaging>war</packaging>
  
  quedando de la siguiente manera
  
  <groupId>com.aldeamo</groupId>
	<artifactId>SmsiWS</artifactId>
	<version>0.0.1</version>
	<packaging>war</packaging>
  
  c) Sobre el proyecto clic derecho Maven -> Update Project...
  d) Modificar el archivo RestaurantApplication.java del paquete com.thebestkitchen.restaurant ubicación del archivo ./src/main/java/com/thebestkitchen/restaurant
  
  cambiando de la linea 
  public class RestaurantApplication{
  
  a esta ...
  
  public class RestaurantApplication extends SpringBootServletInitializer {
  
  De estas maneras se ejecutara el proyecto y lo podra probar en el navegador como http://localhost:{port}

  e) Nuevamente generar los pasos de del apartado COMPILACION Y GENERACION DEL .jar desde el punto 4.
  
  Con esto pasos se generara un archivo Restaurant-0.0.1.war o .jar segun desee
