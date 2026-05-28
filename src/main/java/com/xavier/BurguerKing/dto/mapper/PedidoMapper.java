package com.xavier.BurguerKing.dto.mapper;

import com.xavier.BurguerKing.dto.PedidoDto;
import com.xavier.BurguerKing.model.PedidoModel;
import com.xavier.BurguerKing.model.ProdutosModel;
import com.xavier.BurguerKing.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoMapper {

    public PedidoDto toDto(PedidoModel pedido){
        PedidoDto dto = new PedidoDto();
        dto.setId(pedido.getId());
        dto.setCliente(pedido.getCliente().getId());
        dto.setItens(
                pedido.getItens().stream()
                        .map(ProdutosModel::getId)
                        .toList()
        );
        return dto;
    }

    public PedidoModel map(PedidoDto pedidoDto, UserModel cliente, List<ProdutosModel> produtosModels){
        PedidoModel pedido = new PedidoModel();
        pedido.setId(pedidoDto.getId());
        pedido.setCliente(cliente);
        pedido.setItens(produtosModels);
        return pedido;
    }
}
