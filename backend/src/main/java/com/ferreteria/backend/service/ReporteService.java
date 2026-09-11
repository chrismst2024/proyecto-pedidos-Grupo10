package com.ferreteria.backend.service;

import com.ferreteria.backend.dto.RankingItemDTO;
import com.ferreteria.backend.dto.ReporteResumenDTO;
import com.ferreteria.backend.entity.Producto;
import com.ferreteria.backend.repository.ClienteRepository;
import com.ferreteria.backend.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReporteService {
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;

    public ReporteService(ClienteRepository clienteRepository, ProductoRepository productoRepository) {
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
    }

    public ReporteResumenDTO generarResumen() {
        long totalClientes = clienteRepository.count();
        List<Producto> productos = productoRepository.findAll();
        long totalProductos = productos.size();
        double valorInventario = productos.stream()
                .filter(p -> p.getPrecio() != null && p.getStock() != null)
                .mapToDouble(p -> p.getPrecio() * p.getStock())
                .sum();
        return new ReporteResumenDTO(totalClientes, totalProductos, valorInventario);
    }

    public List<RankingItemDTO> productosPorCategoria() {
        Map<String, Long> conteo = productoRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        p -> p.getCategoria() != null ? p.getCategoria() : "Sin categoria",
                        Collectors.counting()));

        return conteo.entrySet().stream()
                .map(e -> new RankingItemDTO(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }
}