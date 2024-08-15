package stepdefs;

import com.identitye2e.recipeservice.RecipeResult;
import com.identitye2e.recipeservice.RecipeWebController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RecipeServiceSteps {

    private RecipeWebController controller = new RecipeWebController();
    private String response;
    private RecipeResult recipeDetail;

    @Given("I make a request to display recipes with the query {string}")
    public void iMakeARequestToDisplayRecipesWithTheQuery(String query) {
        response = controller.displayRecipes(query);
        assertNotNull(response);
    }

    @Then("I should see a list of recipes related to {string}")
    public void iShouldSeeSListOfRecipesRelatedTo(String expectedQuery) {
        assertTrue(response.contains(expectedQuery));
    }

    @Given("I make a request for the details of recipe with id {int}")
    public void iMakeARequestForTheDetailsOfRecipeWithID(Integer id) {
        response = controller.displayRecipeDetails(id);
        assertNotNull(response);
    }

    @Then("I should see the details of the recipe")
    public void iShouldSeeTheDetailsOfTheRecipe() {
        assertTrue("Response does not contain recipe name", response.contains("<h1 class=\"title\">"));
        assertTrue("Response does not contain recipe description", response.contains("<p class=\"description\">"));
        assertTrue("Response does not contain thumbnail image", response.contains("<img class=\"recipe-image\""));
    }
}

