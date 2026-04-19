package com.maquino.ProyectoTienda_in5bv.Service;

import com.maquino.ProyectoTienda_in5bv.Entity.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> listar();
    Producto guardar(Producto producto);
    void eliminar(Integer id);
    Producto obtenerPorId(Integer id);
}