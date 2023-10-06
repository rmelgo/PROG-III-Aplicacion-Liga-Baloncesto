/*
 * Raúl Melgosa Salvador 70925689Z
 * rmelgo@usal.es
 * Copyright Raul Melgosa @
 */
package practica_final;

import view.View;

/**
 *
 * @author Melgo
 */
public class Practica_final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        View v = new View();
        v.runMenuPrincipal("%n%n1) Gestion de tempradada%n"
                + "2) Gestion de jugadoras%n"
                + "3) Gestion de jornada%n"
                + "4) Visualizacion de resultados%n"
                + "5) Almacenamiento de resultados%n"
                + "q) Salir");
    }
    
}
