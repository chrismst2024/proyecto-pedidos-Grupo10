package com.ferreteria.backend.controller;

import com.ferreteria.backend.entity.Cliente;
import com.ferreteria.backend.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente) {
        Cliente clienteRegistrado = clienteService.registrarCliente(cliente);
        return ResponseEntity.ok(clienteRegistrado);
    }
}