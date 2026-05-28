package com.xavier.BurguerKing.controller;

import com.xavier.BurguerKing.Service.ProdutosService;
import com.xavier.BurguerKing.dto.ProdutosDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    final ProdutosService produtosService;

    public PedidoController(ProdutosService produtosService) {
        this.produtosService = produtosService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProdutosDto>> listar(){
        List<ProdutosDto> pedido = produtosService.listPedididos();
        if (pedido.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedido);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody ProdutosDto produtosDto){
        produtosService.addProduto(produtosDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("PEDIDO CRIADO COM SUCESSO: " + produtosDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody ProdutosDto produtosDto, @PathVariable Long id){
        ProdutosDto pedido = produtosService.update(id, produtosDto);
        return ResponseEntity.ok("PEDIDO ATUALIZADO COM SUCESSO: " + pedido);
    }

    @GetMapping("/deletar/{id}")
    public ResponseEntity<Optional<ProdutosDto>> deletar(@PathVariable Long id){
        Optional<ProdutosDto> pedido = produtosService.deletar(id);
        if (pedido.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(pedido);
        }else {
            return ResponseEntity.ok(pedido);
        }
    }

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<?> findId(@PathVariable Long id){
        ProdutosDto pedido = produtosService.listByid(id);
        if (pedido != null){
            return ResponseEntity.ok(pedido);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido with id: " + id + " not found");
        }
    }

}
