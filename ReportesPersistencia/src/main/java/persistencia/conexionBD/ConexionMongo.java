package persistencia.conexionBD;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import persistencia.entidades.ReporteEntity;

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
    private static MongoCollection<ReporteEntity> coleccion;
    
    /**
     * Abre una conexión a la base de datos MongoDB y obtiene la colección de películas.
     */
    public static void abrirConexion() {
        
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientSettings configuracion = MongoClientSettings.builder().applyConnectionString(new ConnectionString(cadenaConexion)).codecRegistry(pojoCodecRegistry).build();
        
        mongoClient = MongoClients.create(configuracion);
        baseDeDatos = mongoClient.getDatabase(nombreBd);
        coleccion = baseDeDatos.getCollection(nombreCol, ReporteEntity.class);
    }
    
    /**
     * Obtiene la colección de películas. Si la conexión no está abierta, la abre antes de obtener la colección.
     * 
     * @return La colección de películas.
     */
    public static MongoCollection<ReporteEntity> obtenerColeccion() {
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
