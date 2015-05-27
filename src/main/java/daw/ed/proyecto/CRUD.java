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
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import java.net.UnknownHostException;

/**
 *
 * @author usuario
 */
public class CRUD {
    private static MongoClient mongo;
    private static DB db;
    private static DBCollection col;
    
    public static void main(String[] args) throws UnknownHostException {
        mongo = new MongoClient("localhost",4567);
        db = mongo.getDB("equipos");
        col = db.getCollection("teams");
        
        createTeam();

    }
    public static void createTeam(){
        DBObject doc = createDBObject(Team);
        
        WriteResult result = col.insert(doc);
        System.out.println(result.getUpsertedId());
        System.out.println(result.getN());
        System.out.println(result.isUpdateOfExisting());
        System.out.println(result.getLastConcern());
    }
    
    public static void readTeam(){
        dbObject query = BasicDBObjectBuilder.start().add("nombre", )
    }
}
