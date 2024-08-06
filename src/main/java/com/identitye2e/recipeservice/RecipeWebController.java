package com.identitye2e.recipeservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hubspot.jinjava.Jinjava;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeWebController.class);
    public static final String ERROR_MSG = "Error occurred";

    @Autowired
    FileService fileService;

    protected OkHttpClient getHttpClient() {
        return new OkHttpClient();
    }





    @GetMapping("/")
    @ResponseBody
    public String index() {
        try {
            return fileService.readFileContent("src/main/resources/templates/index.html");
        } catch (IOException e) {
            LOGGER.error(ERROR_MSG, e);
            return ERROR_MSG;
        }
    }

    @GetMapping("/displayRecipes")
    @ResponseBody
    public String displayRecipes(@RequestParam String query) {
        List<RecipeResult> recipes = fetchAndRenderRecipes(query);
        return renderTemplate(recipes);
    }



    List<RecipeResult> fetchAndRenderRecipes(String query) {
        try {
            return callTastyAPI(query);
        } catch (Exception e) {
            LOGGER.error(ERROR_MSG, e);
            return new ArrayList<>();
        }
    }

    private List<RecipeResult> callTastyAPI(String query) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://tasty.p.rapidapi.com/recipes/list?from=0&size=20&q=" + query)
                .get()
                .addHeader("X-RapidAPI-Key", System.getenv("X_RAPIDAPI_KEY"))
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




    String renderTemplate(List<RecipeResult> recipes) {
        Jinjava jinjava = new Jinjava();

        Map<String, Object> context = new HashMap<>();
        context.put("recipes", recipes);

        String template = "";
        try {
            template = fileService.readFileContent("src/main/resources/templates/recipes.html");
        } catch (IOException e) {
            LOGGER.error(ERROR_MSG, e);
            return ERROR_MSG;
        }


        return jinjava.render(template, context);
    }


    @GetMapping("/recipeDetails")
    @ResponseBody
    public String displayRecipeDetails(@RequestParam Integer id) {
        Root recipeDetail = fetchRecipeDetails(id);
        return renderRecipeDetailTemplate(recipeDetail);
    }

    Root fetchRecipeDetails(Integer id) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://tasty.p.rapidapi.com/recipes/get-more-info?id=" + id)
                .get()
                .addHeader("X-RapidAPI-Key", System.getenv("X_RAPIDAPI_KEY"))
                .addHeader("X-RapidAPI-Host", "tasty.p.rapidapi.com")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(responseBody, Root.class);
            } else {
                throw new IOException("Failed to fetch data. Response code: " + response.code());
            }
        } catch (IOException e) {
            LOGGER.error("Error fetching the recipe details page", e);
            return null;
        }
    }

    String renderRecipeDetailTemplate(Root recipeDetail) {

        Jinjava jinjava = new Jinjava();

        Map<String, Object> context = new HashMap<>();
        context.put("recipe", recipeDetail);

        String template = "";
        try {

            template = fileService.readFileContent("src/main/resources/templates/recipeDetail.html");
        } catch (IOException e) {
            LOGGER.error(ERROR_MSG, e);
            return ERROR_MSG;
        }

        return jinjava.render(template, context);
    }




}
