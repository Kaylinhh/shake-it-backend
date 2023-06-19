package shakeit.backend.bind;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shakeit.backend.cocktail.Cocktail;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bind")
public class CocktailIngredientController {

    private final CocktailIngredientService service;

    @GetMapping("/cocktailId={cocktailId}/ingredientId={ingredientId}")
    public Cocktail bind(
            @PathVariable("ingredientId") Long ingredientId,
            @PathVariable("cocktailId") Long cocktailId) {
    return service.bind(ingredientId, cocktailId);
    }

    @PostMapping
    public ResponseEntity<CocktailIngredient> create(@RequestBody CocktailIngredient binding) {
        CocktailIngredient created = service.create(binding);
        return ResponseEntity.ok(binding);
    }
}
