package com.maquino.ProyectoTienda_in5bv.Controller;

import com.maquino.ProyectoTienda_in5bv.Entity.Producto;
import com.maquino.ProyectoTienda_in5bv.Service.ProductoService;
import com.maquino.ProyectoTienda_in5bv.Service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoViewController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public ProductoViewController(ProductoService productoService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaProductos", productoService.listar());
        model.addAttribute("listaCategorias", categoriaService.listar());
        return "productos";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto) {
        productoService.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        productoService.eliminar(id);
        return "redirect:/productos";
    }
}