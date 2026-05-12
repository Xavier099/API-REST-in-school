package com.xavier.BurguerKing.repository;

import com.xavier.BurguerKing.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
