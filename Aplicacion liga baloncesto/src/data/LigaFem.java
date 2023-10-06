/*
 * Raúl Melgosa Salvador 70925689Z
 * rmelgo@usal.es
 * Copyright Raul Melgosa @
 */
package data;

import static com.coti.tools.OpMat.*;
import static com.coti.tools.Rutas.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import static java.lang.System.err;
import static java.lang.System.out;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Melgo
 */
public class LigaFem implements Serializable {

    private String temporada;
    private List<Jornada> jornadas;
    private List<Equipo> equipos;

    public LigaFem() {
        this.temporada = "DESCONOCIDO";
        this.jornadas = new ArrayList<>();
        this.equipos = new ArrayList<>();
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public void importarJornadas(File f) {
        if (!f.exists()) {
            err.printf("%n%nError, la ruta %s no es una ruta valida", f.toString());
            return;
        }

        String[][] tmp;
        try {
            tmp = importFromDisk(f, "\\+");
        } catch (Exception Ex) {
            err.printf("%n%nFallo en la lectura de datos del fichero");
            return;
        }

        this.jornadas.clear();
        for (String[] s : tmp) {
            Jornada jo = Jornada.factory(s);
            if (jo != null) {
                this.jornadas.add(jo);
            }
        }
    }

    public int getNumeroJornadas() {
        return this.jornadas.size();
    }

    public void importarEquipos(File f) {
        if (!f.exists()) {
            err.printf("%n%nError, la ruta %s no es una ruta valida", f.toString());
            return;
        }

        String[][] tmp;
        try {
            tmp = importFromDisk(f, "#");
        } catch (Exception Ex) {
            err.printf("%n%nFallo en la lectura de datos del fichero");
            return;
        }

        this.equipos.clear();
        for (String[] s : tmp) {
            Equipo eq = Equipo.factory(s);
            if (eq != null) {
                this.equipos.add(eq);
            }
        }
    }

    public int getNumeroDeEquipos() {
        return this.equipos.size();
    }

    public void importarJugadoras(File f, int i) {
        if (!f.exists()) {
            err.printf("%n%nError, la ruta %s no es una ruta valida", f.toString());
            return;
        }

        String[][] tmp;
        try {
            tmp = importFromDisk(f, "\t");
        } catch (Exception Ex) {
            err.printf("%n%nFallo en la lectura de datos del fichero");
            return;
        }

        List<Jugadora> jugadoras_equipo = new ArrayList<>();
        for (String[] s : tmp) {
            Jugadora ju = Jugadora.factory(s);
            if (ju != null) {
                jugadoras_equipo.add(ju);
                this.equipos.get(i).setJugadoras(jugadoras_equipo);
            }
        }
    }

    public String[] getNombresEquipos() {
        String[] nombresEquipos = new String[this.equipos.size()];
        for (int i = 0; i < this.equipos.size(); i++) {
            nombresEquipos[i] = this.equipos.get(i).getNombre_equipo();
        }

        return nombresEquipos;
    }

    public int getNumeroJugadoras(int i) {
        return this.equipos.get(i).getJugadoras().size();
    }

    public String modificarDatosJugadora(String[] jugadora) {
        int bandera = 0;

        for (int i = 0; i < this.equipos.size(); i++) {
            for (int j = 0; j < this.equipos.get(i).getJugadoras().size(); j++) {
                if (this.equipos.get(i).getJugadoras().get(j).getNombre().equals(jugadora[0].toUpperCase())) {
                    Jugadora ju = Jugadora.factory(jugadora);
                    if (ju != null) { //si no se crea correctamente le ejmplar de jugadora con los datos modificados no se añade a la lista
                        this.equipos.get(i).getJugadoras().remove(j); //se eliminan los datos antiguos y despues se sustituyen por los nuevos
                        this.equipos.get(i).getJugadoras().add(j, ju);
                        bandera = 1;
                    }
                }
            }
        }

        if (bandera == 0) {
            return null;
        }
        return jugadora[0];
    }

    public String eliminarJugadora(String nombre_jugadora) {
        int bandera = 0;
        for (int i = 0; i < this.equipos.size(); i++) {
            for (int j = 0; j < this.equipos.get(i).getJugadoras().size(); j++) {
                if (this.equipos.get(i).getJugadoras().get(j).getNombre().equals(nombre_jugadora.toUpperCase())) {
                    this.equipos.get(i).getJugadoras().remove(j);
                    bandera = 1;
                }
            }
        }

        if (bandera == 0) {
            return null;
        }
        return nombre_jugadora;
    }

    public String añadirJugadora(String jugadora[], String equipo) {
        int bandera = 0;

        for (int i = 0; i < this.equipos.size(); i++) {
            if (this.equipos.get(i).getNombre_equipo().toUpperCase().equals(equipo.toUpperCase())) {
                Jugadora ju = Jugadora.factory(jugadora);
                if (ju != null) {
                    this.equipos.get(i).getJugadoras().add(ju);
                    bandera = 1;
                }
            }
        }

        if (bandera == 0) {
            return null;
        }
        return jugadora[0];
    }

    public void leerResultadosJornada(File f, int numero_jornada) {
        if (numero_jornada > this.jornadas.size() || numero_jornada <= 0) {
            err.printf("%n%nLa jornada %d no existe", numero_jornada);
            return;
        }

        if (!f.exists()) {
            err.printf("%n%nError, la ruta %s no es una ruta valida", f.toString());
            return;
        }

        String[][] tmp;
        try {
            tmp = importFromDisk(f, "\\=");
        } catch (Exception Ex) {
            err.printf("%n%nFallo en la lectura de datos del fichero");
            return;
        }

        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < this.jornadas.get(numero_jornada - 1).getPartidos().size(); j++) {
                if (this.jornadas.get(numero_jornada - 1).getPartidos().get(j).getEquipo_local().equals(tmp[i][0])) {
                    this.jornadas.get(numero_jornada - 1).getPartidos().get(j).setPuntos_equipo_local(Integer.parseInt(tmp[i][2]));
                    this.jornadas.get(numero_jornada - 1).getPartidos().get(j).setPuntos_equipo_visitante(Integer.parseInt(tmp[i][3]));
                }
            }
        }

