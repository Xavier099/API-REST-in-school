package com.xavier.BurguerKing.dto;

import com.xavier.BurguerKing.model.PedidoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class UserDto {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private PedidoModel pedido;
}
