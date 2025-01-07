# FernanShop ✏️
Práctica Obligatoria Tema 3: Clases y Objetos.
Realidazo por Carlos Cañada Sánchez y Eduardo Cruz Muñoz (1º DAM)

Construcción en proceso... Disculpen los errores 🙇🏻‍♂️🙇🏻‍♂️


# Indice

- INTRODUCCIÓN
- REQUISITOS MÍNIMOS
- DESCARGA
- MANUAL DE USUARIO
    - MENÚ PRINCIPAL
        - INICIO DE SESIÓN
        - REGISTRO
    - MENÚ CLIENTE
        - CONSULTAR CATÁLOGO DE PRODUCTOS
        - REALIZAR PEDIDO
        - VER MIS PEDIDOS REALIZADOS
        - VER MIS DATOS PERSONALES
        - MODIFICAR MIS DATOS PERSONALES
        - CERRAR SESIÓN
    - MENÚ TRABAJADOR
        - CONSULTAR LOS PEDIDOS QUE TENGO ASIGNADOS
        - MODIFICAR EL ESTADO DE UN PEDIDO
        - CONSULTAR EL CATÁLOGO DE PRODUCTOS
        - MODIFICAR UN PRODUCTO DEL CATÁLOGO
        - VER MI PERFIL
        - MODIFICAR MIS DATOS PERSONALES
        - CERRAR SESIÓN
    - MENÚ ADMINISTRADOR
        - ASIGNAR UN PEDIDO A UN TRABAJADOR
        - MODIFICAR EL ESTADO DE UN PEDIDO
        - DAR DE ALTA UN TRABAJADOR
        - VER TODOS LOS PEDIDOS
        - VER TODOS LOS CLIENTES
        - VER TODOS LOS TRABAJADORES
        - CERRAR SESIÓN
- COLABORADORES


# INTRODUCCIÓN
En este repositorio, se les dará a conocer la aplicación de e-comerce de la papelería/librería "FernanShop", cuyos almacenes tienen sede en la localidad de Martos (Jaén). 

En esta aplicación prodrán encontrar una aplicación en la que cada usuario podrá acceder como tres tipos de usuarios diferente: cliente, trabajador y administrador.

¿Qué podremos hacer con cada usuario?
Lo detallaremos con más profundidad en siguientes apartados, pero podremos hacer cosas tales como:
- Cliente: Podrá ver el catálogo y realizar 2 pedidos de hasta 2 productos diferentes máximo (y tanta cantidad de cada uno como stock se disponga), ver sus datos y modificarlos.
- Trabajador: podrá consultar los pedidos asignados (máximo 2 pedidos), gestionar el estado de cada pedido, consultar el catálogo, ver su perfil y modificar sus datos.
- Administrador: podrá asignar pedidos que se han quedado sin asignar a los trabajadores, modificar el estado de un pedido, dar de alta a los trabajadores, ver todos los pedidos así como los clientes y los trabajadores.

Por el momento, somos conscientes de que la aplicación se encuentra incompleta y pedimos disculpas por ello. Trabajaremos duro para solucionar los problemas existentes, ampliar según los plazos lo requiera y estar al día con el trabajo.


# REQUISITOS MÍNIMOS 💻
Para poder descargar y utilizar el programa, es necesario tener instalado el siguiente programa:
- Java Runtime Envrioment 23

Para comprobar la versión de Java que tiene instalado debe realizar los siguientes pasos:
- Abrir la consola del Símbolo del sistema (buscar en la barra de búsqueda de Windows)

