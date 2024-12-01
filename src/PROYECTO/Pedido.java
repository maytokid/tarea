/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROYECTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pedido {

    static void registrarPedido(Map<String, Vendedor> vendedores, Map<String, Producto> productos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private Vendedor vendedor;
    private List<Producto> productos;

    public Pedido(Vendedor vendedor) {
        this.vendedor = vendedor;
        this.productos = new ArrayList<>();
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio(); // Asumiendo que `Producto` tiene un método `getPrecio()`
        }
        return total;
    }

    public void mostrarDetalles() {
        System.out.println("Pedido realizado por el vendedor: " + vendedor.getNombre()); // Asumiendo que `Vendedor` tiene un método `getNombre()`
        System.out.println("Productos en el pedido:");
        for (Producto producto : productos) {
            System.out.println("- " + producto.getNombre() + " - Precio: " + producto.getPrecio()); // Asumiendo que `Producto` tiene `getNombre()` y `getPrecio()`
        }
        System.out.println("Total del pedido: " + calcularTotal());
    }
}
