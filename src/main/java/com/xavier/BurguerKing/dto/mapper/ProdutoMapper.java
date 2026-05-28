package com.xavier.BurguerKing.dto.mapper;

import com.xavier.BurguerKing.dto.ProdutosDto;
import com.xavier.BurguerKing.model.ProdutosModel;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {


        public ProdutosDto map(ProdutosModel produtos) {
            if (produtos == null) return null;
            ProdutosDto produtosDto = new ProdutosDto();
            produtosDto.setId(produtos.getId());
            produtosDto.setNomeProduto(produtos.getNomeProduto());
            produtosDto.setQuantidadeProdutos(produtos.getQuantidadeProdutos());
            produtosDto.setUser(produtos.getUser()); // Mapeia a lista de usuários

            return produtosDto;
        }

        public ProdutosModel map(ProdutosDto produtosDto) {
            if (produtosDto == null) return null;

            ProdutosModel produtos = new ProdutosModel();
            produtos.setId(produtosDto.getId());
            produtos.setNomeProduto(produtosDto.getNomeProduto());
            produtos.setQuantidadeProdutos(produtosDto.getQuantidadeProdutos());
            produtos.setUser(produtosDto.getUser()); // Mapeia a lista de usuários

            return produtos;
        }
}

