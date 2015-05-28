/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.ed.proyecto;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.net.UnknownHostException;
import org.bson.Document;

/**
 *
 * @author usuario
 */
public class CRUD {
    
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("equipos");
        MongoCollection<Document> collection = database.getCollection("insertTeam");
        
        collection.drop();
        
        //createTeam();

    }
    /*public static void createTeam(){
        DBObject doc = createDBObject(Team);
        
        WriteResult result = col.insert(doc);
        System.out.println(result.getUpsertedId());
        System.out.println(result.getN());
        System.out.println(result.isUpdateOfExisting());
        System.out.println(result.getLastConcern());
    }
    
    public static void readTeam(){
        dbObject query = BasicDBObjectBuilder.start().add("nombre", )
    }*/
}
