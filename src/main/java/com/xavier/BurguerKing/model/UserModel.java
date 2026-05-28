package com.xavier.BurguerKing.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true )
    @NonNull
    private String login;

    private String name;

    private String phone;

    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "produtos_id")
    private ProdutosModel produtos;

}