![image](https://github.com/user-attachments/assets/57cd02ad-aed9-4856-8f23-f7114042fba9)

- Y a continuación, escribir el comando "java -version"

![image](https://github.com/user-attachments/assets/af192d47-3e63-4103-bcef-431011e0ed9e)

A continuación vemos la versión instalada en nuestro equipo, en caso de ser uno diferente al JRE23, puede descargarlo e instalarlo en el siguiente enlace:

- https://www.oracle.com/es/java/technologies/downloads/

Una vez dentro, dirigase a la pesataña de Windows (si es su caso) y descargue el apartado de x64 MSI Installer

![image](https://github.com/user-attachments/assets/bc8bdd85-ed4d-4db5-aae2-0a16dda62924)

![image](https://github.com/user-attachments/assets/50bc11a1-52c7-4c38-bb00-27fd779caf1b)



# DESCARGA 💾
Para la descarga, primero debe ir al repositorio del proyecto, les dejamos el siguiente enlace para llegar a él.

https://github.com/Carloscs053/FernanShop.git

Abrimos la pesataña que pone "<> Code" y descargamos el archivo ZIP

![image](https://github.com/user-attachments/assets/47caf690-87de-4c23-b744-9c102fe3da51)

Vamos a la carpeta dónde se haya descargado la carpeta y con click derecho clicamos en "Extraer todo..."

Nos aparecerá una ventana como la siguiente:

![image](https://github.com/user-attachments/assets/10ca7b03-2cb4-4824-a3a6-22c842dcca85)

Clicamos en "Examinar..." y le indicamos la ruta que deseemos

A continuación, en la ruta "out/artifacts/FernanShop_jar" y clicamos en el archivo llamado "FernanShop" que aparece marcado en la captura

![image](https://github.com/user-attachments/assets/b7d02244-07e3-4b85-8586-d6a4b494d5f6)


# MANUAL DE USUARIO 📖
- MENÚ PRINCIPAL
  Al abrir el programa, nos dará dos opciones: Iniciar sesión y Registrarse.
  En este caso, el registro no funcionará porque todos los usuarios están creados.

![image](https://github.com/user-attachments/assets/28fdc10a-bd4d-4b25-b27c-d0d85e5f7974)

- INICIO DE SESIÓN
  A continuación, nos preguntará las credenciales:
  ![image](https://github.com/user-attachments/assets/c5c04d8d-cb7d-40e4-af29-0c91eb22f026)

- REGISTRO:
  De lo contrario, nos pedirá los datos necesarios para crear un usuario cliente, ya que los trabajadores son dados de alta por el administrador y este a su vez ya está preestablecido.
  
  ![image](https://github.com/user-attachments/assets/a12b25f9-8b13-4e64-8ad7-758412cb386e)
  
  En este caso, al estar todos los usuarios completos, no nos registra un nuevo usuario.


- MENÚ DE CLIENTE
  Para acceder a un usuario Cliente, usaremos el email "Antonio@gmail.com" y la contraseña 1234.

  Nos aparecerá el menú del cliente:

  ![image](https://github.com/user-attachments/assets/d851739d-634b-4137-82f7-4107377226e4)

  Si le damos al primer apartado, nos mostrará los productos que están disponibles

  ![image](https://github.com/user-attachments/assets/7f2469b2-cd5f-4076-8b15-6fb81fc057e7)

  Si le damos a la segunda opción, accedemos a la realización del pedido

  ![image](https://github.com/user-attachments/assets/42419397-8ac4-4606-9903-c5fa7d43bf7f)

  Y nos dejará seleccionar el producto, terminar el producto y cancelar el pedido

  Si le damos a la opción 3, nos mostrará los pedidos realizados. En este caso no hay pedidos realizados pero nos mostraría los datos del pedido que ha sido realizado.

  ![image](https://github.com/user-attachments/assets/2c95b70a-9776-4556-94b9-ff32a07d8fae)

  En la opción 4, podremos ver los datos del usuario

  ![image](https://github.com/user-attachments/assets/79608f96-1a81-42f0-8f12-06727b824a99)

  En la opción 5, podremos modificar los datos del cliente

  ![image](https://github.com/user-attachments/assets/a6956e63-2ceb-41eb-b6af-7fdd4153d4f8)


- MENÚ TRABAJADOR

  Las opciones en el menú del trabajador son las siguientes:

  ![image](https://github.com/user-attachments/assets/c11477e4-d9ec-49c0-afbe-182bf1189cc2)

  En la opción 1, aparece los pedidos pendientes

  ![image](https://github.com/user-attachments/assets/a4d6a67b-86d2-498f-9f4e-e262a7e18d45)

  En la segunda opción, podemos modificar un pedido y podremos llegar a él a través del código del pedido

  ![image](https://github.com/user-attachments/assets/564e62f8-5994-4390-a0a5-39189a33d06e)

  En la opción 3, podremos consultar el catálogo

  ![image](https://github.com/user-attachments/assets/4ace8d6f-ae6b-4ebc-b32a-9d38307e47f1)

  En la opción 4, podemos modificar los datos de un producto

  ![image](https://github.com/user-attachments/assets/485ef742-8eed-49cf-9624-872f5f182faa)

  ![image](https://github.com/user-attachments/assets/d81e53fc-f6e7-45d4-9ad5-58b24a1f106a)

  En el apartado 5, nos mostrará los datos el trabajador

  ![image](https://github.com/user-attachments/assets/a1093961-94be-44d4-997d-3dab993847a1)

  En el apartado 6 cambiaremos algunos de los datos del trabajador

  ![image](https://github.com/user-attachments/assets/6ec22a6c-5d1f-4e0e-b28e-3074358d749f)


- MENÚ ADMINISTRADOR
  A contunación, mostraré el menú del administrador

  ![image](https://github.com/user-attachments/assets/cc374cc8-226e-4dd6-8572-816a4f263132)

  En el apartado 1 nos indicará los pedidos pendientes de asignar y nos permitirá asignarselo a un trabajador

  ![image](https://github.com/user-attachments/assets/b09378dc-8015-48d8-91bb-84521fc4fe4c)

  ![image](https://github.com/user-attachments/assets/4f8a8978-2a37-472a-a14c-87e4fd39e60b)

  En el apartado 2, al igual que en el trabajador, podremos modificar el estado de un pedido

  ![image](https://github.com/user-attachments/assets/943cb041-e7fe-4773-8185-776df6eaed25)

  ![image](https://github.com/user-attachments/assets/ad6cecd2-dbb7-4a68-8d50-7004badfe88b)

  Como vemos, para pasar de un punto a otro lo tiene que hacer de forma ordenada y nos permitirá poner los días de retraso y un comentario al pedido

  ![image](https://github.com/user-attachments/assets/68141d2d-b14c-4466-979c-cbdfcd47ee78)

  En el apartado 4 podremos ver los pedidos que hay pendientes

  ![image](https://github.com/user-attachments/assets/56d074a6-5e1d-4116-b629-3215275053d7)

  En el apartado 5 veremos los clientes

  ![image](https://github.com/user-attachments/assets/8075c593-d845-4208-8f41-fa4eaa2e60a7)

  Y en el apartado 6 veremos a los trabajadores

  ![image](https://github.com/user-attachments/assets/eaa260c6-dd81-4957-a387-2a532f3198fa)



# COLABORADORES
Este proyecto ha sido realizado por:
    - Carlos Cañada Sánchez: https://github.com/Carloscs053
    - Eduardo Cruz Muñoz: https://github.com/EduardoCruzmunioz
