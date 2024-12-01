/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROYECTO;

import java.util.Map;
import java.util.Scanner;

public class VerificarPuntos {
    private static Scanner scanner = new Scanner(System.in);

    public static void verificarPuntos(Map<String, Vendedor> vendedores) {
        System.out.print("Ingrese el nombre del vendedor para verificar puntos: ");
        String nombreVendedor = scanner.nextLine();

        Vendedor vendedor = vendedores.get(nombreVendedor);
        if (vendedor != null) {
            System.out.println("Vendedor: " + vendedor.getNombre() + ", Puntos acumulados: " + vendedor.getPuntosAcumulados());
        } else {
            System.out.println("Vendedor no encontrado.");
        }
    }
}
