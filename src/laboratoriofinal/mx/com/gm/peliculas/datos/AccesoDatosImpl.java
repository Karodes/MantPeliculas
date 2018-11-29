
package laboratoriofinal.mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import laboratoriofinal.mx.com.gm.peliculas.domain.Pelicula;


public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        boolean result;
        if (archivo.exists()) {
            result = true;
        } else {
            result = false;
           
        }
        return result;
    }

    @Override
    public List<Pelicula> listar(String nombre) {
        //declaro un arreglo de tipo Pelicula
        List<Pelicula> pelicula=new ArrayList<>();
        
        
        File archivo = new File(nombre);
        if (archivo.exists()) {
            BufferedReader entrada = null;
            try {
                entrada = new BufferedReader(new FileReader(archivo));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            String lectura = null;
            try {
                lectura = entrada.readLine();
            } catch (IOException ex) {
                Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (lectura != null) {
                //Creo un objeto simple tipo pelicula para llenar arreglo tipo pelicula
                Pelicula peliculalec = new Pelicula(lectura);
                pelicula.add(peliculalec);
                
                try {
                    lectura = entrada.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                entrada.close();
            } catch (IOException ex) {
                Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pelicula;
   
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        File archivo = new File(nombreArchivo);
        PrintWriter salida = null;
        try {
            salida = new PrintWriter (new FileWriter(nombreArchivo,anexar));
        } catch (IOException ex) {
            Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String contenido = pelicula.getNombre();
        salida.println(contenido);
        salida.close();
        System.out.println("**********************************************");
        System.out.println("* Se ha anexado la información correctamente *");
        System.out.println("**********************************************");
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
         File archivo = new File(nombreArchivo);
        String resultado="*  Pelicula no existe   *";
        if (archivo.exists()) {
            BufferedReader entrada = null;
             try {
                 entrada = new BufferedReader(new FileReader(archivo));
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
             }
            String lectura = null;
             try {
                 lectura = entrada.readLine();
             } catch (IOException ex) {
                 Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
             }
            while (lectura != null) {
                if (lectura.equalsIgnoreCase(buscar)){
                    resultado="*  Pelicula encontrada  *";
                }
                try {
                    lectura = entrada.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             try {
                 entrada.close();
             } catch (IOException ex) {
                 Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) {
        PrintWriter salida = null;
        File archivo = new File(nombreArchivo);
        try {
            salida = new PrintWriter(new FileWriter(archivo));
        } catch (IOException ex) {
            Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("*****************************************");
        System.out.println("* El archivo se ha creado correctamente *");
        System.out.println("*****************************************");
        salida.close();
    }

    @Override
    public void borrar(String nombreArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}