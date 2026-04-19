package com.maquino.ProyectoTienda_in5bv.Service;

import com.maquino.ProyectoTienda_in5bv.Entity.DetallePedido;
import com.maquino.ProyectoTienda_in5bv.Repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    @Autowired
    private DetallePedidoRepository repository;

    @Override
    public List<DetallePedido> listar() {
        return repository.findAll();
    }

    @Override
    public void guardar(DetallePedido detalle) {
        repository.save(detalle);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}