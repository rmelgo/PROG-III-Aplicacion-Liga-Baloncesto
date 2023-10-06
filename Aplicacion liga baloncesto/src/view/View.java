/*
 * Raúl Melgosa Salvador 70925689Z
 * rmelgo@usal.es
 * Copyright Raul Melgosa @
 */
package view;

import static com.coti.tools.Esdia.*;
import static com.coti.tools.Rutas.*;
import static com.coti.tools.OpMat.*;
import controller.Controller;
import data.LigaFem;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.err;
import static java.lang.System.out;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Melgo
 */
public class View {

    Controller c = new Controller();

    public void runMenuPrincipal(String menu) throws Exception {
        boolean salir = false;
        String opcion;
        String[] opcionesDisponibles = {"1", "2", "3", "4", "5", "q"};
        cargarPrograma();
        do {
            opcion = readString(menu, opcionesDisponibles);
            switch (opcion) {
                case "1":
                    runMenu1("%n%n1) Iniciar temporada%n"
                            + "2) Cargar jornadas%n"
                            + "3) Cargar equipos%n"
                            + "4) Cargar jugadoras%n"
                            + "q) Salir al menu principal");
                    break;
                case "2":
                    runMenu2("%n%n1) Modificar datos de una jugadora%n"
                            + "2) Eliminar una jugadora de un equipo%n"
                            + "3) Añadir una jugadora de un equipo%n"
                            + "q) Salir al menu principal");
                    break;
                case "3":
                    runMenu3("%n%n1) Leer los resultados de la jornada%n"
                            + "2) Modificar fecha de la jornada%n"
                            + "3) Modificar fecha u hora de un partido%n"
                            + "4) Mostrar los resultados de la jornada%n"
                            + "5) Mostrar la clasificacion de una jornada%n"
                            + "q) Salir al menu principal");
                    break;
                case "4":
                    runMenu4("%n%n1) Jugadoras de un equipo%n"
                            + "2) Relacion de equipos%n"
                            + "3) Relacion de jugadoras%n"
                            + "q) Salir al menu principal");
                    break;
                case "5":
                    runMenu5("%n%n1) Jugadoras de un equipo%n"
                            + "2) Relacion de equipos%n"
                            + "3) Clasificacion de una jornada%n"
                            + "q) Salir al menu principal");
                    break;
                case "q":
                    salir = yesOrNo("%n%nDesea realmente salir de la aplicacion?: ");
                    break;
                default:
                    out.printf("%n%nPerdon, eliga una de las opciones disponibles del menu%n%n");
                    break;
            }
        } while (!salir);
        guardarPrograma();
    }

    public void runMenu1(String menu1) {
        int veces = 0;
        boolean salir = false;
        String opcion;
        String[] opcionesDisponibles = {"1", "2", "3", "4", "q"};
        do {
            opcion = readString(menu1, opcionesDisponibles);
            switch (opcion) {
                case "1":
                    if (veces == 0) {
                        iniciarTemporada();
                        veces++;
                    } else {
                        out.printf("%n%nYa has cargado la temporada");
                    }
                    break;
                case "2":
                    if (veces == 1) {
                        cargarJornadas();
                        veces++;
                    } else if (veces > 1) {
                        out.printf("%n%nYa has cargado las jornadas");
                    } else {
                        out.printf("%n%nDebes cargar la temporada antes de cargar las jornadas");
                    }
                    break;
                case "3":
                    if (veces == 2) {
                        cargarEquipos();
                        veces++;
                    } else if (veces > 2) {
                        out.printf("%n%nYa has cargado los equipos");
                    } else {
                        out.printf("%n%nDebes cargar la temporada y las jornadas antes de cargar los equipos");
                    }
                    break;
                case "4":
                    if (veces == 3) {
                        cargarJugadoras();
                        veces++;
                    } else if (veces > 3) {
                        out.printf("%n%nYa has cargado las jugadoras");
                    } else {
                        out.printf("%n%nDebes cargar la temporada, las jornadas y los equipos antes de cargar las jugadoras");
                    }                   
                    break;
                case "q":
                    salir = yesOrNo("%n%nDesea realmente salir al menu principal?: ");
                    break;
                default:
                    out.printf("%n%nPerdon, eliga una de las opciones disponibles del menu%n%n");
                    break;
            }
        } while (!salir);
    }

