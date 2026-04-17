package com.maquino.ProyectoTienda_in5bv.Controller;

import com.maquino.ProyectoTienda_in5bv.Entity.Usuario;
import com.maquino.ProyectoTienda_in5bv.Service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioViewController {

    private final UsuarioService usuarioService;

    public UsuarioViewController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public String viewUsuarios(Model model) {
        model.addAttribute("listaUsuarios", usuarioService.listar());
        return "usuarios";
    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        if (usuario.getIdUsuario() != null && usuario.getIdUsuario() > 0) {
            // Si el ID ya existe, intentamos actualizar
            usuarioService.actualizar(usuario.getIdUsuario(), usuario);
        } else {
            // Si el ID es nulo o 0, es un nuevo registro
            usuarioService.crear(usuario);
        }
        return "redirect:/usuarios";
    }

    @PostMapping("/usuarios/eliminar")
    public String eliminarUsuario(@RequestParam("idUsuario") Integer idUsuario) {
        usuarioService.eliminar(idUsuario);
        return "redirect:/usuarios";
    }
}