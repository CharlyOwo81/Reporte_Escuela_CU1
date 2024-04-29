package persistencia.conexionBD;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Clase que gestiona la conexión a la base de datos MongoDB y proporciona métodos para abrir y cerrar la conexión, así como para obtener la colección de películas.
 * La clase utiliza la biblioteca oficial de MongoDB para Java.
 * Requiere una instancia de MongoDB en ejecución en localhost:27017 y una base de datos llamada "Rentas" con una colección llamada "Peliculas".
 * 
 * @author Asiel Apodaca Monge
 */
public class ConexionMongo {
    // Cadena de conexión a la instancia de MongoDB
    private static final String cadenaConexion = "mongodb://localhost:27017";
    // Nombre de la base de datos
    private static final String nombreBd = "Escuela";
    // Nombre de la colección
    private static final String nombreCol = "Reportes";
    
    // Cliente de MongoDB
    private static MongoClient mongoClient;
    // Base de datos MongoDB
    private static MongoDatabase baseDeDatos;
    // Colección MongoDB para películas
    private static MongoCollection<Document> coleccion;
    
    /**
     * Abre una conexión a la base de datos MongoDB y obtiene la colección de películas.
     */
    public static void abrirConexion() {
        mongoClient = MongoClients.create(cadenaConexion);
        baseDeDatos = mongoClient.getDatabase(nombreBd);
        coleccion = baseDeDatos.getCollection(nombreCol);
    }
    
    /**
     * Obtiene la colección de películas. Si la conexión no está abierta, la abre antes de obtener la colección.
     * 
     * @return La colección de películas.
     */
    public static MongoCollection<Document> obtenerColeccion() {
        if(coleccion == null) {
            abrirConexion();
        }
        return coleccion;
    }
    
    /**
     * Cierra la conexión al cliente de MongoDB.
     */
    public static void cerrarConexion() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
