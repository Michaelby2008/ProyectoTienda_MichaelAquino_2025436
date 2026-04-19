package com.maquino.ProyectoTienda_in5bv.Service;

import com.maquino.ProyectoTienda_in5bv.Entity.Producto;
import com.maquino.ProyectoTienda_in5bv.Repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository repository;

    public ProductoServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override public List<Producto> listar() { return repository.findAll(); }
    @Override public Producto guardar(Producto p) { return repository.save(p); }
    @Override public void eliminar(Integer id) { repository.deleteById(id); }
    @Override public Producto obtenerPorId(Integer id) { return repository.findById(id).orElse(null); }
}