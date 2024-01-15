package com.nolefrom.springboot.app.item.clientes;

import com.nolefrom.springboot.app.item.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@FeignClient(name = "servicio-productos", url = "http://localhost:8001") //Ribbon desacopla la URL en app.properties
@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {

    @GetMapping("/productos/listar")
    public List<Producto> listar();

    @GetMapping("/productos/ver/{id}")
    public Producto detalle(@PathVariable Long id);
}
