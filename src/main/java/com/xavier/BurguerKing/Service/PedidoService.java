package com.xavier.BurguerKing.Service;

import com.xavier.BurguerKing.dto.PedidoDto;
import com.xavier.BurguerKing.dto.mapper.PedidoMapper;
import com.xavier.BurguerKing.dto.mapper.ProdutoMapper;
import com.xavier.BurguerKing.model.PedidoModel;
import com.xavier.BurguerKing.model.ProdutosModel;
import com.xavier.BurguerKing.model.UserModel;
import com.xavier.BurguerKing.repository.PedidosRepository;
import com.xavier.BurguerKing.repository.ProdutosRepository;
import com.xavier.BurguerKing.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Getter@Setter
public class PedidoService {

    private final PedidosRepository pedidosRepository;
    private final UserRepository userRepository;
    private final ProdutosRepository produtosRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoService(PedidosRepository pedidosRepository, UserRepository userRepository, ProdutosRepository produtosRepository, PedidoMapper pedidoMapper) {
        this.pedidosRepository = pedidosRepository;
        this.userRepository = userRepository;
        this.produtosRepository = produtosRepository;
        this.pedidoMapper = pedidoMapper;
    }

    //cria o pedido
    public PedidoDto criarPedido(PedidoDto pedidoDto){
        UserModel cliente = userRepository.findById(pedidoDto.getId())
                .orElseThrow(() -> new NoSuchElementException("Usuario nao encontrado!"));

        List<ProdutosModel> produtosModels = produtosRepository.findAllById(pedidoDto.getItens());

        PedidoModel pedidos = pedidoMapper.map(pedidoDto,cliente,produtosModels);
        PedidoModel salvo = pedidosRepository.save(pedidos);

        return pedidoMapper.toDto(salvo);

    }
    //lista os pedidos por cliente
    public List<PedidoDto> listarPedidosPorCLiente(Long clienteId){
        return pedidosRepository.findAllByClienteId(clienteId)
                .stream()
                .map(pedidoMapper::toDto)
                .collect(Collectors.toList());
    }
    //busca o pedido por id
    public PedidoDto buscarPedido(Long pedidoId){
        PedidoModel pedido = pedidosRepository.findById(pedidoId)
                .orElseThrow(() -> new NoSuchElementException("Pedido nao encontrado"));
        return pedidoMapper.toDto(pedido);
    }
    //cancelar pedido
    public void cancelarPedido(Long pedidoId){
        PedidoModel pedidoModel = pedidosRepository.findById(pedidoId)
                .orElseThrow(() -> new NoSuchElementException("Pedido nao encontrado"));
        pedidosRepository.delete(pedidoModel);
    }
}
