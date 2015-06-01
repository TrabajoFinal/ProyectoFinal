package daw.ed.proyecto;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
                        (ObjectId) doc.get("_id"),
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