    public void runMenu2(String menu2) {
        boolean salir = false;
        String opcion;
        String[] opcionesDisponibles = {"1", "2", "3", "q"};
        do {
            opcion = readString(menu2, opcionesDisponibles);
            switch (opcion) {
                case "1":
                    modificarDatosJugadora();
                    break;
                case "2":
                    eliminarJugadora();
                    break;
                case "3":
                    añadirJugadora();
                    break;
                case "q":
                    salir = yesOrNo("%n%nDesea realmente salir al menu principal?: ");
                    break;
                default:
                    out.printf("%n%nPerdon, eliga una de las opciones disponibles del menu%n%n");
                    break;
            }
        } while (!salir);
    }

    public void runMenu3(String menu3) throws Exception {
        boolean salir = false;
        String opcion;
        String[] opcionesDisponibles = {"1", "2", "3", "4", "5", "q"};
        do {
            opcion = readString(menu3, opcionesDisponibles);
            switch (opcion) {
                case "1":
                    leerResultadosJornada();
                    break;
                case "2":
                    modificarFechaJornada();
                    break;
                case "3":
                    modificarFechaHoraPartido();
                    break;
                case "4":
                    mostrarResultadosJornada();
                    break;
                case "5":
                    mostrarClasificacionJornada();
                    break;
                case "q":
                    salir = yesOrNo("%n%nDesea realmente salir al menu principal?: ");
                    break;
                default:
                    out.printf("%n%nPerdon, eliga una de las opciones disponibles del menu%n%n");
                    break;
            }
        } while (!salir);
    }

    public void runMenu4(String menu4) {
        boolean salir = false;
        String opcion;
        String[] opcionesDisponibles = {"1", "2", "3", "q"};
        do {
            opcion = readString(menu4, opcionesDisponibles);
            switch (opcion) {
                case "1":
                    mostrarJugadorasEquipo();
                    break;
                case "2":
                    mostrarRelacionEquipos();
                    break;
                case "3":
                    mostrarRelacionJugadoras();
                    break;
                case "q":
                    salir = yesOrNo("%n%nDesea realmente salir al menu principal?: ");
                    break;
                default:
                    out.printf("%n%nPerdon, eliga una de las opciones disponibles del menu%n%n");
                    break;
            }
        } while (!salir);
    }

    public void runMenu5(String menu5) throws Exception {
        boolean salir = false;
        String opcion;
        String[] opcionesDisponibles = {"1", "2", "3", "q"};
        do {
            opcion = readString(menu5, opcionesDisponibles);
            switch (opcion) {
                case "1":
                    almacenarJugadorasEquipo();
                    break;
                case "2":
                    almacenarRelacionEquipos();
                    break;
                case "3":
                    almacenarClasificacionJornada();
                    break;
                case "q":
                    salir = yesOrNo("%n%nDesea realmente salir al menu principal?: ");
                    break;
                default:
                    out.printf("%n%nPerdon, eliga una de las opciones disponibles del menu%n%n");
                    break;
            }
        } while (!salir);
    }

    private void iniciarTemporada() {
        String temporada;
        out.printf("%n%nHas elegido iniciar temporada");

        temporada = readString("%n%nIntroduce la temporada: ");
        
        c.setTemporada(temporada);

        out.printf("%n%nLeyendo temporada%n%n");
    }

    private void cargarJornadas() {
        String nombre_fichero = "datosjornadas.txt";
        String nombre_carpeta = "LigFemBal";
        out.printf("%n%nHas elegido cargar jornadas");

        File ruta_datos_jornadas = fileToFileInFolderOnDesktop(nombre_carpeta, nombre_fichero);

        out.printf("%n%nCargando jornadas...");

        c.importarJornadas(ruta_datos_jornadas);

        out.printf("%n%nSe han importado %d jornadas del fichero %s", c.getNumeroJornadas(), nombre_fichero);

    }

    private void cargarEquipos() {
        String nombre_fichero = "datosequipos.txt";
        String nombre_carpeta = "LigFemBal";
        out.printf("%n%nHas elegido cargar equipos");

        File ruta_datos_equipos = fileToFileInFolderOnDesktop(nombre_carpeta, nombre_fichero);

        out.printf("%n%nCargando equipos...");

        c.importarEquipos(ruta_datos_equipos);

        out.printf("%n%nSe han importado %d equipos del fichero %s", c.getNumeroDeEquipos(), nombre_fichero);
    }

