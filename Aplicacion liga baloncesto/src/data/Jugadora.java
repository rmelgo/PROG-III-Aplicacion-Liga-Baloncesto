/*
 * Raúl Melgosa Salvador 70925689Z
 * rmelgo@usal.es
 * Copyright Raul Melgosa @
 */
package data;

import java.io.Serializable;
import static java.lang.System.err;
import static java.lang.System.out;
import java.util.Locale;

/**
 *
 * @author Melgo
 */
public class Jugadora implements Serializable {

    private String nombre;
    private String posicion;
    private int dorsal;
    private String nacimiento;
    private String nacionalidad;
    private int altura;

    public Jugadora() {
        this.nombre = "DESCONOCIDO";
        this.posicion = "DESCONOCIDO";
        this.dorsal = 0;
        this.nacimiento = "DESCONOCIDO";
        this.nacionalidad = "DESCONOCIDO";
        this.altura = 0;
    }

    public static Jugadora factory(String[] tokens) {      
        tokens[2] = tokens[2].replace("-", "0");
        if (tokens.length == 6) {
            tokens[5] = tokens[5].replace("-", "0");
        }

        Jugadora ju = new Jugadora();
        try {
            ju.nombre = tokens[0];           
            ju.posicion = tokens[1];
            ju.dorsal = Integer.parseInt(tokens[2]);
            ju.nacimiento = tokens[3];
            ju.nacionalidad = tokens[4];
            if (tokens.length == 6) {
                ju.altura = Integer.parseInt(tokens[5]);
            }
        } catch (Exception Ex) {
            err.printf("%n%nFallo en el almacenamiento de los datos");
            return null;
        }
        
        return ju;
    }

    public String[] jugadoraToString() {
        String dorsal = String.format("%d", this.dorsal);
        if ("0".equals(dorsal)) { //si el campo esta vacio (es un 0), lo cambiamos por una cadena vacia a la hora de imprimir para que quede mas estetico en vez de imprimir el numero directamente
            dorsal = "";
        }
        String altura = String.format("%d", this.altura);
        if ("0".equals(altura)) { //si el campo esta vacio (es un 0), lo cambiamos por una cadena vacia a la hora de imprimir para que quede mas estetico en vez de imprimir el numero directamente
            altura = "";
        }
        
        String[] cadena = {
            this.nombre,
            this.posicion,
            dorsal,
            this.nacimiento,
            this.nacionalidad,
            altura
        };
        
        return cadena;
    }
    
    public String exportJugadoraEncolumnado() {
        String dorsal = String.format("%d", this.dorsal);
        if ("0".equals(dorsal)) { //si el campo esta vacio (es un 0), lo cambiamos por una cadena vacia a la hora de imprimir para que quede mas estetico en vez de imprimir el numero directamente
            dorsal = "";
        }
        String altura = String.format("%d", this.altura);
        if ("0".equals(altura)) { //si el campo esta vacio (es un 0), lo cambiamos por una cadena vacia a la hora de imprimir para que quede mas estetico en vez de imprimir el numero directamente
            altura = "";
        }
        String resultado;
        var actualLocale = Locale.getDefault();
        resultado = String.format(actualLocale, "%-40s%-12s%-8s%-60s%-23s%-5s", this.nombre, this.posicion, dorsal, this.nacimiento, this.nacionalidad, altura);
 
        return resultado;        
    }
   
    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getAltura() {
        return altura;
    }
    public String getAñoNacimiento() {
        return nacimiento.substring(6,10);
    }
    public String getMesNacimiento() {
        return nacimiento.substring(3,5);
    }
    public String getDiaNacimiento() {
        return nacimiento.substring(0,2);
    }   
}
