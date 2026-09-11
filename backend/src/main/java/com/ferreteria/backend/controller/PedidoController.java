package com.ferreteria.backend.controller;

import com.ferreteria.backend.entity.Pedido;
import com.ferreteria.backend.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> registrarPedido(@RequestBody Pedido pedido) {
        Pedido pedidoRegistrado = pedidoService.registrarPedido(pedido);
        return ResponseEntity.ok(pedidoRegistrado);
    }
}