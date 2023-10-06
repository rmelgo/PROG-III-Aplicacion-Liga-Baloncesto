# PROG-III-Aplicación-Liga-Baloncesto

![Liga_Femenina_2012](https://github.com/rmelgo/PROG-III-Aplicacion-Liga-Baloncesto/assets/145989723/6f320300-5df6-44e1-95c6-4b57d82b27dc)

# - Introducción

Proyecto realizado en la asignatura de Programación III del grado de Ingenieria Informática de la Universidad de Salamanca.  
  
El principal objetivo de este proyecto es la realización de un programa en Java que gestione la información de una liga de baloncesto femenino.

# - Estructura de la aplicación

La aplicación se encuentra estructurada en los siguientes ficheros:

- Un fichero llamado ***Practica_final.java***, que se encarga de mostrar el menú principal de la aplicación.
- Un fichero llamado ***View.java***, que se encarga de realizar la interacción con el usuario (representación de información y petición de datos al usuario asi como la presentación de los submenús).
- Un fichero llamado ***Controller.java***, que se encarga de controlar el flujo de información entre el usuario y el modelo de la aplicación.
- Un fichero llamado ***Jugadora.java***, que se encarga de almacenar los datos relativos a una jugadora:  
  - Nombre
  - Posición
  - Dorsal
  - Fecha de nacimiento
  - Nacionalidad
  - Altura
 
- Un fichero llamado ***Equipo.java***, que se encarga de almacenar los datos relativos a un equipo:    
  - Nombre
  - Dirección
  - Teléfono
  - Web
  - Email
  - Lista de jugadoras  
- Un fichero llamado ***Jornada.java***, que se encarga de almacenar los datos relativos a una jornada de la liga:
  - Número de la jornada
  - Fecha
  - Lista de partidos de la jornada
  - Clasificación asociada a dicha jornada
- Un fichero llamado ***Datos_equipo.java***, que se encarga de almacenar los datos relativos de un equipo en la clasificación de la liga:
  - Nombre del equipo
  - Número de partidos jugados
  - Número de partidos ganados
  - Número de partidos perdidos
  - Puntos a favor
  - Puntos en contra
  - Puntos en la clasificación
- Un fichero llamado ***Partido.java***, que se encarga de almacenar los datos relativos a un partido:
  - Nombre equipo local
  - Nombre equipo visitante
  - Puntos equipo local
  - Puntos equipo visitante
  - Fecha
  - Hora
- Un fichero llamado ***LigaFem.java***, que se encarga de almacenar los datos de una temporada completa de la liga:
  - Nombre de la temporada
  - Lista de jornadas
  - Lista de equipos

# - Funcionalidades de la aplicación

Todos los datos que genera o utiliza la aplicación se encuentran en un una carpeta llamada *"LigFemBal"* que debe situarse obligatoriamente en el escritorio. En caso contrario, la aplicación no funcionará correctamente.

En el arranque de la aplicación, se comprobará si existen datos previamente guardados dentro de la subcarpeta *"binarios"* dentro de la carpeta *"LigFemBal"*. Si existen datos guardados, se cargaran dichos datos en la aplicación. Logicamente, la primera vez que se ejecute la aplicación, la carpeta *"binarios"* estará vacia.

- **Gestión de la temporada** 
  
  - **Iniciar temporada**: Se introduce el nombre de la temporada de la cual se desean introducir datos.
  - **Cargar jornadas**: Se cargarán los datos relativos a todas las jornadas de la liga. Estos datos se encuentran en un fichero llamado ***datosjornadas.txt*** dentro de la carpeta *"LigFemBal"*. Este fichero se trata de un fichero CSV con el separador "+" para separar los atributos de cada jornada, el separador "#" para separar los distintos partidos de una jornadas y el separador "$" para separar los datos de cada partido de la jornada.
  - **Cargar equipos**: Se cargarán los datos relativos a todos los equipos de la liga. Estos datos se encuentran en un fichero llamado ***datosequipos.txt*** dentro de la carpeta *"LigFemBal"*. Este fichero se trata de un fichero CSV con el separador "#" para separar los distintos atributos de cada equipo.
  - **Cargar jugadoras**: Se cargarán los datos relativos a las jugadoras de cada equipo de la liga. En la subcarpeta ***jugadoras*** dentro de la carpeta *"LigFemBal"* existe un fichero por cada equipo de la liga (con el nombre correspondiente al equipo), donde cada uno de estos ficheros contiene las jugadoras del equipo correspondiente. Estos ficheros se tratan de ficheros CSV con el separador "\t" para separar los distintos atributos de cada jugadora. Es posible que algunos atributos de una jugadora esten vacios. En ese caso, habrá 2 tabuladores juntos.
 
(***Nota***: Cada una de esta funcionalidades solo puede ejecutarse una vez y debe ejecutarse de manera secuencial)
 
- **Gestión de jugadoras**
  - **Modificar datos de una jugadora**: Se pedirá el nombre de la jugadora cuyos datos se desean modificar y posteriormente se introducen los datos deseados. Si la jugadora no existe, se producirá un error y se alertará al usuario de la situación.
  - **Eliminar jugadora de un equipo**: Se pedirá el nombre de la jugadora que se desea eliminar y se elimina la jugadora del equipo al que pertenece. Si la jugadora no existe, se producirá un error y se alertará al usuario de la situación.
  - **Añadir jugadora a un equipo**: Se pedirán los datos de la jugadora que se desea añadir y al equipo al que pertenecerá. Si el equipo no existe, se producirá un error y se alertará al usuario de la situación.
 
- **Gestión de la jornada**
  - **Leer resultados de la jornada**: En la subcarpeta ***resul_jornadas*** dentro de la carpeta *"LigFemBal"* existe un fichero por cada jornada donde cada fichero contiene los resultados de los partidos de dicha jornada. De esta manera, se pedirá el número de la jornada de la cual se desean leer los resultados y la apliación lee los resultados de los partidos de dicha jornada introducida. Al realizar la carga de los resultados de una jornada, tambien se calculará la clasificación de dicha jornada, teniendo en cuenta los datos de jornadas anteriores.
  - **Modificar fecha de la jornada**: Se pedirá el número de la jornada que la cual se desea modificar su fecha y se introduce la nueva fecha.
  - **Modificar fecha u hora de un partido**: Se pedirá el número de la jornada y el nombre de uno de los equipos que participan en el partido del cual se desea modificar su fecha u hora y se introduce la nueva fecha u hora.
  - **Mostrar los resutados de la jornada**: Se pedirá el número de la jornada y se muestra los resultados de los partidos de dicha jornada en un listado.
  - **Mostrar la clasificación de una jornada**: Se pedirá el número de la jornada y se muestra la clasifiación de lo equipos de la liga en dicha jornada en un listado.
 
- **Visualización de resultados**
  - **Jugadoras de un equipo**: Se pedirá el nombre del equipo y se mostrará un listado con las jugadoras que pertenecen a dicho equipo ordenado por posición y altura. Si el equipo no existe, se producirá un error y se alertará al usuario de la situación.
  - **Relación de equipos**: Se mostrará un listado con la información de los distintos equipos de la liga ordenados por el número de telefono.
  - **Relación de jugadoras**: Se pedirá la letra inicial del nombre y se mostrará un listado con las jugadoras cuyo nombre empieza por esa letra ordenadas por fecha de nacimiento.
 
- **Almacenamiento de resultados**
  - **Jugadoras de un equipo**: Se pedirá el nombre del equipo y se generará un fichero encolumnado con el nombre del equipo y extensión .enc, que almacenará la información de las distintias jugadoras que pertenecen a dicho equipo. Si el equipo no existe, se producirá un error y se alertará al usuario de la situación.
  - **Relación de equipos**: Se generará un fichero encolumnado llamado ***equipos.enc***, que almacenará la información de los distintos equipos de la liga (nombre, telefono, web y email).
  - **Clasificación de una jornada**: Se pedirá el número de la jornada y se generará un fichero html que almacenará la clasificación de la liga en la jornada introducida. El nombre de dicho fichero será n.hmtl siendo n el número de la jornada introducida.
 
(***Nota***: Los ficheros generados se almacenan en la subcarpeta ***fichsalida*** dentro de la carpeta *"LigFemBal"*)

- **Salida de la aplicación**  
Cuando el usuario salga de la aplicación, automaticamente se guardaran todos los datos de la aplicación en un fichero con formato binario llamado ***binario.txt*** dentro de la la subcarpeta ***binarios*** dentro de la carpeta *"LigFemBal"*.
  

# - Comentarios sobre el entorno de desarrollo

Para la elaboración y compilación de este programa, se ha utilizado el framework **Netbeans** en su versión **12.0** y la version de **Java 14**. 

De esta manera, una alternativa para ejecutar la aplicación es utilizar la consola de **Netbeans** pero siempre es posible ejecutar la aplicación por la terminal utilizando los comandos adecuados.

# - Ejemplo de ejecución

En las siguientes imagenes, se muestra un ejemplo del uso y funcionamiento de la aplicación:    

<p>
  <img src="https://github.com/rmelgo/Operaciones-con-polinomios/assets/145989723/88f585eb-965c-4fd9-86c9-93a796561b5d" />
</p>
