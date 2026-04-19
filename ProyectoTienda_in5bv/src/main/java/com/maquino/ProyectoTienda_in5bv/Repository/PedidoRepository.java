package com.maquino.ProyectoTienda_in5bv.Repository;

import com.maquino.ProyectoTienda_in5bv.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}