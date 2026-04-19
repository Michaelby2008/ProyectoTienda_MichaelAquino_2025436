package com.maquino.ProyectoTienda_in5bv.Service;
import com.maquino.ProyectoTienda_in5bv.Entity.Pedido;
import com.maquino.ProyectoTienda_in5bv.Repository.PedidoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository repository;
    public PedidoServiceImpl(PedidoRepository repository) { this.repository = repository; }
    @Override public List<Pedido> listar() { return repository.findAll(); }
    @Override public Pedido guardar(Pedido p) { return repository.save(p); }
    @Override public void eliminar(Integer id) { repository.deleteById(id); }
}