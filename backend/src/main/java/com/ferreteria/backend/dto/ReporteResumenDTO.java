package com.ferreteria.backend.dto;

public class ReporteResumenDTO {
    private long totalClientes;
    private long totalProductos;
    private double valorInventario;

    public ReporteResumenDTO(long totalClientes, long totalProductos, double valorInventario) {
        this.totalClientes = totalClientes;
        this.totalProductos = totalProductos;
        this.valorInventario = valorInventario;
    }

    public long getTotalClientes() {
        return totalClientes;
    }

    public long getTotalProductos() {
        return totalProductos;
    }

    public double getValorInventario() {
        return valorInventario;
    }
}