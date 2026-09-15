package com.ferreteria.backend.controller;

import com.ferreteria.backend.entity.Producto;
import com.ferreteria.backend.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto) {
        Producto productoRegistrado = productoService.registrarProducto(producto);
        return ResponseEntity.ok(productoRegistrado);
    }
}