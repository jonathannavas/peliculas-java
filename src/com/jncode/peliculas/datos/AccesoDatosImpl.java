package com.jncode.peliculas.datos;

import com.jncode.peliculas.domain.Pelicula;
import com.jncode.peliculas.excepciones.AccesoDatosEx;
import com.jncode.peliculas.excepciones.EscrituraDatosEx;
import com.jncode.peliculas.excepciones.LecturaDatosEx;
import java.io.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan Navas
 */
public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {

        File archivo = new File(nombreRecurso);

        return archivo.exists();

    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {

        File archivo = new File(nombreRecurso);

        List<Pelicula> peliculas = new ArrayList<>();

        try {
            
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
            String linea = null;
            
            linea = entrada.readLine();
            
            while(linea!=null){
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        }

        return peliculas;

    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escritor informacion en el archivo: " + pelicula);
        } catch (IOException ex) {
            ex.getStackTrace();
            throw new EscrituraDatosEx("Excepcion al escribir peliculas: " + ex.getMessage());
        }
        
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {

        File archivo = new File(nombreRecurso);
        
        String resultado = null;
        
        try {
            
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            int indice = 1;
            while(linea!=null){
                
                if(buscar!=null && buscar.equalsIgnoreCase(linea)){
                    
                    resultado = "Pelicula encontrada: " + linea + " en las posicion: " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
                
            }
            
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.getStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar peliculas: " + ex.getMessage());
        }
        
        
        return resultado;
        
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {

        File archivo = new File(nombreRecurso);
        
        try {
            
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            
            salida.close();
            
            System.out.println("Se ha creado el archivo");
            
        } catch (IOException ex) {
            ex.getStackTrace();
            throw new AccesoDatosEx("Excepcion al crear el archivo " + ex.getMessage());
        }
        
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {

        File archivo = new File(nombreRecurso);
        
        if(archivo.exists()){
            archivo.delete();
            System.out.println("Se ha borrado el archivo");
        }
        
        
        
        
    }

}
