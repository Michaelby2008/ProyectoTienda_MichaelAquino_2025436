package com.maquino.ProyectoTienda_in5bv.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer idPedido;

    @Column(name = "fecha_pedido")
    private String fechaPedido;

    @Column(name = "total_pedido")
    private Double totalPedido;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}