/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROYECTO;

import java.util.Map;
import java.util.Scanner;

public class SeleccionProducto {
    private static Scanner scanner = new Scanner(System.in);

    public static void seleccionarProducto(Map<String, Producto> productos) {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombreProducto = scanner.nextLine();

        boolean encontrado = false;
        for (Producto producto : productos.values()) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                System.out.println(producto);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron productos con ese nombre.");
        }
    }
}
