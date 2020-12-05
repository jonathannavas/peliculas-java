package com.jncode.peliculas.datos;

import com.jncode.peliculas.domain.Pelicula;
import com.jncode.peliculas.excepciones.AccesoDatosEx;
import com.jncode.peliculas.excepciones.EscrituraDatosEx;
import com.jncode.peliculas.excepciones.LecturaDatosEx;
import java.util.List;

/**
 *
 * @author Jonathan Navas
 */
public interface IAccesoDatos {
    
    public abstract boolean existe(String nombreRecurso) throws AccesoDatosEx;
    
    public abstract List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;
    
    public abstract void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;
    
    public abstract String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;
    
    public abstract void crear(String nombreRecurso) throws AccesoDatosEx;
    
    public abstract void borrar(String nombreRecurso) throws AccesoDatosEx;
    
}
