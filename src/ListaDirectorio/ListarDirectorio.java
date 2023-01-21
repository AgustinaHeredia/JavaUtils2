package ListaDirectorio;
import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class ListarDirectorio {

    public static void main(String[] args) {

        File directorio = new File("/Users/agustinaheredia/Documents");
        listarDirectorio(directorio);
    }

    public static void listarDirectorio(File directorio) {

        // Obtenemos el listado de archivos y directorios dentro del directorio
        File[] contenido = directorio.listFiles();

        // Ordenamos el listado alfabeticamente
        Arrays.sort(contenido);

        for (File archivo : contenido) {
            // Si es un directorio, llamamos recursivamente al método
            if (archivo.isDirectory()) {
                System.out.println("Directorio - " + archivo.getName() + " - " + new Date(archivo.lastModified()));
                listarDirectorio(archivo);
            } else {
                // Si es un archivo, imprimimos su nombre y última fecha de modificación
                System.out.println("Archivo - " + archivo.getName() + " - " + new Date(archivo.lastModified()));
            }
        }
    }
}
