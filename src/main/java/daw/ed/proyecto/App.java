package daw.ed.proyecto;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import static spark.Spark.get;
import spark.template.freemarker.FreeMarkerRoute;
import org.bson.Document;
import org.bson.conversions.Bson;
import spark.Route;
import static spark.Spark.post;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.*;

/**
 * LigaBBVA!
 *
 */
public class App {

    public static void main(String[] args) {

        Spark.staticFileLocation("/public");

        MongoClient cliente = new MongoClient();
        MongoDatabase bd = cliente.getDatabase("ligaBBVA");
        final MongoCollection<Document> collection = bd.getCollection("equipos");

        final ArrayList<Team> teams = new ArrayList<>();
        final Map<String, Object> data = new HashMap<>();

        /*teams.add(new Team("FC Barcelona", "38", "30", "4", "4", "110", "21", "94"));
         teams.add(new Team("Real Madrid CF", "38", "30", "2", "6", "118", "38", "92"));
         teams.add(new Team("Atletico Madrid", "38", "23", "9", "6", "67", "29", "78"));
         teams.add(new Team("Valencia CF", "38", "22", "11", "5", "70", "32", "77"));
         teams.add(new Team("Sevilla CF", "38", "23", "7", "8", "71", "45", "76"));
         teams.add(new Team("Villareal CF", "38", "16", "12", "10", "48", "37", "60"));
         teams.add(new Team("Athletic Bilbao", "38", "15", "10", "13", "42", "41", "55"));
         teams.add(new Team("RC Celta de Vigo", "38", "13", "12", "13", "47", "44", "51"));
         teams.add(new Team("Málaga CF", "38", "14", "8", "16", "42", "48", "50"));
         teams.add(new Team("RCD Espanyol", "38", "13", "10", "15", "47", "51", "49"));
         teams.add(new Team("Rayo Vallecano CF", "38", "15", "4", "19", "46", "68", "49"));
         teams.add(new Team("Real Sociedad", "38", "11", "13", "14", "44", "51", "46"));
         teams.add(new Team("Elche CF", "38", "11", "8", "19", "35", "62", "41"));
         teams.add(new Team("UD Levante", "38", "9", "10", "19", "34", "67", "37"));
         teams.add(new Team("Getafe CF", "38", "10", "7", "21", "33", "64", "37"));
         teams.add(new Team("R.C Deportivo", "38", "7", "14", "17", "35", "60", "35"));
         teams.add(new Team("Granada CF", "38", "7", "14", "17", "29", "64", "35"));
         teams.add(new Team("SD Eibar", "38", "9", "8", "21", "34", "55", "35"));
         teams.add(new Team("UD Almeria", "38", "8", "8", "22", "35", "64", "32"));
         teams.add(new Team("FC Cordoba", "38", "3", "11", "24", "22", "68", "20"));*/

        get(new FreeMarkerRoute("/") {
            @Override
            public ModelAndView handle(Request request, Response response) {

                teams.clear();

                MongoCursor<Document> cursor = collection.find().iterator();

                while (cursor.hasNext()) {
                    Document objetoequipo = cursor.next();
                    teams.add(new Team(
                            (ObjectId) objetoequipo.get("_id"),
                            objetoequipo.getString("nombre"),
                            objetoequipo.getString("pj"),
                            objetoequipo.getString("pg"),
                            objetoequipo.getString("pe"),
                            objetoequipo.getString("pp"),
                            objetoequipo.getString("gf"),
                            objetoequipo.getString("gc"),
                            objetoequipo.getString("puntos")
                    ));
                }

                cursor.close();
                data.put("teams", teams);

                return modelAndView(data, "read.ftl");
            }
        });

        get(new FreeMarkerRoute("/create") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                return modelAndView(null, "create.ftl");
            }
        });

        post(new Route("/create") {
            @Override
            public Object handle(Request request, Response response) {
                Team team = new Team();
                team.setNombre(request.queryParams("nombre"));
                team.setPj(request.queryParams("pj"));
                team.setPg(request.queryParams("pg"));
                team.setPe(request.queryParams("pe"));
                team.setPp(request.queryParams("pp"));
                team.setGf(request.queryParams("gf"));
                team.setGc(request.queryParams("gc"));
                team.setPuntos(request.queryParams("puntos"));

                Document doc = new Document();
                doc.append("nombre", team.getNombre());
                doc.append("pj", team.getPj());
                doc.append("pg", team.getPg());
                doc.append("pe", team.getPe());
                doc.append("pp", team.getPp());
                doc.append("gf", team.getGf());
                doc.append("gc", team.getGc());
                doc.append("puntos", team.getPuntos());

                collection.insertOne(doc);

                ObjectId id = (ObjectId) doc.get("_id");
                team.setId(id);

                response.redirect("/");

                return null;
            }
        });

        get(new FreeMarkerRoute("/delete/:id") {

            @Override
            public ModelAndView handle(Request rqst, Response rspns) {

                ObjectId id = new ObjectId(rqst.params(":id"));

                collection.deleteOne(eq("_id", id));

                rspns.redirect("/");
                return null;
            }
        });

        get(new FreeMarkerRoute("/update/:id") {

            @Override
            public ModelAndView handle(Request request, Response response) {
                ObjectId id = new ObjectId(request.params(":id"));

                Bson filter = eq("_id", id);
                Document doc = collection.find(filter).first();

                Team equipo = new Team(
                        (ObjectId) doc.get(id),
                        doc.getString("nombre"),
                        doc.getString("pj"),
                        doc.getString("pg"),
                        doc.getString("pe"),
                        doc.getString("pp"),
                        doc.getString("gf"),
                        doc.getString("gc"),
                        doc.getString("puntos"));

                data.put("equipo", equipo);
                return modelAndView(data, "update.ftl");
            }
        });

        post(new FreeMarkerRoute("/update/:id") {

            @Override
            public ModelAndView handle(Request request, Response response) {
                ObjectId id = new ObjectId(request.params(":id"));
                Team team = new Team();
                team.setNombre(request.queryParams("nombre"));
                team.setPj(request.queryParams("pj"));
                team.setPg(request.queryParams("pg"));
                team.setPe(request.queryParams("pe"));
                team.setPp(request.queryParams("pp"));
                team.setGf(request.queryParams("gf"));
                team.setGc(request.queryParams("gc"));
                team.setPuntos(request.queryParams("puntos"));

                collection.updateOne(eq("_id", id), new Document("$set", new Document()
                        .append("nombre", team.getNombre())
                        .append("pj", team.getPj())
                        .append("pg", team.getPg())
                        .append("pe", team.getPe())
                        .append("pp", team.getPp())
                        .append("gf", team.getGf())
                        .append("gc", team.getGc())
                        .append("puntos", team.getPuntos())
                ));

                response.redirect("/");
                return null;
            }
        });
    }
}
