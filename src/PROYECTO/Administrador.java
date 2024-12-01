package PROYECTO;

import java.util.Map;
import java.util.Scanner;

public class Administrador {
    private String nombreUsuario;
    private String contrasena;
    private Scanner scanner = new Scanner(System.in);

    // Constructor
    public Administrador(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    // Método para iniciar sesión
    public boolean iniciarSesion(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    // Menú principal del administrador
    public void menuAdmin(Map<String, Vendedor> vendedores, Map<String, Producto> productos, Map<String, Administrador> admins) {
        while (true) {
            System.out.println("\n--- Menú Admin ---");
            System.out.println("1. Gestionar administradores");
            System.out.println("2. Registrar nuevo producto");
            System.out.println("3. Añadir vendedor");
            System.out.println("4. Mostrar productos de venta");
            System.out.println("5. Registrar ventas");
            System.out.println("6. Visualizar conteo de ventas");
            System.out.println("7. Visualizar el conteo de puntos");
            System.out.println("8. Gestionar niveles de fidelización");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    gestionarAdmins(admins);
                    break;
                case 2:
                    Producto.registrarProducto(productos);
                    break;
                case 3:
                    Vendedor.registrarVendedor(vendedores);
                    break;
                case 4:
                    Producto.mostrarProductos(productos);
                    break;
                case 5:
                    RegistroVentas.registrarVenta(vendedores, productos);
                    break;
                case 6:
                    RegistroVentas.visualizarConteoVentas(vendedores);
                    break;
                case 7:
                    RegistroVentas.visualizarPuntosVendedores(vendedores);
                    break;
                case 8:
                    gestionarNiveles(vendedores);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // Método intermediario público para gestionar niveles de fidelización
    public void gestionarNiveles(Map<String, Vendedor> vendedores) {
        gestionarNivelesFidelizacion(vendedores);
    }

    // Método privado para gestionar niveles de fidelización
    private void gestionarNivelesFidelizacion(Map<String, Vendedor> vendedores) {
        while (true) {
            NivelesFidelizacion.mostrarNiveles();

            System.out.println("\n--- Menú de Gestión de Niveles de Fidelización ---");
            System.out.println("1. Cambiar puntos requeridos para Plata");
            System.out.println("2. Cambiar puntos requeridos para Oro");
            System.out.println("3. Regresar al Menú Admin");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese los nuevos puntos requeridos para Plata: ");
                int nuevosPuntosPlata = scanner.nextInt();
                NivelesFidelizacion.setPuntosPlata(nuevosPuntosPlata);
            } else if (opcion == 2) {
                System.out.print("Ingrese los nuevos puntos requeridos para Oro: ");
                int nuevosPuntosOro = scanner.nextInt();
                NivelesFidelizacion.setPuntosOro(nuevosPuntosOro);
            } else if (opcion == 3) {
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    // Métodos para gestionar administradores
    private void gestionarAdmins(Map<String, Administrador> admins) {
        System.out.println("\n--- Gestión de Administradores ---");
        System.out.println("1. Agregar administrador");
        System.out.println("2. Eliminar administrador");
        System.out.println("3. Modificar administrador");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                agregarAdministrador(admins);
                break;
            case 2:
                eliminarAdministrador(admins);
                break;
            case 3:
                modificarAdministrador(admins);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void agregarAdministrador(Map<String, Administrador> admins) {
        System.out.print("Ingrese nombre de usuario del nuevo administrador: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese contraseña del nuevo administrador: ");
        String contrasena = scanner.nextLine();
        if (admins.containsKey(nombreUsuario)) {
            System.out.println("El administrador ya existe.");
            return;
        }
        admins.put(nombreUsuario, new Administrador(nombreUsuario, contrasena));
        System.out.println("Administrador agregado exitosamente.");
    }

    private void eliminarAdministrador(Map<String, Administrador> admins) {
        System.out.print("Ingrese nombre de usuario del administrador a eliminar: ");
        String nombreUsuario = scanner.nextLine();
        if (admins.remove(nombreUsuario) != null) {
            System.out.println("Administrador eliminado.");
        } else {
            System.out.println("Administrador no encontrado.");
        }
    }

    private void modificarAdministrador(Map<String, Administrador> admins) {
        System.out.print("Ingrese nombre de usuario del administrador a modificar: ");
        String nombreUsuario = scanner.nextLine();
        Administrador admin = admins.get(nombreUsuario);
        if (admin == null) {
            System.out.println("Administrador no encontrado.");
            return;
        }
        System.out.print("Ingrese nueva contraseña: ");
        String nuevaContrasena = scanner.nextLine();
        admin.setContrasena(nuevaContrasena);
        System.out.println("Contraseña actualizada exitosamente.");
    }

    // Método setter para actualizar la contraseña
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
