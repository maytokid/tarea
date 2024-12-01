
package PROYECTO;

import java.util.Map;
import java.util.Scanner;

public class RegistroVentas {

    private static int idVentaCounter = 1; 
    private static Scanner scanner = new Scanner(System.in);

    public static void registrarVenta(Map<String, Vendedor> vendedores, Map<String, Producto> productos) {
        System.out.print("Ingrese el nombre del vendedor: ");
        String nombreVendedor = scanner.nextLine();

        Vendedor vendedor = vendedores.values().stream()
            .filter(v -> v.getNombre().equalsIgnoreCase(nombreVendedor))
            .findFirst()
            .orElse(null);

        if (vendedor == null) {
            System.out.println("Error: Nombre del vendedor no encontrado.");
            return;
        }

        System.out.print("Ingrese la marca del televisor: ");
        String marcaProducto = scanner.nextLine();

        Producto producto = productos.values().stream()
            .filter(p -> p.getNombre().equalsIgnoreCase(marcaProducto))
            .findFirst()
            .orElse(null);

        if (producto == null) {
            System.out.println("Error: Marca de televisor no encontrada.");
            return;
        }

        String idVenta = "V" + idVentaCounter++;
        vendedor.registrarVenta(producto.getPrecio());

        System.out.println("Venta registrada exitosamente con ID: " + idVenta);
    }

    public static void visualizarConteoVentas(Map<String, Vendedor> vendedores) {
        System.out.println("\n--- Conteo de Ventas por Vendedor ---");
        for (Vendedor vendedor : vendedores.values()) {
            System.out.println("Vendedor: " + vendedor.getNombre() + " (Código: " + vendedor.getCodigo() + ") - Ventas: " + vendedor.getTotalVentas());
        }
    }

    public static void visualizarPuntosVendedores(Map<String, Vendedor> vendedores) {
        System.out.println("\n--- Puntos Acumulados por Vendedor ---");
        for (Vendedor vendedor : vendedores.values()) {
            System.out.println("Vendedor: " + vendedor.getNombre() + " (Código: " + vendedor.getCodigo() + ") - Puntos: " + vendedor.getPuntosAcumulados() + ", Nivel: " + vendedor.getNivel());
        }
    }
}

