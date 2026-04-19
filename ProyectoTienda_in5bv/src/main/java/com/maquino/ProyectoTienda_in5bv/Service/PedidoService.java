package com.maquino.ProyectoTienda_in5bv.Service;
import com.maquino.ProyectoTienda_in5bv.Entity.Pedido;
import java.util.List;

public interface PedidoService {
    List<Pedido> listar();
    Pedido guardar(Pedido pedido);
    void eliminar(Integer id);
}