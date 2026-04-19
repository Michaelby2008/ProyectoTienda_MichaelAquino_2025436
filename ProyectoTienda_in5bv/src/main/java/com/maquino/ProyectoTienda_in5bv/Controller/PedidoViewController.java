package com.maquino.ProyectoTienda_in5bv.Controller;
import com.maquino.ProyectoTienda_in5bv.Entity.Pedido;
import com.maquino.ProyectoTienda_in5bv.Service.PedidoService;
import com.maquino.ProyectoTienda_in5bv.Service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidos")
public class PedidoViewController {
    private final PedidoService pedidoService;
    private final UsuarioService usuarioService;

    public PedidoViewController(PedidoService pedidoService, UsuarioService usuarioService) {
        this.pedidoService = pedidoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaPedidos", pedidoService.listar());
        model.addAttribute("listaUsuarios", usuarioService.listar());
        return "pedidos";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Pedido pedido) {
        pedidoService.guardar(pedido);
        return "redirect:/pedidos";
    }
}