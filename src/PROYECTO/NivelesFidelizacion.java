/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROYECTO;

public class NivelesFidelizacion {
    private static int puntosBronce = 0;      // Puntos necesarios para nivel Bronce
    private static int puntosPlata = 500;     // Puntos necesarios para nivel Plata
    private static int puntosOro = 1000;      // Puntos necesarios para nivel Oro

    public static int getPuntosBronce() {
        return puntosBronce;
    }

    public static int getPuntosPlata() {
        return puntosPlata;
    }

    public static int getPuntosOro() {
        return puntosOro;
    }

    public static void setPuntosPlata(int puntos) {
        if (puntos > puntosBronce) {
            puntosPlata = puntos;
            System.out.println("El nivel Plata ahora requiere " + puntos + " puntos.");
        } else {
            System.out.println("El nivel Plata debe tener más puntos que Bronce.");
        }
    }

    public static void setPuntosOro(int puntos) {
        if (puntos > puntosPlata) {
            puntosOro = puntos;
            System.out.println("El nivel Oro ahora requiere " + puntos + " puntos.");
        } else {
            System.out.println("El nivel Oro debe tener más puntos que Plata.");
        }
    }

    public static String determinarNivel(int puntos) {
        if (puntos >= puntosOro) {
            return "Oro";
        } else if (puntos >= puntosPlata) {
            return "Plata";
        } else {
            return "Bronce";
        }
    }

    public static void mostrarNiveles() {
        System.out.println("\n--- Niveles de Fidelización ---");
        System.out.println("Bronce: Desde " + puntosBronce + " puntos");
        System.out.println("Plata: Desde " + puntosPlata + " puntos");
        System.out.println("Oro: Desde " + puntosOro + " puntos");
    }
}

