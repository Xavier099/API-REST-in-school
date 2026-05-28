package com.xavier.BurguerKing.dto;

import com.xavier.BurguerKing.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutosDto {
    private Long id;
    private String nomeProduto;
    private int quantidadeProdutos;
    private List<UserModel> user;
}
