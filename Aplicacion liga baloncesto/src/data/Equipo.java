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
import java.util.Locale;

/**
 *
 * @author Melgo
 */
public class Equipo implements Serializable {
    
    private String nombre_equipo;
    private String direccion;
    private int telefono;
    private String web;
    private String email;
    private List<Jugadora> jugadoras;
    
    public Equipo() {
        this.nombre_equipo = "DESCONOCIDO";
        this.direccion = "DESCONOCIDO";
        this.telefono = 0;
        this.web = "DESCONOCIDO";
        this.email = "DESCONOCIDO";
        this.jugadoras = new ArrayList<>();
    }
    
    public static Equipo factory(String[] tokens) {
        if (tokens.length != 5) {
            err.printf("%n%nEl numero de campos no es correcto");
            return null;
        }
        
        tokens[0] = tokens[0].replace("á", "a");
        tokens[0] = tokens[0].replace("é", "i");
        tokens[0] = tokens[0].replace("í", "i");
        tokens[0] = tokens[0].replace("ó", "o");
        tokens[0] = tokens[0].replace("ú", "u");
        Equipo eq = new Equipo();
        try {
            eq.nombre_equipo = tokens[0];
            eq.direccion = tokens[1];
            eq.telefono = Integer.parseInt(tokens[2]);
            eq.web = tokens[3];
            eq.email = tokens[4];
        } catch (Exception Ex) {
            err.printf("%n%nFallo en el almacenamiento de los datos");
            return null;
        }
        
        return eq;
    }
    
    public String[] equipoToString() {
        String[] cadena = {
            this.nombre_equipo,
            this.direccion,
            String.format("%d", this.telefono),
            this.web,
            this.email
        };
        
        return cadena;
    }
    
    public String exportEquipoEncolumnado() {
        String resultado;
        var actualLocale = Locale.getDefault();
        resultado = String.format(actualLocale, "%-40s%-12d%-50s%-50s", this.nombre_equipo, this.telefono, this.web, this.email);
 
        return resultado;        
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setJugadoras(List<Jugadora> jugadoras) {
        this.jugadoras = jugadoras;
    }

    public List<Jugadora> getJugadoras() {
        return jugadoras;
    }

    public int getTelefono() {
        return telefono;
    }          
}
