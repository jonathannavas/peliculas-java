package com.jncode.peliculas.servicio;

/**
 *
 * @author Jonathan Navas
 */
public interface ICatalogoPeliculas {
    
    String NOMBRE_RECURSO = "peliculas.txt";
    
    void agregarPelicula(String nombrePelicula);
    
    
    
}
