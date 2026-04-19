package com.maquino.ProyectoTienda_in5bv.Controller;

import com.maquino.ProyectoTienda_in5bv.Entity.DetallePedido;
import com.maquino.ProyectoTienda_in5bv.Service.DetallePedidoService;
import com.maquino.ProyectoTienda_in5bv.Service.PedidoService;
import com.maquino.ProyectoTienda_in5bv.Service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detalles")
public class DetallePedidoViewController {

    private final DetallePedidoService detalleService;
    private final PedidoService pedidoService;
    private final ProductoService productoService;

    public DetallePedidoViewController(DetallePedidoService d, PedidoService p, ProductoService pr) {
        this.detalleService = d;
        this.pedidoService = p;
        this.productoService = pr;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaDetalles", detalleService.listar());
        model.addAttribute("listaPedidos", pedidoService.listar());
        model.addAttribute("listaProductos", productoService.listar());
        return "detalles";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute DetallePedido detalle) {
        detalleService.guardar(detalle);
        return "redirect:/detalles";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        detalleService.eliminar(id);
        return "redirect:/detalles";
    }
}