        for (int i = 0; i < this.equipos.size(); i++) {
            String[] datos_equipos = new String[7];
            datos_equipos[0] = this.equipos.get(i).getNombre_equipo().toUpperCase();
            int bandera, pj, pg, pp, pf, pc, pts;
            bandera = pj = pg = pp = pf = pc = pts = 0;

            for (int m = 0; m < tmp.length; m++) {
                for (int n = 0; n < 2; n++) {
                    if (tmp[m][n].equals(datos_equipos[0]) && (Integer.parseInt(tmp[m][2]) != 0 && Integer.parseInt(tmp[m][3]) != 0)) { //solo se contabilizara como que el equipo jugo un partido esa jornada si la puntuacion es distinta de 0-0                   
                        bandera = 1;
                        pj = 1;

                        if (n == 0) {
                            if (Integer.parseInt(tmp[m][2]) > Integer.parseInt(tmp[m][3])) {
                                pg = 1;
                            } else if (Integer.parseInt(tmp[m][2]) < Integer.parseInt(tmp[m][3])) {
                                pp = 1;
                            }
                            pf = Integer.parseInt(tmp[m][2]);
                            pc = Integer.parseInt(tmp[m][3]);
                        }
                        if (n == 1) {
                            if (Integer.parseInt(tmp[m][2]) < Integer.parseInt(tmp[m][3])) {
                                pg = 1;
                            } else if (Integer.parseInt(tmp[m][2]) > Integer.parseInt(tmp[m][3])) {
                                pp = 1;
                            }
                            pf = Integer.parseInt(tmp[m][3]);
                            pc = Integer.parseInt(tmp[m][2]);
                        }

                        if (numero_jornada != 1 && !this.jornadas.get(numero_jornada - 2).getClasificacion().isEmpty()) {
                            for (int j = 0; j < this.jornadas.get(numero_jornada - 2).getClasificacion().size(); j++) {
                                if (this.jornadas.get(numero_jornada - 2).getClasificacion().get(j).getNombre().equals(datos_equipos[0])) {
                                    pj = pj + this.jornadas.get(numero_jornada - 2).getClasificacion().get(j).getPartidos_jugados();
                                    pg = pg + this.jornadas.get(numero_jornada - 2).getClasificacion().get(j).getPartidos_ganados();
                                    pp = pp + this.jornadas.get(numero_jornada - 2).getClasificacion().get(j).getPartidos_perdidos();
                                    pf = pf + this.jornadas.get(numero_jornada - 2).getClasificacion().get(j).getPuntos_favor();
                                    pc = pc + this.jornadas.get(numero_jornada - 2).getClasificacion().get(j).getPuntos_contra();
                                }
                            }
                        }

                        datos_equipos[1] = pj + "";
                        datos_equipos[2] = pg + "";
                        datos_equipos[3] = pp + "";
                        datos_equipos[4] = pf + "";
                        datos_equipos[5] = pc + "";
                        datos_equipos[6] = Integer.parseInt(datos_equipos[2]) * 2 + Integer.parseInt(datos_equipos[3]) + "";

                        Datos_equipo de = Datos_equipo.factory(datos_equipos);
                        if (de != null) {
                            this.jornadas.get(numero_jornada - 1).getClasificacion().add(de);
                        }
                    }
                }
            }
            if (bandera == 0) { //el equipo no jugo esa jornada pero se le añade a la clasificacion igual
                String[] cadena = {datos_equipos[0], "0", "0", "0", "0", "0", "0"};
                Datos_equipo de = Datos_equipo.factory(cadena);
                if (de != null) {
                    this.jornadas.get(numero_jornada - 1).getClasificacion().add(de);
                }
            }
        }

