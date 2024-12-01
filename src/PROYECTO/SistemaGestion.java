/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROYECTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaGestion {
    // Mapas para almacenar administradores, vendedores y productos
    private static Map<String, Administrador> admins = new HashMap<>();
    private static Map<String, Vendedor> vendedores = new HashMap<>();
    private static Map<String, Producto> productos = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Añadir un administrador por defecto
        admins.put("admin", new Administrador("admin", "admin123"));

        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Iniciar sesión como administrador");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    iniciarSesionAdmin();
                    break;
                case 2:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void iniciarSesionAdmin() {
        System.out.print("Nombre de usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        Administrador admin = admins.get(usuario);
        if (admin != null && admin.iniciarSesion(contrasena)) {
            System.out.println("Inicio de sesión exitoso como Admin.");
            mostrarMenuAdmin();
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    private static void mostrarMenuAdmin() {
        while (true) {
            System.out.println("\n--- Menú de Administrador ---");
            System.out.println("1. Gestionar administradores");
            System.out.println("2. Registrar nuevo producto");
            System.out.println("3. Añadir vendedor");
            System.out.println("4. Mostrar productos de venta");
            System.out.println("5. Registrar ventas");
            System.out.println("6. Visualizar conteo de ventas");
            System.out.println("7. Visualizar el conteo de puntos");
            System.out.println("8. Gestionar niveles de fidelización");
            System.out.println("9. Generar canje");
            System.out.println("10. Registrar pedido");
            System.out.println("11. Seleccionar producto");
            System.out.println("12. Verificar puntos");
            System.out.println("13. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    admins.get("admin").menuAdmin(vendedores, productos, admins); // Gestionar administradores
                    break;
                case 2:
                    Producto.registrarProducto(productos); // Registrar producto
                    break;
                case 3:
                    Vendedor.registrarVendedor(vendedores); // Añadir vendedor
                    break;
                case 4:
                    Producto.mostrarProductos(productos); // Mostrar productos
                    break;
                case 5:
                    RegistroVentas.registrarVenta(vendedores, productos); // Registrar ventas
                    break;
                case 6:
                    RegistroVentas.visualizarConteoVentas(vendedores); // Visualizar conteo de ventas
                    break;
                case 7:
                    RegistroVentas.visualizarPuntosVendedores(vendedores); // Visualizar conteo de puntos
                    break;
                case 8:
                    admins.get("admin").gestionarNiveles(vendedores); // Niveles de fidelización
                    break;
                case 9:
                    Canje.generarCanje(vendedores, productos); // Generar canje
                    break;
                case 10:
                    Pedido.registrarPedido(vendedores, productos); // Registrar pedido
                    break;
                case 11:
                    SeleccionProducto.seleccionarProducto(productos); // Seleccionar producto
                    break;
                case 12:
                    VerificarPuntos.verificarPuntos(vendedores); // Verificar puntos
                    break;
                case 13:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
