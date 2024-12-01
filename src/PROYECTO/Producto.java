/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROYECTO;

import java.util.Map;
import java.util.Scanner;

public class Producto {

    private String codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public static void registrarProducto(Map<String, Producto> productos) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el código único del producto: ");
        String codigo = scanner.nextLine();

        if (productos.containsKey(codigo)) {
            System.out.println("El código ya existe. Use un código único.");
            return;
        }

        System.out.print("Ingrese la marca del producto (nombre): ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cantidad (mínimo 1): ");
        int cantidad = scanner.nextInt();
        if (cantidad < 1) {
            System.out.println("La cantidad debe ser al menos 1.");
            return;
        }
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        Producto nuevoProducto = new Producto(codigo, nombre, cantidad, precio);
        productos.put(codigo, nuevoProducto);
        System.out.println("Producto registrado exitosamente.");
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public static void mostrarProductos(Map<String, Producto> productos) {
        System.out.println("--- Lista de Productos ---");
        for (Producto producto : productos.values()) {
            System.out.println(producto);
        }
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Cantidad: " + cantidad + ", Precio: " + precio;
    }
}
