package com.identitye2e.recipeservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hubspot.jinjava.Jinjava;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RecipeWebController {

    @GetMapping("/displayRecipes")
    @ResponseBody
    public String displayRecipes() {
        return testTastyAPI();
    }

    private String testTastyAPI() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://tasty.p.rapidapi.com/recipes/auto-complete?prefix=chicken")
                .get()
                .addHeader("X-RapidAPI-Key", "5d6b6ca9b0msh6f72ab9454d5861p17be82jsn10aa54bd2876")
                .addHeader("X-RapidAPI-Host", "tasty.p.rapidapi.com")
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();

                // Deserialize JSON using Jackson's ObjectMapper
                ObjectMapper objectMapper = new ObjectMapper();
                AutoCompleteResponse autoCompleteResponse = objectMapper.readValue(responseBody, AutoCompleteResponse.class);

                return renderTemplate(autoCompleteResponse.getResults());

            } else {
                return "Failed to fetch data. Response code: " + response.code();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while calling the Tasty API";
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
}
