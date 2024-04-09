package com.kitchen.table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;


import org.springframework.stereotype.Service;

@Service

/* Service class to show recipes in Spring Boot */
public class PantryService {

    /** Method to search for recipes based on user input */
    public List<String> getRecipe(String userInput) {
        List<String> foundRecipes = new ArrayList<>();
        try {
            String filePath = "complete/src/main/java/com/Food.txt";
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.toLowerCase().contains(userInput.toLowerCase())) {
                        foundRecipes.add(line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading Food.txt file: " + e.getMessage());
            e.printStackTrace();
        }
        return foundRecipes;
    }

}
