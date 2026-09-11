package com.ferreteria.backend.service;

import com.ferreteria.backend.entity.Pedido;
import com.ferreteria.backend.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido registrarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}