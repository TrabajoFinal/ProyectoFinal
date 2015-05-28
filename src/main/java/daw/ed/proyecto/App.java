package daw.ed.proyecto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
public class App 
{
    public static void main( String[] args )
    {
                Spark.staticFileLocation("/public");
                final ArrayList<Team> teams = new ArrayList<>();
                
                teams.add(new Team("mi nombre","pj","pg","pe","pp","gj","gc","puntos"));
                teams.add(new Team("mi nombre2","pj","pg","pe","pp","gj","gc","puntos"));
                teams.add(new Team("mi nombre3","pj","pg","pe","pp","gj","gc","puntos"));
                teams.add(new Team("FC Barcelona","38","5","1","0","45","54","87"));
                
                final Map<String,Object> data = new HashMap<>();

            get(new FreeMarkerRoute("/") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                
                data.put("teams",teams);
                
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
                teams.add(new Team(request.queryParams("nombre"),
                        request.queryParams("pj"),
                        request.queryParams("pg"),
                        request.queryParams("pe"),
                        request.queryParams("pp"),
                        request.queryParams("gf"),
                        request.queryParams("gc"),
                        request.queryParams("puntos")
                ));
                
                response.redirect("/");
                
                return null;
            }
        });
        
        get(new FreeMarkerRoute("/delete/:team_index") {

            @Override
            public ModelAndView handle(Request rqst, Response rspns) {
                teams.remove(Integer.parseInt(rqst.params(":team_index")));
                return modelAndView(data,"read.ftl");
            }
        });
        
        get(new FreeMarkerRoute("/update/:team_index") {

            @Override
            public ModelAndView handle(Request rqst, Response rspns) {
                int id = Integer.parseInt(rqst.params(":team_index"));
                data.put("team",teams.get(id));
                data.put("team_index",id);
                return modelAndView(data,"update.ftl");
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
