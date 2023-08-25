package com.identitye2e.recipeservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hubspot.jinjava.Jinjava;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeWebController {

    @GetMapping("/")
    @ResponseBody
    public String index() {
        try {
            return new String(Files.readAllBytes(Paths.get("src/main/resources/templates/index.html")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred while reading the index page";
        }
    }

    @GetMapping("/displayRecipes")
    @ResponseBody
    public String displayRecipes(@RequestParam String query) {
        List<RecipeResult> recipes = fetchAndRenderRecipes(query);
        return renderTemplate(recipes);
    }



    private List<RecipeResult> fetchAndRenderRecipes(String query) {
        try {
            return callTastyAPI(query);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Return an empty list in case of error
        }
    }

    private List<RecipeResult> callTastyAPI(String query) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://tasty.p.rapidapi.com/recipes/list?from=0&size=20&q=" + query)
                .get()
                .addHeader("X-RapidAPI-Key", "5d6b6ca9b0msh6f72ab9454d5861p17be82jsn10aa54bd2876")
                .addHeader("X-RapidAPI-Host", "tasty.p.rapidapi.com")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();

                ObjectMapper objectMapper = new ObjectMapper();
                RecipeListResponse listResponse = objectMapper.readValue(responseBody, RecipeListResponse.class);

                return listResponse.getResults();
            } else {
                throw new IOException("Failed to fetch data. Response code: " + response.code());
            }
        }
    }




    private String renderTemplate(List<RecipeResult> recipes) {
        Jinjava jinjava = new Jinjava();

        Map<String, Object> context = new HashMap<>();
        context.put("recipes", recipes);

        String template = "";
        try {
            template = new String(Files.readAllBytes(Paths.get("src/main/resources/templates/recipes.html")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred while reading template";
        }


        return jinjava.render(template, context);
    }


    @GetMapping("/recipeDetails")
    @ResponseBody
    public String displayRecipeDetails(@RequestParam Integer id) {
        RecipeDetail recipeDetail = fetchRecipeDetails(id);
        return renderRecipeDetailTemplate(recipeDetail);
    }

    private RecipeDetail fetchRecipeDetails(Integer id) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://tasty.p.rapidapi.com/recipes/get-more-info?id=" + id)
                .get()
                .addHeader("X-RapidAPI-Key", "5d6b6ca9b0msh6f72ab9454d5861p17be82jsn10aa54bd2876")
                .addHeader("X-RapidAPI-Host", "tasty.p.rapidapi.com")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(responseBody, RecipeDetail.class);
            } else {
                throw new IOException("Failed to fetch data. Response code: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Handle this appropriately
        }
    }


    private String renderRecipeDetailTemplate(RecipeDetail recipeDetail) {
        Jinjava jinjava = new Jinjava();

        Map<String, Object> context = new HashMap<>();
        context.put("recipe", recipeDetail);

        String template = "";
        try {

            template = new String(Files.readAllBytes(Paths.get("src/main/resources/templates/recipeDetail.html")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred while reading template";
        }
        System.out.println(jinjava.render(template, context));
        return jinjava.render(template, context);
    }




}
