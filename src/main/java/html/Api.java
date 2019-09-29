package html;

import spark.Spark;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

// Ref: https://www.baeldung.com/spark-framework-rest-api
// Docs: http://sparkjava.com/documentation#getting-started

public class Api {
    public static void main(String[] args) {
        get("/form", (request, response) -> {
            System.out.println(">>>>>>>>>>>>>>>>>");
            return "<p>Hello world!</p>";
        });

    }
}