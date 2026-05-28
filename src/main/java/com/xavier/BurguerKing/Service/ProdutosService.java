package com.xavier.BurguerKing.Service;
import com.xavier.BurguerKing.dto.ProdutosDto;
import com.xavier.BurguerKing.dto.mapper.ProdutoMapper;
import com.xavier.BurguerKing.model.ProdutosModel;
import com.xavier.BurguerKing.repository.ProdutosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutosService {

    final ProdutoMapper produtoMapper;
    final ProdutosRepository produtosRepository;

    public ProdutosService(ProdutoMapper produtoMapper, ProdutosRepository produtosRepository) {
        this.produtoMapper = produtoMapper;
        this.produtosRepository = produtosRepository;
    }

    //add produtos
    public ProdutosDto addProduto(ProdutosDto pedidoDto){
        ProdutosModel produtosModel = produtoMapper.map(pedidoDto);
        produtosModel = produtosRepository.save(produtosModel);
        return produtoMapper.map(produtosModel);
    }

    //list all
    public List<ProdutosDto> listPedididos(){
        List<ProdutosModel> produtosModels = produtosRepository.findAll();
        return produtosModels.stream()
                .map(produtoMapper::map)
                .collect(Collectors.toList());
    }

    //list by id
    public ProdutosDto listByid(Long id){
        ProdutosModel pedido = produtosRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pedido not found"));
        return produtoMapper.map(pedido);
    }

    public Optional<ProdutosDto> deletar(Long id){
        return produtosRepository.findById(id)
                .map(pedido -> {ProdutosDto dto = produtoMapper.map(pedido);
                produtosRepository.deleteById(id);
                return dto;});
    }

    @Transactional
    public ProdutosDto update(Long id, ProdutosDto produtosDto){
        ProdutosModel produtosModel = produtosRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pedido not found"));

        produtosModel.setNomeProduto(produtosDto.getNomeProduto());
        produtosModel.setUser(produtosDto.getUser());
        return produtoMapper.map(produtosRepository.save(produtosModel));
    }
}
