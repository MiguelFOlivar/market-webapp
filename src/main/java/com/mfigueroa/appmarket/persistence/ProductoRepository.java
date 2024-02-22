package com.mfigueroa.appmarket.persistence;

import com.mfigueroa.appmarket.persistence.crud.ProductoCrudRepository;
import com.mfigueroa.appmarket.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;
    public List<Producto> getAll() {
        return (List<Producto>) this.productoCrudRepository.findAll();
    }
    public List<Producto> getByCategoria(int idCategoria){
       return this.productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }
    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAAndEstado(cantidad, true);
    }
}
