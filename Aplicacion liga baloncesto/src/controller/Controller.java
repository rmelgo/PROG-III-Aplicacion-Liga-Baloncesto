/*
 * Raúl Melgosa Salvador 70925689Z
 * rmelgo@usal.es
 * Copyright Raul Melgosa @
 */
package controller;

import data.LigaFem;
import java.io.File;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author Melgo
 */
public class Controller {

    LigaFem l = new LigaFem();    
    
    public void setTemporada(String temporada) {
        l.setTemporada(temporada);
    }
    
    public void importarJornadas(File ruta_datos_jornadas) {
        l.importarJornadas(ruta_datos_jornadas);
    }
    
    public int getNumeroJornadas() {
        return l.getNumeroJornadas();
    }   
    
    public void importarEquipos(File ruta_datos_equipos) {
        l.importarEquipos(ruta_datos_equipos);
    }

    public int getNumeroDeEquipos() {
        return l.getNumeroDeEquipos();
    }    

    public void importarJugadoras(File ruta_datos_jugadoras, int i) {
       l.importarJugadoras(ruta_datos_jugadoras, i);
    }
    
    public String[] getNombresEquipos() {
        return l.getNombresEquipos();
    }
    
    public int getNumeroJugadoras(int i) {
        return l.getNumeroJugadoras(i);
    }    

    public String modificarDatosJugadora(String[] jugadora) {
        return l.modificarDatosJugadora(jugadora);
    }

    public String eliminarJugadora(String nombre_jugadora) {
        return l.eliminarJugadora(nombre_jugadora);
    }

    public String añadirJugadora(String[] jugadora, String equipo) {
        return l.añadirJugadora(jugadora, equipo);
    }

    public void leerResultadosJornada(File ruta_datos_jornada, int numero_jornada) {
        l.leerResultadosJornada(ruta_datos_jornada, numero_jornada);
    }

    public String transformarNumeroEnteroEnNumeroEnLetras(int numero_jornada) {
        String[] numeros = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve",
        "diez", "once", "doce", "trece", "catorce", "quince", "dieciseis", "diecisiete", "dieciocho", "diecinueve", "veinte",
        "ventiuno", "ventidos", "ventitres", "venticuatro", "venticinco", "ventiseis", "ventisiete", "ventiocho", "ventinueve", "treinta",
        "treinta y uno", "treinta y dos", "treinta y tres", "treinta y cuatro", "treinta y cinco", "treinta y seis", "treinta y siete", "treinta y ocho", "treinta y nueve", "cuarenta",
        "cuarenta y uno", "cuarenta y dos", "cuarenta y tres", "cuarenta y cuatro", "cuarenta y cinco", "cuarenta y seis", "cuarenta y siete", "cuarenta y ocho", "cuarenta y nueve", "cincuenta"};
        
        if (numero_jornada <= 0 || numero_jornada > 50) {            
            return null;
        }
        return numeros[numero_jornada];
    }

    public int modificarFechaJornada(int jornada, String fecha) {
        return l.modificarFechaJornada(jornada, fecha);
    }

    public int modificarFechaPartido(int jornada, String fecha_hora, String nombre_equipo, int fecha_horas) {
        return l.modificarFechaPartido(jornada, fecha_hora, nombre_equipo, fecha_horas);
    }

    public String[][] mostrarResultadosJornada(int numero_jornada) {
        return l.mostrarResultadosJornada(numero_jornada);
    }

    public String[][] mostrarClasificacionJornada(int numero_jornada) {
        return l.mostrarClasificacionJornada(numero_jornada);
    }

    public String[][] mostrarJugadorasEquipo(String equipo) {
        return l.mostrarJugadorasEquipo(equipo);
    }

    public String[][] mostrarRelacionEquipos() {
        return l.mostrarRelacionEquipos();
    }

    public String[][] mostrarRelacionJugadoras(String letra) {
        return l.mostrarRelacionJugadoras(letra);
    }

    public List<String> almacenarJugadorasEquipo(String nombre_equipo) throws Exception {
        return l.almacenarJugadorasEquipo(nombre_equipo);
    }

    public List<String> almacenarRelacionEquipos() {
        return l.almacenadoRelacionEquipos();
    }

    public void almacenarClasificacionJornada(int jornada, Path ruta) {
        l.almacenarClasificacionJornada(jornada, ruta);
    }
    
    public LigaFem getLigaFem() {
        return l;
    }

    public void guardarPrograma() throws Exception {
        l.guardarPrograma();
    }

    public void setLigaFem(LigaFem modelo) {
        this.l = modelo;
    }

}
