package com.jncode.peliculas.presentacion;

import com.jncode.peliculas.servicio.CatalogoPeliculasImpl;
import com.jncode.peliculas.servicio.ICatalogoPeliculas;
import java.util.Scanner;

/**
 *
 * @author Jonathan Navas
 */
public class CatalogoPeliculasPresentacion {
    
    public static void main(String[] args) {
        
        int opcion = -1;
        Scanner scanner = new Scanner(System.in);
        
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        
        while(opcion != 0){
        
            System.out.println("****************************************************");
            System.out.println("********Bienvenido al Catalogo de Peliculas*********");
            System.out.println("****************************************************");
            System.out.println("Elige una opcion: \n"
                    + "1. Iniciar catalogo de peliculas \n"
                    + "2. Agregar pelicula \n"
                    + "3. Listar peliculas \n"
                    + "4. Buscar una pelicula \n"
                    + "0. Salir ");
            opcion = Integer.parseInt(scanner.nextLine());
            
            switch(opcion){
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la pelicula para registrarla");
                    String nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    System.out.println("*********************************************");
                    System.out.println("*************LISTA DE PELICULAS**************");
                    catalogo.listarPeliculas();
                    break;
                case 4: 
                    System.out.println("Ingrese el nombre de la pelicula que deseas buscar: ");
                    String buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta la vista baby");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
                    break;
            }
            
        }
        
    }
}
