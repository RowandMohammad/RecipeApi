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
    public void i_should_see_a_list_of_recipes_related_to(String expectedQuery) {
        // This is a very basic check, you might want to parse the response and verify it more thoroughly
        assertTrue(response.contains(expectedQuery));
    }

    @Given("I make a request for the details of recipe with id {int}")
    public void i_make_a_request_for_the_details_of_recipe_with_id(Integer id) {
        response = controller.displayRecipeDetails(id);
        assertNotNull(response);
    }

    @Then("I should see the details of the recipe")
    public void i_should_see_the_details_of_the_recipe() {
        assertTrue("Response does not contain recipe name", response.contains("<h1 class=\"title\">"));
        assertTrue("Response does not contain recipe description", response.contains("<p class=\"description\">"));
        assertTrue("Response does not contain thumbnail image", response.contains("<img class=\"recipe-image\""));
    }
}