    private void cargarJugadoras() {
        String[] nombres_equipos = c.getNombresEquipos();
        String nombre_carpeta = "LigFemBal" + File.separator + "jugadoras";
        out.printf("%n%nHas elegido cargar jugadoras");

        for (int i = 0; i < c.getNumeroDeEquipos(); i++) {
            String nombre_fichero = nombres_equipos[i] + ".txt";

            File ruta_datos_jugadoras = fileToFileInFolderOnDesktop(nombre_carpeta, nombre_fichero);

            out.printf("%n%nCargando jugadoras del equipo %s...", nombres_equipos[i]);

            c.importarJugadoras(ruta_datos_jugadoras, i);

            out.printf("%n%nSe han importado %d jugadoras del equipo %s del fichero %s", c.getNumeroJugadoras(i), nombres_equipos[i], nombre_fichero);
        }
    }

    private void modificarDatosJugadora() {
        String[] jugadora = new String[6];
        String nombre_jugadora_modificada;

        out.printf("%n%nHas elegido modificar datos de una jugadora");

        jugadora[0] = readString_ne("%n%nIntroduce el nombre de la jugadora (ejemplo: SILVIA DOMINGUEZ): ");

        jugadora[1] = readString_ne("%n%nIntroduce la posicion de la jugadora (ejemplo: Base): ");

        jugadora[2] = readString_ne("%n%nIntroduce el dorsal de la jugadora (ejemplo: 12): ");

        jugadora[3] = readString_ne("%n%nIntroduce la fecha de nacimiento de la jugadora (ejemplo: 12/12/1987 Mangut (Barcelona)): ");

        jugadora[4] = readString_ne("%n%nIntroduce la nacionalidad de la jugadora (ejemplo: ESPAÑA): ");

        jugadora[5] = readString_ne("%n%nIntroduce la altura de la jugadora (ejemplo: 167): ");

        nombre_jugadora_modificada = c.modificarDatosJugadora(jugadora); //la funcion devuelve un cadaena con el nombre de la jugadora en caso de exito y null en caso de error     
        if (nombre_jugadora_modificada == null) {
            out.printf("%n%nLa jugadora %s no pertenece a ningun equipo y por lo tanto no se han podido modificar sus datos", jugadora[0].toUpperCase());
        } else {
            out.printf("%n%nLa jugadora %s se ha modificado con exito", nombre_jugadora_modificada.toUpperCase());
        }
    }

    private void eliminarJugadora() {
        String nombre_jugadora, nombre_jugadora_modificada;

        out.printf("%n%nHas elegido eliminar una jugadora");

        nombre_jugadora = readString("%n%nIntroduce el nombre de la jugadora que deseas eliminar: ");

        nombre_jugadora_modificada = c.eliminarJugadora(nombre_jugadora); //la funcion devuelve un cadaena con el nombre de la jugadora en caso de exito y null en caso de error
        if (nombre_jugadora_modificada == null) {
            out.printf("%n%nLa jugadora %s no existe y por tanto no se puede eliminar", nombre_jugadora.toUpperCase());
        } else {
            out.printf("%n%nLa jugadora %s se ha eliminado con exito", nombre_jugadora_modificada.toUpperCase());
        }
    }

    private void añadirJugadora() {
        String[] jugadora = new String[6];
        String nombre_jugadora_añadida, equipo;

        out.printf("%n%nHas elegido añadir una jugadora");

        jugadora[0] = readString_ne("%n%nIntroduce el nombre de la jugadora (ejemplo: SILVIA DOMINGUEZ): ");

        jugadora[1] = readString_ne("%n%nIntroduce la posicion de la jugadora (ejemplo: Base): ");

        jugadora[2] = readString_ne("%n%nIntroduce el dorsal de la jugadora (ejemplo: 12): ");

        jugadora[3] = readString_ne("%n%nIntroduce la fecha de nacimiento de la jugadora (ejemplo: 12/12/1987 Mangut (Barcelona)): ");

        jugadora[4] = readString_ne("%n%nIntroduce la nacionalidad de la jugadora (ejemplo: ESPAÑA): ");

        jugadora[5] = readString_ne("%n%nIntroduce la altura de la jugadora (ejemplo: 167): ");

        equipo = readString("%n%nIntroduce el equipo de la jugadora introducida: ");
        equipo = equipo.replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");

        nombre_jugadora_añadida = c.añadirJugadora(jugadora, equipo); //la funcion devuelve un cadaena con el nombre de la jugadora en caso de exito y null en caso de error     
        if (nombre_jugadora_añadida == null) {
            out.printf("%n%nEl equipo %s no existe", equipo.toUpperCase());
        } else {
            out.printf("%n%nLa jugadora %s se ha añadido con exito al equipo %s", nombre_jugadora_añadida.toUpperCase(), equipo.toUpperCase());
        }
    }

