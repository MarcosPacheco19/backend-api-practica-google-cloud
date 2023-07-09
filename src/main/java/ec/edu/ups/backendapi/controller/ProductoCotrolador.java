package ec.edu.ups.backendapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.backendapi.model.Producto;
import ec.edu.ups.backendapi.service.ProductoServicio;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="productos")
public class ProductoCotrolador {
    
    private final ProductoServicio productoServicio;

    @Autowired
    public ProductoCotrolador(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping(path = "listar")
    public List<Producto> getProductos() {
        return this.productoServicio.getProductos();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarProducto(@RequestBody Producto producto) {
        return this.productoServicio.nuevoProducto(producto);
    }
}
