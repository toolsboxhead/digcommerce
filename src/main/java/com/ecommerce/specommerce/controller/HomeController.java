package com.ecommerce.specommerce.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.specommerce.domain.model.Producto;
import com.ecommerce.specommerce.service.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {
    
    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String home(Model model){
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);

        return "usuario/home";
    }

    @GetMapping("productohome/{id}")
    public String productohome(@PathVariable Integer id, Model model){
        log.info("Id producto enviado como param {}", id);
        Producto producto = new Producto();
        Optional<Producto> productoOptional  = productoService.get(id);
        producto = productoOptional.get();

        model.addAttribute("producto", producto);
        
        return "usuario/productohome";
    }

}