    private void leerResultadosJornada() {
        int numero_jornada, valor_devuelto;
        String nombre_fichero;
        String nombre_carpeta = "LigFemBal" + File.separator + "resul_jornadas";

        out.printf("%n%nHas elegido leer los resultados de la jornada");

        numero_jornada = readInt("%n%nIntroduce el numero de la jornada a leer: ");

        nombre_fichero = c.transformarNumeroEnteroEnNumeroEnLetras(numero_jornada); //como los ficheros de las jornadas tienen numeros con letras tengo que hacer una conversion
        nombre_fichero = nombre_fichero + ".txt";

        File ruta_datos_jornada = fileToFileInFolderOnDesktop(nombre_carpeta, nombre_fichero);

        c.leerResultadosJornada(ruta_datos_jornada, numero_jornada);

    }

    private void modificarFechaJornada() {
        int jornada, valor_devuelto;
        String fecha;

        out.printf("%n%nHas elegido modificar fecha de la jornada");

        jornada = readInt("%n%nIntroduce el numero de la jornada de la cual deseas cambiar la fecha: ");

        fecha = readString("%n%nIntroduce la fecha de la jornada: ");

        valor_devuelto = c.modificarFechaJornada(jornada, fecha);

        out.printf("%n%nModificanado fecha de la jornada %d...", jornada);

        if (valor_devuelto == 0) {
            out.printf("%n%nFecha modificada con exito");
        } else {
            out.printf("%n%nLa jornada %d no existe", jornada);
        }
    }

    private void modificarFechaHoraPartido() {
        int jornada, valor_devuelto, fecha_horas;
        String nombre_equipo, fecha, hora, fecha_hora;

        out.printf("%n%nHas elegido modificar fecha u hora de un partido de una jornada");

        jornada = readInt("%n%nIntroduce el numero de la jornada de la cual deseas cambiar la fecha u hora: ");

        nombre_equipo = readString("%n%nIntroduce el nombre del equipo el cual deseas cambiar la fecha o la hora de su partido: ");

        fecha_hora = readString("%n%nIntroduce la fecha/hora del partido: ");

        fecha_horas = readInt("%n%nSi desea cambiar la fecha introduce un 0 y si deseas cambiar la hora introduce un 1: ");

        valor_devuelto = c.modificarFechaPartido(jornada, fecha_hora, nombre_equipo, fecha_horas);

        if (valor_devuelto == 0) {
            out.printf("%n%nFecha/hora modificada con exito");
        } else if (valor_devuelto == -1) {
            out.printf("%n%nLa jornada %d no existe", jornada);
        } else {
            out.printf("%n%nNo se ha podido modificar la fecha/hora del partido debido a un error en la introduccion de datos");
        }
    }

    private void mostrarResultadosJornada() throws Exception {
        int numero_jornada;
        String[][] datos_resultados_jornada;
        out.printf("%n%nHas elegido mostrar los resultados de una jornada");

        numero_jornada = readInt("%n%nIntroduce el numero de la jornada: ");

        datos_resultados_jornada = c.mostrarResultadosJornada(numero_jornada);

        if (datos_resultados_jornada != null) {
            out.printf("%n%n-------------------------------------------------------------RESULTADOS JORNADA %d---------------------------------------------------------%n%n", numero_jornada);
            printToScreen5(datos_resultados_jornada); //esta escrita al final de la vista //parecida a printToScreen3 de OpMat
        } else {
            out.printf("%n%nLa clasificacion de la jornada %d no existe", numero_jornada);
        }

    }

