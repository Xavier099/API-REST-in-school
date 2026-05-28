package com.xavier.BurguerKing.repository;

import com.xavier.BurguerKing.model.ProdutosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long> {
    List<ProdutosModel> findAllById(List<ProdutosModel> itens);
}
