/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;



/**
 *
 * @author rafaelm
 */
public class Mongodb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            MongoClient mongoclient = new MongoClient("localhost",27017);
            System.out.println("mongo");
            MongoDatabase dbs = mongoclient.getDatabase("xmens");
            MongoCollection<Document> collection = dbs.getCollection("xmen");
            
            //Crear un documento
            Document documento = new Document( "Nombre" , "Storm" );
            documento.append("genero", "Femenino");
            documento.append("power", "Control meteorologico");
            documento.append("Nivel", "5.0");
            
            Document documento2 = new Document( "Nombre" , "Magneto" );
            documento2.append("genero", "Masculino");
            documento2.append("power", "Control Magnetico");
            documento2.append("Nivel", "5.0");
            
            collection.insertOne(documento);
            
            //Update to the document
            /*collection.updateOne(eq("power","Control meteorologico"), 
                    new Document("$set", new Document 
        ("power","Control del clima con pinshis rayitos D:")));*/
            
            //Read documents
            for(Document doc : collection.find()){
                System.out.println(doc.toJson());
            }
            
            
            //Delete document
            //collection.deleteOne(eq("genero","Femenino"));
            
            
            

        }catch(Exception ex){
            ex.printStackTrace();
        }
        
       
    }
    
}
