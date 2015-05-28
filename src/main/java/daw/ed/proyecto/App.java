package daw.ed.proyecto;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.bson.Document;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import static spark.Spark.get;
import static spark.Spark.post;
import spark.template.freemarker.FreeMarkerRoute;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        Spark.staticFileLocation("/public");
        final ArrayList<Team> teams = new ArrayList<>();

        teams.add(new Team("FC Barcelona", "38", "30", "4", "4", "110", "21", "94"));
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
         teams.add(new Team("FC Cordoba", "38", "3", "11", "24", "22", "68", "20"));
        final Map<String, Object> data = new HashMap<>();

        get(new FreeMarkerRoute("/") {
            @Override
            public ModelAndView handle(Request request, Response response) {

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
                /*MongoClient client = new MongoClient("127.0.0.1", 53403);
                MongoDatabase database = client.getDatabase("equipos");
                MongoCollection<Document> collection = database.getCollection("insertTeam");

                collection.drop();*/

                /*Team doc = new Team(request.queryParams("nombre"),
                 request.queryParams("pj"),
                 request.queryParams("pg"),
                 request.queryParams("pe"),
                 request.queryParams("pp"),
                 request.queryParams("gf"),
                 request.queryParams("gc"),
                 request.queryParams("puntos")
                 );
                Document equipo = new Document()
                        .append("nombre", request.queryParams("nombre"))
                        .append("pj", request.queryParams("pj"))
                        .append("pg", request.queryParams("pg"))
                        .append("pe", request.queryParams("pe"))
                        .append("pp", request.queryParams("pp"))
                        .append("gf", request.queryParams("gf"))
                        .append("gc", request.queryParams("gc"))
                        .append("puntos", request.queryParams("puntos"));*/
                
                teams.add(new Team(request.queryParams("nombre"),
                 request.queryParams("pj"),
                 request.queryParams("pg"),
                 request.queryParams("pe"),
                 request.queryParams("pp"),
                 request.queryParams("gf"),
                 request.queryParams("gc"),
                 request.queryParams("puntos")
                 ));
                
                 /*for(int i=0; i<teams.size(); i++){
                 teams.add(doc);
                 }*/

                /*collection.insertOne(equipo);
                client.close();*/

                response.redirect("/");

                return null;
            }
        });

        get(new FreeMarkerRoute("/delete/:team_index") {

            @Override
            public ModelAndView handle(Request rqst, Response rspns) {
                teams.remove(Integer.parseInt(rqst.params(":team_index")));
                return modelAndView(data, "read.ftl");
            }
        });

        get(new FreeMarkerRoute("/update/:team_index") {

            @Override
            public ModelAndView handle(Request rqst, Response rspns) {
                int id = Integer.parseInt(rqst.params(":team_index"));
                data.put("team", teams.get(id));
                data.put("team_index", id);
                return modelAndView(data, "update.ftl");
            }
        });

        post(new FreeMarkerRoute("/update/:team_index") {

            @Override
            public ModelAndView handle(Request rqst, Response rspns) {
                int id = Integer.parseInt(rqst.params(":team_index"));
                teams.get(id).setNombre(rqst.queryParams("nombre"));
                teams.get(id).setPj(rqst.queryParams("pj"));
                teams.get(id).setPg(rqst.queryParams("pg"));
                teams.get(id).setPe(rqst.queryParams("pe"));
                teams.get(id).setPp(rqst.queryParams("pp"));
                teams.get(id).setGf(rqst.queryParams("gf"));
                teams.get(id).setGc(rqst.queryParams("gc"));
                teams.get(id).setPuntos(rqst.queryParams("puntos"));

                rspns.redirect("/");

                return null;
            }
        });
    }
}
