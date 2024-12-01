/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROYECTO;

import java.util.Map;
import java.util.Scanner;

public class Canje {
    private static Scanner scanner = new Scanner(System.in);

    public static void generarCanje(Map<String, Vendedor> vendedores, Map<String, Producto> productos) {
        System.out.print("Ingrese el nombre del vendedor para el canje: ");
        String nombreVendedor = scanner.nextLine();
        Vendedor vendedor = vendedores.values().stream()
            .filter(v -> v.getNombre().equalsIgnoreCase(nombreVendedor))
            .findFirst()
            .orElse(null);

        if (vendedor == null) {
            System.out.println("Vendedor no encontrado.");
            return;
        }

        System.out.print("Ingrese el código del producto para canje: ");
        String codigoProducto = scanner.nextLine();
        Producto producto = productos.get(codigoProducto);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        int puntosRequeridos = (int) producto.getPrecio();
        if (vendedor.getPuntosAcumulados() >= puntosRequeridos) {
            vendedor.setPuntosAcumulados(vendedor.getPuntosAcumulados() - puntosRequeridos);
            System.out.println("Canje realizado exitosamente. Producto: " + producto.getNombre());
        } else {
            System.out.println("Puntos insuficientes para realizar el canje.");
        }
    }
}
