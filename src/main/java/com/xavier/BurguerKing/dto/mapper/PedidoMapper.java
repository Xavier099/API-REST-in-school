package com.xavier.BurguerKing.dto.mapper;

import com.xavier.BurguerKing.dto.PedidoDto;
import com.xavier.BurguerKing.model.PedidoModel;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public PedidoDto map(PedidoModel pedidoModel){
        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setId(pedidoModel.getId());
        pedidoDto.setNomePedido(pedidoModel.getNomePedido());
        pedidoDto.setQuantidade(pedidoModel.getQuantidade());
        pedidoDto.setUser(pedidoModel.getUser());
        return pedidoDto;
    }

    public PedidoModel map(PedidoDto pedidoDto){
        PedidoModel pedidoModel = new PedidoModel();
        pedidoModel.setId(pedidoDto.getId());
        pedidoModel.setNomePedido(pedidoDto.getNomePedido());
        pedidoModel.setQuantidade(pedidoDto.getQuantidade());
        pedidoModel.setUser(pedidoDto.getUser());
        return pedidoModel;
    }
}
