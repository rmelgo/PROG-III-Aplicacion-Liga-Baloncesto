/*
 * Raúl Melgosa Salvador 70925689Z
 * rmelgo@usal.es
 * Copyright Raul Melgosa @
 */
package data;

import java.io.Serializable;
import static java.lang.System.err;

/**
 *
 * @author Melgo
 */
public class Partido implements Serializable {

    private String equipo_local;
    private String equipo_visitante;
    private int puntos_equipo_local;
    private int puntos_equipo_visitante;
    private String fecha;
    private String hora;

    public Partido() {
        this.equipo_local = "DESCONOCIDO";
        this.equipo_visitante = "DESCONOCIDO";
        this.puntos_equipo_local = 0;
        this.puntos_equipo_visitante = 0;
        this.fecha = "DESCONOCIDO";
        this.hora = "DESCONOCIDO";
    }

    public static Partido factory(String[] tokens) {
        if (tokens.length != 4) {
            err.printf("%n%nEl numero de campos no es correcto");
            return null;
        }

        Partido pa = new Partido();
        try {
            pa.equipo_local = tokens[0];
            pa.equipo_visitante = tokens[1];
            pa.fecha = tokens[2];
            pa.hora = tokens[3];
        } catch (Exception ex) {
            err.printf("%n%nFallo en el almacenamiento de los datos");
            return null;
        }
        
        return pa;
    }
    
    public String[] partidoToString() {
        String[] cadena = {
            this.equipo_local,
            this.equipo_visitante,
            String.format("%s", this.puntos_equipo_local),
            String.format("%s", this.puntos_equipo_visitante)
        };
        
        return cadena;
    }

    public String getEquipo_local() {
        return equipo_local;
    }

    public String getEquipo_visitante() {
        return equipo_visitante;
    }

    public void setPuntos_equipo_local(int puntos_equipo_local) {
        this.puntos_equipo_local = puntos_equipo_local;
    }

    public int getPuntos_equipo_local() {
        return puntos_equipo_local;
    }

    public int getPuntos_equipo_visitante() {
        return puntos_equipo_visitante;
    }

    public void setPuntos_equipo_visitante(int puntos_equipo_visitante) {
        this.puntos_equipo_visitante = puntos_equipo_visitante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }       
}
