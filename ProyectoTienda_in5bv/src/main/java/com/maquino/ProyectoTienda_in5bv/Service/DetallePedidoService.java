package com.maquino.ProyectoTienda_in5bv.Service;

import com.maquino.ProyectoTienda_in5bv.Entity.DetallePedido;
import java.util.List;

public interface DetallePedidoService {
    List<DetallePedido> listar(); // Para el método listar
    void guardar(DetallePedido detalle);
    void eliminar(Integer id); // Para el método eliminar
}