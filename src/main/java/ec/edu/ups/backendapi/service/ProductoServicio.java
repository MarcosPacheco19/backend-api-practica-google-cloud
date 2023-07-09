package ec.edu.ups.backendapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.backendapi.model.Producto;
import ec.edu.ups.backendapi.repository.ProductoRepositorio;

@Service
public class ProductoServicio {
    
     @Autowired
    private ProductoRepositorio productoRepositorio;
    HashMap<String, Object> datos;

    @Autowired
    public ProductoServicio(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    public List<Producto> getProductos() {
        return this.productoRepositorio.findAll();
    }

    public ResponseEntity<Object> nuevoProducto(Producto producto) {
        datos = new HashMap<>();

        Optional<Producto> respuesta = productoRepositorio.findProductoByNombre(producto.getNombre());

        if (respuesta.isPresent()) {
            datos.put("Error", true);
            datos.put("message", "Ya existe el producto");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        productoRepositorio.save(producto);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }
}
