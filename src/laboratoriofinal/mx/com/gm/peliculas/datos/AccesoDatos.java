
package laboratoriofinal.mx.com.gm.peliculas.datos;

import java.util.List;
import laboratoriofinal.mx.com.gm.peliculas.domain.Pelicula;
import laboratoriofinal.mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import laboratoriofinal.mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import laboratoriofinal.mx.com.gm.peliculas.excepciones.LecturaDatosEx;


public interface AccesoDatos {
    
    public abstract boolean existe(String nombreArchivo) throws AccesoDatosEx;
    public abstract List<Pelicula> listar(String nombre)throws LecturaDatosEx;
    public abstract void escribir(Pelicula pelicula,String nombreArchivo, boolean anexar)throws EscrituraDatosEx;
    public abstract String buscar(String nombreArchivo, String buscar)throws LecturaDatosEx;
    public abstract void crear(String nombreArchivo)throws AccesoDatosEx;
    public abstract void borrar(String nombreArchivo)throws AccesoDatosEx;
}
