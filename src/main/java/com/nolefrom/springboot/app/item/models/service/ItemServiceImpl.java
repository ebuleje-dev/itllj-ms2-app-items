package com.nolefrom.springboot.app.item.models.service;

import com.nolefrom.springboot.app.item.models.Item;
import com.nolefrom.springboot.app.item.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(
                //restTemplate.getForObject("http://localhost:8001/productos/listar", Producto[].class)//Con Ribbon comentamos URL
                restTemplate.getForObject("http://servicio-productos/productos/listar", Producto[].class)
        );

        //Por cada producto creamos new Item
        return productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());

        Producto producto = restTemplate.getForObject(
                //"http://localhost:8001/productos/ver/{id}", Producto.class,pathVariables //Con Ribbon comentamos la URL
                "http://servicio-productos/productos/ver/{id}", Producto.class,pathVariables
        );
        return new Item(producto, cantidad);
    }
}
