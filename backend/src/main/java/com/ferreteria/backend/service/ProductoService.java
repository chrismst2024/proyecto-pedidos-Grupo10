package com.ferreteria.backend.service;

import com.ferreteria.backend.entity.Producto;
import com.ferreteria.backend.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto registrarProducto(Producto producto) {
        return productoRepository.save(producto);
    }
}