package com.ecommerce.specommerce.controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.specommerce.model.Producto;
import com.ecommerce.specommerce.model.Usuario;
import com.ecommerce.specommerce.service.ProductoService;
import com.ecommerce.specommerce.service.UpLoadFileService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UpLoadFileService upload;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }

    @GetMapping("/create")
    public String crear() {
        return "productos/create";
    }

     @GetMapping("/popup")
    public String infoAction() {
        return "/infoaction";
    }  

    @PostMapping("/save")
    public String save(Producto producto, @RequestParam("img") MultipartFile file,RedirectAttributes redirectAttributes) throws IOException {
        LOGGER.info("Este es el Obj Producto {}", producto);
        Usuario u = new Usuario(2, "", "", "", "", "", "", "");
        producto.setUsuario(u);

        // imagen
        if (producto.getId() == null) {
            String nombreImagen = upload.saveImage(file);
            producto.setImagen(nombreImagen);
        } else {

        }

       // 
        //return "redirect:/productos";
       /*  try {
            productoService.save(producto);
            redirectAttributes.addFlashAttribute("save", "guardo correctamente");
            
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("save", "no guardo bien");
        } */
        redirectAttributes.addFlashAttribute("save", "guardo correctamente");
        return "redirect:/productos/create";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();
        LOGGER.info("Producto buscado: {}", producto);
        model.addAttribute("producto", producto);
        // model.addAttribute("productos", productoService.get(null))
        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        Producto p = new Producto();
        p = productoService.get(producto.getId()).get();

        if (file.isEmpty()) { // editamos pero no cambiamos la img
           
            producto.setImagen(p.getImagen());
        } else { /* !!  cuando se edita la img */
           
            if (!p.getImagen().equals("default.jpg")) {
                upload.deleteImage(p.getImagen());
            }
            String nombreImagen = upload.saveImage(file);
            producto.setImagen(nombreImagen);
        }
        producto.setUsuario(p.getUsuario());
        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Producto p = new Producto();
        p = productoService.get(id).get();

        // eliminar cuando no sea la imagen por defecto
        if (!p.getImagen().equals("default.jpg")) {
            upload.deleteImage(p.getImagen());
        }

        productoService.delete(id);
        return "redirect:/productos";
    }

}
