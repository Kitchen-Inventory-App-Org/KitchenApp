package com.kitchen.table;

// import com.model.Pantry;
// import com.repository.PantryRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/home")
public class PantryController {

	private final PantryService pantryService;

	public PantryController(PantryService pantryService) {
		this.pantryService = pantryService;
	}

	@CrossOrigin
	@GetMapping("/")
	public String index() {
		return "Start of Kitchen Inventory App";
	}

	@CrossOrigin
	@GetMapping("/searchRecipes")
	public List<String> searchRecipes(@RequestParam String query) {
		return pantryService.getRecipe(query);
	}

}

