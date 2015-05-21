package daw.ed.proyecto;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import static spark.Spark.get;
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

            get(new FreeMarkerRoute("/freemarker/team") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                return modelAndView(null, "content.ftl");
            }
        });
            
    }
}
