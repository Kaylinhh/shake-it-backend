package shakeit.backend.cocktail;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bind")
public class CocktailIngredientController {

    private final CocktailIngredientService service;

    @GetMapping("/ingredientId={ingredientId}/cocktailId={cocktailId}")
    public Cocktail bind(
            @PathVariable("ingredientId") Long ingredientId,
            @PathVariable("cocktailId") Long cocktailId) {
    return service.bind(ingredientId, cocktailId);
    }
}
