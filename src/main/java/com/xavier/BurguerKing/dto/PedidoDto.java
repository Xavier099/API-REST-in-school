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
public class PedidoDto {
    private Long id;
    private String nomePedido;
    private int quantidade;
    private List<UserModel> user;
}
