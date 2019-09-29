package htmlsccjs;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import static spark.Spark.get;
import static spark.Spark.post;

public class Api {
    public static void main(String[] args) {
        // 1. Return HTML from file
        get("/form", (request, response) -> {
            System.out.println("We reached the form!");

            // Reference to the HTML file containing the form
            String htmlFile = "target\\classes\\html\\html\\ex1_forms\\index.html";

            // Converting the contents of the file
            String htmlContent = new String(Files.readAllBytes(Paths.get(htmlFile)), StandardCharsets.UTF_8);

            // System.out.println(htmlContent);
            return htmlContent;
        });
        post("/submit-form", (request, response) -> {
            // // 0. Obtaining the input
            // System.out.println(request.body());
            // System.out.println(URLDecoder.decode(request.body(), "UTF-8"));
            // return "<h4>Success</h4>";

            // // 1. Processing the user input
            // String[] userinfo = request.body().split("&");
            // for (String pieceOfInfo: userinfo) {
            //     System.out.println(pieceOfInfo);
            // }
            // return "<h4>Success</h4>";

            // 2. Return data as html <UL>
            // <ul>
            //     <li>First element</li>
            //     <li>Second element</li>
            // </ul>
            String[] userinfo = request.body().split("&");
            String ulopen = "<ul>";
            String ulclose = "</ul>";
            for (String pieceOfInfo: userinfo) {
                ulopen += "<li>" + pieceOfInfo.split("=")[1] + "</li>";
            }
            return ulopen + ulclose;
        });

    }
}