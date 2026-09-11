package com.ferreteria.backend.dto;

public class RankingItemDTO {
    private String nombre;
    private long valor;

    public RankingItemDTO(String nombre, long valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public long getValor() {
        return valor;
    }
}
