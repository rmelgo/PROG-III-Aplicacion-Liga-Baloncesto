# PROG-III-Aplicación-Liga-Baloncesto

![polinomios](https://github.com/rmelgo/Operaciones-con-polinomios/assets/145989723/d4fb4e43-b340-464b-b91c-ad76af4004f0)

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