        Comparator<Datos_equipo> c = Comparator.comparing(Datos_equipo::getPuntos_clasificacion).thenComparing(Datos_equipo::getPartidos_jugados).thenComparing(Datos_equipo::getDiferencia_puntos);

        Collections.sort(this.jornadas.get(numero_jornada - 1).getClasificacion(), c);
        Collections.reverse(this.jornadas.get(numero_jornada - 1).getClasificacion());
    }

    public int modificarFechaJornada(int jornada, String fecha) {
        if (jornada > this.jornadas.size() || jornada <= 0) {
            return -1;
        }

        this.jornadas.get(jornada - 1).setFecha(fecha);
        return 0;
    }

    public int modificarFechaPartido(int jornada, String fecha_hora, String nombre_equipo, int fecha_horas) {
        if (jornada > this.jornadas.size() || jornada <= 0) {
            return -1;
        }

        if (fecha_horas == 0) {
            for (int i = 0; i < this.jornadas.get(jornada - 1).getPartidos().size(); i++) {
                if (this.jornadas.get(jornada - 1).getPartidos().get(i).getEquipo_local().equals(nombre_equipo.toUpperCase()) || this.jornadas.get(jornada - 1).getPartidos().get(i).getEquipo_visitante().equals(nombre_equipo.toUpperCase())) {
                    this.jornadas.get(jornada - 1).getPartidos().get(i).setFecha(fecha_hora);
                    return 0;
                }
            }
        } else if (fecha_horas == 1) {
            for (int i = 0; i < this.jornadas.get(jornada - 1).getPartidos().size(); i++) {
                if (this.jornadas.get(jornada - 1).getPartidos().get(i).getEquipo_local().equals(nombre_equipo.toUpperCase()) || this.jornadas.get(jornada - 1).getPartidos().get(i).getEquipo_visitante().equals(nombre_equipo.toUpperCase())) {
                    this.jornadas.get(jornada - 1).getPartidos().get(i).setHora(fecha_hora);
                    return 0;
                }
            }
        }

        return -2; //no se ha modificado ningun dato asi que se ha producido un error debido a un error en la introduccion de datos
    }

    public String[][] mostrarResultadosJornada(int numero_jornada) {
        String[][] tmp;
        if (this.jornadas.size() >= numero_jornada) {
            tmp = new String[this.jornadas.get(numero_jornada - 1).getPartidos().size() + 2][4]; // se suma dos para poder añadir en primer lugar el encabezado
        } else {
            return null; //si la jornada no existe se devuelve null
        }

        tmp[0][0] = "Equipo local";
        tmp[0][1] = "Equipo visitante";
        tmp[0][2] = "Puntos equipo local";
        tmp[0][3] = "Puntos equipo visitante";

        for (int i = 0; i < tmp[0].length; i++) { //se añade una fila de espacios en blanco para que sea mas estetico
            tmp[1][i] = " ";
        }

        for (int i = 0; i < this.jornadas.get(numero_jornada - 1).getPartidos().size(); i++) {
            tmp[i + 2] = this.jornadas.get(numero_jornada - 1).getPartidos().get(i).partidoToString();
        }

        return tmp;
    }

    public String[][] mostrarClasificacionJornada(int numero_jornada) {
        String[][] tmp;
        if (this.jornadas.size() >= numero_jornada) {
            tmp = new String[this.equipos.size() + 2][7]; // se suma dos para poder añadir en primer lugar el encabezado
        } else {
            return null; //si la jornada no existe se devuelve null
        }

        tmp[0][0] = "Equipo";
        tmp[0][1] = "PJ";
        tmp[0][2] = "PG";
        tmp[0][3] = "PP";
        tmp[0][4] = "PF";
        tmp[0][5] = "PC";
        tmp[0][6] = "PTS";

        for (int i = 0; i < tmp[0].length; i++) { //se añade una fila de espacios en blanco para que sea mas estetico
            tmp[1][i] = " ";
        }

        if (this.jornadas.get(numero_jornada - 1).getClasificacion().isEmpty()) { //si la clasifiacion de esa jornada no existe se devuelve null
            return null;
        }

        for (int i = 0; i < this.jornadas.get(numero_jornada - 1).getClasificacion().size(); i++) {
            tmp[i + 2] = this.jornadas.get(numero_jornada - 1).getClasificacion().get(i).datos_EquipoToString();
        }

        return tmp;
    }

    public String[][] mostrarJugadorasEquipo(String equipo) {
        int posicion = -1;
        for (int i = 0; i < this.equipos.size(); i++) {
            if (this.equipos.get(i).getNombre_equipo().toUpperCase().equals(equipo.toUpperCase())) {
                posicion = i;
            }
        }

        if (posicion == -1) { //si posicion vale -1 es por que el equipo introducido por teclado no existe
            return null;
        }

        String[][] tmp = new String[this.equipos.get(posicion).getJugadoras().size() + 2][6];

        tmp[0][0] = "Nombre";
        tmp[0][1] = "Posicion";
        tmp[0][2] = "Dorsal";
        tmp[0][3] = "Nacimiento";
        tmp[0][4] = "Nacionalidad";
        tmp[0][5] = "Altura";

        for (int i = 0; i < tmp[0].length; i++) { //se añade una fila de espacios en blanco para que sea mas estetico
            tmp[1][i] = " ";
        }

        List<Jugadora> lista_jugadoras;
        lista_jugadoras = this.equipos.get(posicion).getJugadoras();

        Comparator<Jugadora> c = Comparator.comparing(Jugadora::getPosicion).thenComparing(Jugadora::getAltura);

        Collections.sort(lista_jugadoras, c);

        for (int i = 0; i < this.equipos.get(posicion).getJugadoras().size(); i++) {
            tmp[i + 2] = this.equipos.get(posicion).getJugadoras().get(i).jugadoraToString();
        }

        return tmp;
    }

    public String[][] mostrarRelacionEquipos() {
        String[][] tmp = new String[this.equipos.size() + 2][5];

        tmp[0][0] = "Nombre equipo";
        tmp[0][1] = "Direccion";
        tmp[0][2] = "Telefono";
        tmp[0][3] = "Web";
        tmp[0][4] = "Email";

        for (int i = 0; i < tmp[0].length; i++) { //se añade una fila de espacios en blanco para que sea mas estetico
            tmp[1][i] = " ";
        }

        List<Equipo> lista_equipos;
        lista_equipos = this.equipos;

        Comparator<Equipo> c = Comparator.comparing(Equipo::getTelefono);

        Collections.sort(lista_equipos, c);

        for (int i = 0; i < this.equipos.size(); i++) {
            tmp[i + 2] = this.equipos.get(i).equipoToString();
        }

        return tmp;
    }

    public String[][] mostrarRelacionJugadoras(String letra) {
        List<Jugadora> lista_jugadoras = new ArrayList<>();
        for (int i = 0; i < this.equipos.size(); i++) {  //creamos una lista con las jugadoras cuyo nombre empiece por la letra introducida por el usuario
            for (int j = 0; j < this.equipos.get(i).getJugadoras().size(); j++) {
                if (this.equipos.get(i).getJugadoras().get(j).getNombre().startsWith(letra.toUpperCase())) {
                    lista_jugadoras.add(this.equipos.get(i).getJugadoras().get(j));
                }
            }
        }

        String[][] tmp = new String[lista_jugadoras.size() + 2][6];

        tmp[0][0] = "Nombre";
        tmp[0][1] = "Posicion";
        tmp[0][2] = "Dorsal";
        tmp[0][3] = "Nacimiento";
        tmp[0][4] = "Nacionalidad";
        tmp[0][5] = "Altura";

        for (int i = 0; i < tmp[0].length; i++) { //se añade una fila de espacios en blanco para que sea mas estetico
            tmp[1][i] = " ";
        }

        Comparator<Jugadora> c = Comparator.comparing(Jugadora::getAñoNacimiento).thenComparing(Jugadora::getMesNacimiento).thenComparing(Jugadora::getDiaNacimiento);

        Collections.sort(lista_jugadoras, c);

        for (int i = 0; i < lista_jugadoras.size(); i++) {
            tmp[i + 2] = lista_jugadoras.get(i).jugadoraToString();
        }

        return tmp;
    }

    public List<String> almacenarJugadorasEquipo(String nombre_equipo) throws Exception {
        int posicion = -1;
        for (int i = 0; i < this.equipos.size(); i++) {
            if (this.equipos.get(i).getNombre_equipo().toUpperCase().equals(nombre_equipo.toUpperCase())) {
                posicion = i;
            }
        }

        if (posicion == -1) { //si posicion vale -1 es por que el equipo introducido por teclado no existe
            return null;
        }

        List<String> lines = new ArrayList<>();
        String[] cabecera = new String[6];

        lines.add(String.format("%-40s%-12s%-8s%-60s%-23s%-5s", "Nombre", "Posicion", "Dorsal", "Nacimiento", "Nacionalidad", "Altura"));
        lines.add(String.format("%-40s%-12s%-8s%-60s%-23s%-5s", " ", " ", " ", " ", " ", " "));

        for (Jugadora ju : this.equipos.get(posicion).getJugadoras()) {
            lines.add(ju.exportJugadoraEncolumnado());
        }

        return lines;
    }

    public List<String> almacenadoRelacionEquipos() {
        List<String> lines = new ArrayList<>();
        String[] cabecera = new String[4];

        lines.add(String.format("%-40s%-12s%-50s%-50s", "Nombre equipo", "Telefono", "Web", "Email"));
        lines.add(String.format("%-40s%-12s%-50s%-50s", " ", " ", " ", " "));
        for (Equipo eq : getEquipos()) {
            lines.add(eq.exportEquipoEncolumnado());
        }
        return lines;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void almacenarClasificacionJornada(int jornada, Path ruta) {
        if (this.jornadas.size() < jornada) {
            out.printf("%n%nNo existe la jornada %d", jornada);
            return;
        }

        File f = ruta.toFile();
        try {
            PrintWriter pw = new PrintWriter(f);
            pw.printf("<!DOCTYPE hmtl>%n"
                    + "<HTML>%n"
                    + "<HEAD>%n"
                    + "<meta charset=\"UTF-8\">%n"
                    + "<H1>CLASIFICACION JORNADA %d</H1>%n"
                    + "</HEAD>%n"
                    + "<BODY>", jornada);
            pw.printf("<TABLE BORDER=1>%n");

            pw.printf("%s%n", String.format("<TR><TD>%s</TD><TD>%s</TD><TD>%s</TD><TD>%s</TD><TD>%s</TD><TD>%s</TD><TD>%s</TD><TD>%s</TD></TR>",
                    "Puesto", "Equipo", "PJ", "PG", "PP", "PF", "PC", "PTS")); //encabezado
            for (int i = 0; i < this.jornadas.get(jornada - 1).getClasificacion().size(); i++) {
                pw.printf("%s%n", this.jornadas.get(jornada - 1).getClasificacion().get(i).comoFilaDeUnaTablaEnHTML(i + 1));
            }
            pw.printf("</TABLE>%n</BODY>%n</HTML>%n");
            pw.close();
        } catch (FileNotFoundException ex) {
            err.printf("%n%nERROR: no se ha creado %s", f.toString());
            return;
        }
        out.printf("%n%nSe ha exportado la clasificacion de la jornada %d", jornada);
    }

    public void guardarPrograma() throws Exception {
        String nombre_fichero = "binario.bin";
        String nombre_carpeta = "LigFemBal" + File.separator + "binarios";

        File ruta_binario = fileToFileInFolderOnDesktop(nombre_carpeta, nombre_fichero);
        Path binaryPath = Paths.get("archivobinario.bin");

        try {
            FileOutputStream fos = new FileOutputStream(ruta_binario);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(equipos);
            oos.close();
        } catch (FileNotFoundException ex) {
            err.printf("%n%nguardar(): no se ha encontrado el archivo%n%n");
        }
    }
}
