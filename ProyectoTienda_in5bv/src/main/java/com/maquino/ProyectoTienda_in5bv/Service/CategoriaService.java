package com.maquino.ProyectoTienda_in5bv.Service;

import com.maquino.ProyectoTienda_in5bv.Entity.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> listar();
    Categoria obtenerPorId(Integer id);
    Categoria guardar(Categoria categoria);
    void eliminar(Integer id);
}