    private void mostrarClasificacionJornada() {
        int numero_jornada;
        String[][] clasificacion_jornada;
        out.printf("%n%nHas elegido mostrar clasificacion de una jornada");

        numero_jornada = readInt("%n%nIntroduce el numero de la jornada: ");

        clasificacion_jornada = c.mostrarClasificacionJornada(numero_jornada);

        if (clasificacion_jornada != null) {
            String[] posicion = new String[clasificacion_jornada.length];
            posicion[0] = "Puesto";
            posicion[1] = " ";

            for (int i = 2; i < clasificacion_jornada.length; i++) {
                posicion[i] = String.format("%d", i - 1);
            }

            String[][] clasificacion_jornada_completa = join(posicion, clasificacion_jornada);

            out.printf("%n%n-------------------------CLASIFICACION JORNADA %d--------------------------------%n%n", numero_jornada);
            printToScreen5(clasificacion_jornada_completa); //esta escrita al final de la vista //parecida a printToScreen3 de OpMat
        } else {
            out.printf("%n%nLa clasificacion de la jornada %d no existe", numero_jornada);
        }
    }

    private void mostrarJugadorasEquipo() {
        String [][] jugadoras_equipo;
        String equipo;
        out.printf("%n%nHas elegido mostrar jugadoras de un equipo");
        
        equipo = readString("%n%nIntroduce el nombre del equipo: ");
        equipo = equipo.replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        
        jugadoras_equipo = c.mostrarJugadorasEquipo(equipo);
        
        if (jugadoras_equipo != null) {
            out.printf("%n%n-------------------------JUGADORAS %s--------------------------------%n%n", equipo.toUpperCase());
            printToScreen5(jugadoras_equipo); //esta escrita al final de la vista //parecida a printToScreen3 de OpMat
        } else {
            out.printf("%n%nEl equipo %s no existe", equipo.toUpperCase());
        }
        
    }

    private void mostrarRelacionEquipos() {
        String[][] lista_equipos;
 
        out.printf("%n%nHas elegido mostrar relacion de equipos");
        
        lista_equipos = c.mostrarRelacionEquipos();
        
        out.printf("%n%n-------------------------EQUIPOS--------------------------------%n%n");
        printToScreen5(lista_equipos); //esta escrita al final de la vista //parecida a printToScreen3 de OpMat
    }

    private void mostrarRelacionJugadoras() {
        String[][] lista_jugadoras;
        String letra;
        
        letra = readString("%n%nIntroduce la letra inicial del nombre de las jugadoras que deseas mostrar: ");
        
        lista_jugadoras = c.mostrarRelacionJugadoras(letra);
        
        out.printf("%n%n-------------------------LISTA JUGADORAS CUYO NOMBRE EMPIEZA POR %s--------------------------------%n%n", letra.toUpperCase());
        printToScreen5(lista_jugadoras); //esta escrita al final de la vista //parecida a printToScreen3 de OpMat
    }

    private void almacenarJugadorasEquipo() throws Exception {
        String nombre_equipo;
        List<String> lista;
        out.printf("%n%nHas elegido alamcenar jugadoras de un equipo");
        
        nombre_equipo = readString("%n%nIntroduce el nombre del equipo que deseas exportar: ");
        nombre_equipo = nombre_equipo.replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        
        String nombre_fichero = nombre_equipo + ".enc";
        String nombre_carpeta = "LigFemBal" + File.separator + "fichsalida";

        Path ruta = fileToFileInFolderOnDesktop(nombre_carpeta, nombre_fichero).toPath();
                
        lista = c.almacenarJugadorasEquipo(nombre_equipo);   
          
        try {
            Files.write(ruta, lista, Charset.forName("UTF8")); //funcion para exportar informacion
        } catch (Exception Ex) {
            out.printf("%n%nSe ha producido un error al exportar porque los datos del equipo %s no existen", nombre_equipo.toUpperCase());
            return;
        }
        
        if (lista != null) {        
            out.printf("%n%nLos datos del equipo %s se han exportado con exito", nombre_equipo.toUpperCase());           
        } else {
            out.printf("%n%nEl equipo %s no existe", nombre_equipo.toUpperCase());
        }
             
    }

