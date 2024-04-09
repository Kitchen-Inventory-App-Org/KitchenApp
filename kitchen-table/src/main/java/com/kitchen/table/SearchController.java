package com.kitchen.table;

// import com.model.Pantry;
// import com.repository.PantryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ch.qos.logback.core.pattern.parser.FormattingNode;

import java.util.List;
import java.util.Optional;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@RestController
@CrossOrigin
@RequestMapping("/Search")
public class SearchController {

    @GetMapping("/recipe")
    public String getRecipe(@RequestParam("ingredient") String ingredient) {
        StringBuilder response = new StringBuilder();
    
        // Specify the path to the "Food.txt" file
        String filePath = "src/main/java/resources/Food.txt";
    
        // Load the file and search for recipes containing the ingredient
        try (Scanner sc = new Scanner(new File(filePath))) {
            boolean foundRecipe = false;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.toLowerCase().contains(ingredient.toLowerCase())) {
                    response.append("Recipe found: ").append(line).append("\n");
                    foundRecipe = true;
                }
            }
            if (!foundRecipe) {
                response.append("No recipe found for ingredient: ").append(ingredient);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            response.append("Error: File 'Food.txt' not found");
        } catch (Exception e) {
            e.printStackTrace();
            response.append("Error occurred while searching for recipe");
        }
    
        return response.toString();
    }
}
