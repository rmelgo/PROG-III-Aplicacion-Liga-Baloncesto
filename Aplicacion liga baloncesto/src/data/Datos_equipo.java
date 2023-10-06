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
public class Datos_equipo implements Serializable {

    String nombre;
    int partidos_jugados;
    int partidos_ganados;
    int partidos_perdidos;
    int puntos_favor;
    int puntos_contra;
    int puntos_clasificacion;

    public Datos_equipo() {
        this.nombre = "DESCONOCIDO";
        this.partidos_jugados = 0;
        this.partidos_ganados = 0;
        this.partidos_perdidos = 0;
        this.puntos_favor = 0;
        this.puntos_contra = 0;
        this.puntos_clasificacion = 0;
    }

    public static Datos_equipo factory(String[] tokens) {
        if (tokens.length != 7) {
            err.printf("%n%nEl numero de campos no es correcto");
            return null;
        }

        Datos_equipo de = new Datos_equipo();
        try {
            de.nombre = tokens[0];
            de.partidos_jugados = Integer.parseInt(tokens[1]);
            de.partidos_ganados = Integer.parseInt(tokens[2]);
            de.partidos_perdidos = Integer.parseInt(tokens[3]);
            de.puntos_favor = Integer.parseInt(tokens[4]);
            de.puntos_contra = Integer.parseInt(tokens[5]);
            de.puntos_clasificacion = Integer.parseInt(tokens[6]);

        } catch (Exception Ex) {
            err.printf("%n%nFallo en el almacenamiento de los datos");
            return null;
        }

        return de;
    }

    public String[] datos_EquipoToString() {
        String[] cadena = {
            this.nombre,
            String.format("%d", this.partidos_jugados),
            String.format("%d", this.partidos_ganados),
            String.format("%d", this.partidos_perdidos),
            String.format("%d", this.puntos_favor),
            String.format("%d", this.puntos_contra),
            String.format("%d", this.puntos_clasificacion),           
        };
        
        return cadena;       
    }
    
        public String comoFilaDeUnaTablaEnHTML(int puesto) {
        String resultado;
        resultado = String.format("<TR>"
                + "<TD>%d</TD>"
                + "<TD>%s</TD>"
                + "<TD>%d</TD>"
                + "<TD>%d</TD>"
                + "<TD>%d</TD>"
                + "<TD>%d</TD>"
                + "<TD>%d</TD>"
                + "<TD>%d</TD>"
                + "</TR>",
                puesto,
                this.nombre,
                this.partidos_jugados,
                this.partidos_ganados,
                this.partidos_perdidos,
                this.puntos_favor,
                this.puntos_contra,
                this.puntos_clasificacion
        );
        return resultado;
    }

    public int getPuntos_clasificacion() {
        return puntos_clasificacion;
    }

    public int getPuntos_favor() {
        return puntos_favor;
    }

    public int getPartidos_jugados() {
        return partidos_jugados;
    }

    public int getPuntos_contra() {
        return puntos_contra;
    }
    
    public int getDiferencia_puntos() {
        return this.puntos_favor - this.puntos_contra;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPartidos_ganados() {
        return partidos_ganados;
    }

    public int getPartidos_perdidos() {
        return partidos_perdidos;
    }       
}