    private void almacenarRelacionEquipos() {
        List<String> lista;
        out.printf("%n%nHas elegido almacenar relacion de los equipos");        
        
        String nombre_fichero = "equipos.enc";
        String nombre_carpeta = "LigFemBal" + File.separator + "fichsalida";

        Path ruta = fileToFileInFolderOnDesktop(nombre_carpeta, nombre_fichero).toPath();
                
        lista = c.almacenarRelacionEquipos();   
                      
        try {
            Files.write(ruta, lista, Charset.forName("UTF8")); //funcion para exportar informacion
        } catch (Exception Ex) {
            out.printf("%n%nSe ha producido un error al exportar los datos de los equipos");
            return;
        }
        out.printf("%n%nLos datos de los equipos se han exportado con exito");
    }

    private void almacenarClasificacionJornada() {
        int jornada;
        out.printf("%n%nHas elegido almacenar la clasificacion de la jornada");
        
        jornada = readInt("%n%nIntroduce el numero de la jornada de la cual deseas exportar su clasificacion: ");
        
        String nombre_fichero = "fich_html_" + jornada + ".html";
        String nombre_carpeta = "LigFemBal" + File.separator + "fichsalida";

        Path ruta = fileToFileInFolderOnDesktop(nombre_carpeta, nombre_fichero).toPath();
        
        c.almacenarClasificacionJornada(jornada, ruta);
        
    }

    public void printToScreen5(String[][] matrix) { //similar a printToScreen3 pero con los datos justificados a la derecha y adapatado para imprimir encabezados
        int[] maxColumnWidth = new int[matrix[0].length];
        final int NUM_ROWS = matrix.length;
        final int NUM_COLUMNS = matrix[0].length;
        Arrays.fill(maxColumnWidth, 0);
        //
        // Calculate max width for each column
        //
        for (int numRow = 0; numRow < NUM_ROWS; numRow++) {
            for (int numColumn = 0; numColumn < NUM_COLUMNS; numColumn++) {
                if (matrix[numRow][numColumn].length() > maxColumnWidth[numColumn]) {
                    maxColumnWidth[numColumn] = matrix[numRow][numColumn].length();
                }
            }
        }
        //
        // Print each column with it proper width
        //
        String format;
        for (int numRow = 0; numRow < NUM_ROWS; numRow++) {
            for (int numCol = 0; numCol < NUM_COLUMNS; numCol++) {
                if (numRow == 0 || numRow == 1) {
                    format = "  %-" + maxColumnWidth[numCol] + "s ";
                    out.printf(format, matrix[numRow][numCol]);
                } else {
                    format = "| %-" + maxColumnWidth[numCol] + "s ";
                    out.printf(format, matrix[numRow][numCol]);
                }
            } // End of for each column
            if (numRow > 1) {
                out.printf("|%n");
            } else {
                out.printf("%n");
            }
        } // End of for each row
    }

    private void guardarPrograma() {
        String nombre_fichero = "binario.txt";
        String nombre_carpeta = "LigFemBal" + File.separator + "binarios";
        
        File ruta_binario = fileToFileInFolderOnDesktop(nombre_carpeta, nombre_fichero);
        
        LigaFem l = c.getLigaFem();
        try {
            FileOutputStream fos = new FileOutputStream(ruta_binario);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(l);
            oos.close();
        } catch (FileNotFoundException ex) {
            err.printf("%n%nguardar(): no se ha encontrado el archivo%n%n");
        } catch (IOException ex) {
            err.printf("%n%nguardar(): error de I/O%n%n");
        }
    }

    private void cargarPrograma() {
        String nombre_fichero = "binario.txt";
        String nombre_carpeta = "LigFemBal" + File.separator + "binarios";
        
        File ruta_binario = fileToFileInFolderOnDesktop(nombre_carpeta, nombre_fichero);
        
        LigaFem l = new LigaFem();
        
        try {
            FileInputStream fis = new FileInputStream(ruta_binario);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            l = (LigaFem) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            out.printf("%n%nNo hay datos guardados%n%n");
        } catch (IOException ex) {
            err.printf("%n%nleer(): error de I/O al leer el archivo%n%n");
        } catch (ClassNotFoundException ex) {
            err.printf("%n%nleer(): No se ha encontrado la clase%n%n");
        }
        
        c.setLigaFem(l);
    }

}
