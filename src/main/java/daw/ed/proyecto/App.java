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
                
                final Map<String,Object> data = new HashMap<>();

            get(new FreeMarkerRoute("/freemarker/team") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                
                data.put("teams",teams);
                
                return modelAndView(data, "content.ftl");
            }
        });
           
        get(new FreeMarkerRoute("/freemarker/team/create") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                return modelAndView(null, "content2.ftl");
            }
        });
        
        
        post(new Route("/freemarker/team/create") {
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
                
                response.redirect("/freemarker/team");
                
                return null;
            }
        });
    }
}
