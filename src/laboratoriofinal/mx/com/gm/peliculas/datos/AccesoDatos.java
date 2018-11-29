
package laboratoriofinal.mx.com.gm.peliculas.datos;

import java.util.List;
import laboratoriofinal.mx.com.gm.peliculas.domain.Pelicula;
import laboratoriofinal.mx.com.gm.peliculas.excepciones.AccesoDatosEx;


public interface AccesoDatos {
    
    public abstract boolean existe(String nombreArchivo) throws AccesoDatosEx;
    public abstract List<Pelicula> listar(String nombre);
    public abstract void escribir(Pelicula pelicula,String nombreArchivo, boolean anexar);
    public abstract String buscar(String nombreArchivo, String buscar);
    public abstract void crear(String nombreArchivo);
    public abstract void borrar(String nombreArchivo);
}
