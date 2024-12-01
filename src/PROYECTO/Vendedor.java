package PROYECTO;

import java.util.Map;

public class Vendedor {

    static void registrarVendedor(Map<String, Vendedor> vendedores) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private String codigo;
    private String nombre;
    private int puntosAcumulados;
    private int totalVentas;
    private String nivel;

    public Vendedor(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.puntosAcumulados = 0;
        this.totalVentas = 0;
        this.nivel = "Bronce";
    }

    public void registrarVenta(double precio) {
        int puntos = (int) (precio / 10); 
        puntosAcumulados += puntos;
        totalVentas++;

        if (totalVentas % 10 == 0) {
            puntosAcumulados += 200;
            System.out.println("¡Bono de 200 puntos añadido!");
        }

        actualizarNivel();
    }

    public void actualizarNivel() {
        nivel = NivelesFidelizacion.determinarNivel(puntosAcumulados);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public int getTotalVentas() {
        return totalVentas;
    }

    public String getNivel() {
        return nivel;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Ventas: " + totalVentas + ", Puntos: " + puntosAcumulados + ", Nivel: " + nivel;
    }
}



