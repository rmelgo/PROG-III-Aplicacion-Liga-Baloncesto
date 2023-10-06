/*
 * Raúl Melgosa Salvador 70925689Z
 * rmelgo@usal.es
 * Copyright Raul Melgosa @
 */
package data;

import java.io.Serializable;
import static java.lang.System.err;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Melgo
 */
public class Jornada implements Serializable {

    private int numero_jornada;
    private String fecha;
    private List<Partido> partidos;
    private List<Datos_equipo> clasificacion;
    private int num_partidos = 8;

    public Jornada() {
        this.numero_jornada = 0;
        this.fecha = "DESCONOCIDO";
        this.partidos = new ArrayList<>();
        this.clasificacion = new ArrayList<>();
    }

    public static Jornada factory(String[] tokens) {
        if (tokens.length != 3) {
            err.printf("%n%nEl numero de campos no es correcto");
            return null;
        }
        
        Jornada jo = new Jornada();

        String[] tmp;
        tmp = tokens[2].split("#");
        
        for (int i = 0; i < tmp.length; i++) {
            Partido pa = Partido.factory(tmp[i].split("\\$"));        
            if (pa != null) {
                jo.partidos.add(pa);
            }
        }
        
        try {
            jo.numero_jornada = Integer.parseInt(tokens[0]);
            jo.fecha = tokens[1];
        } catch (Exception Ex) {
            err.printf("%n%nFallo en el almacenamiento de los datos");
            return null;
        }
        
        return jo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public List<Datos_equipo> getClasificacion() {
        return clasificacion;
    }    
}
