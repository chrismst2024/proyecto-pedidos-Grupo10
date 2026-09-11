package com.ferreteria.backend.repository;

import com.ferreteria.backend.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}