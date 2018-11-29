
package laboratoriofinal.mx.com.gm.peliculas.negocio;


//Se crea la clase a partir de la interface creada



import java.util.ArrayList;
import java.util.List;
import laboratoriofinal.mx.com.gm.peliculas.datos.AccesoDatosImpl;
import laboratoriofinal.mx.com.gm.peliculas.domain.Pelicula;



public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    
    AccesoDatosImpl datos = new AccesoDatosImpl();
                
    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        //Verificar si el archivo existe
        boolean resultado=datos.existe(nombreArchivo);
        if (resultado==false){
            System.out.println("***********************************");
            System.out.println("* El catalogo no ha sido Iniciado *");
            System.out.println("*       Inicielo porfavor         *");
            System.out.println("***********************************");
        }else{
            Pelicula pelicula = new Pelicula(nombrePelicula);
          datos.escribir(pelicula, nombreArchivo, resultado);
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        List<Pelicula> pelicula=new ArrayList<>();
        pelicula=datos.listar(nombreArchivo);
        for (Pelicula peli:pelicula){
            System.out.println("Pelicula - "+ peli.getNombre());
        }
    }

    @Override
    public void buscarPelicula(String buscar, String nombreArchivo) {
        String resultado=datos.buscar(nombreArchivo, buscar);
        System.out.println("*************************");
        System.out.println(resultado);
        System.out.println("*************************");
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        //Verificar si archivo existe
        boolean resultado=datos.existe(nombreArchivo);
        if (resultado==false){
            datos.crear(nombreArchivo);
        }else{
            System.out.println("El archivo ya existe!");
        }
    }
    
}
