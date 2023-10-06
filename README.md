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
 
- **Gestión de jugadoras**
  - **Modificar datos de una jugadora**: Se introduce el nombre de la jugadora cuyos datos se desean modificar y posteriormente se introducen los datos deseados. Si la jugadora no existe, se producirá un error y se alertará al usuario de la situación.
  - **Eliminar jugadora de un equipo**: Se introduce el nombre de la jugadora que se desea eliminar y se elimina la jugadora del equipo al que pertenece. Si la jugadora no existe, se producirá un error y se alertará al usuario de la situación.
  - **Añadir jugadora a un equipo**: Se introduce los datos de la jugadora que se desea añadir y al equipo al que pertenecerá. Si el equipo no existe, se producirá un error y se alertará al usuario de la situación.
 
- **Gestión de la jornada**
  - **Modificar datos de una jugadora**: Se introduce el nombre de la jugadora cuyos datos se desean modificar y posteriormente se introducen los datos deseados. Si la jugadora no existe, se producirá un error y se alertará al usuario de la situación.

# - Comentarios sobre el entorno de ejecución

Para ejecutar este programa se requerira de una distribución del Sistema Operativo **GNU/Linux**.    

Para poder ensamblar, enlazar y compilar correctamente el programa, se debera ejecutar el script de bash llamado ***instaladorcii.sh***, el cual se encuentra dentro de este repositorio.   

Este script comprobará que tenéis la distribución de Linux compatible y se descargará y configurará los programas *as6809*, *aslink* y *m6809-run* (necesarios para el ensablado, enlazado y compilado) adecuadamente, siempre que dispongáis de una conexión a Internet en vuestro ordenador.

# - Pasos necesarios para ejecutar el programa

**Paso 1: Ensamblar el programa**  

Para ello se debe introducir el siguente comando:    

```as6809 -o practica_final.asm```

Tras ejecutar este comando, se generará un fichero llamado *practica_final.rel*

**Paso 2: Enlazar el programa**  

Para ello se debe introducir el siguente comando:    

```aslink -s practica_final.rel```

Tras ejecutar este comando, se generará un fichero llamado *practica_final.s19*

**Paso 3: Ejecutar el programa**  

Para ello se debe introducir el siguente comando:    

```m6809-run practica_final.s19```

Tras ejecutar este comando, el programa se habra ejecutado correctamente.

# - Ejemplo de ejecución

En la siguiente imagen, se muestra un ejemplo del uso y funcionamiento del programa:    

<p>
  <img src="https://github.com/rmelgo/Operaciones-con-polinomios/assets/145989723/88f585eb-965c-4fd9-86c9-93a796561b5d" />
</p>
