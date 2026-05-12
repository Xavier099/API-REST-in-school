package com.xavier.BurguerKing.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_pedido")
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomePedido;

    private int quantidade;

    @OneToMany
    @JsonIgnore
    private List<UserModel> user;
}
