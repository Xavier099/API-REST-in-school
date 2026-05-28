package com.xavier.BurguerKing.repository;

import com.xavier.BurguerKing.model.PedidoModel;
import com.xavier.BurguerKing.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidosRepository extends JpaRepository<PedidoModel,Long> {
    List<PedidoModel> findAllByClienteId(Long clienteId);
}
