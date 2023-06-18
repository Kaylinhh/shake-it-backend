package shakeit.backend.cocktail;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shakeit.backend.ingredient.Ingredient;
import shakeit.backend.ingredient.IngredientRepository;

@Service
@RequiredArgsConstructor
public class CocktailIngredientService {

    private final CocktailRepository cocktailRepository;
    private final IngredientRepository ingredientRepository;

    public Cocktail bind(Long ingredientId, Long cocktailId) {
        Ingredient ingredientFound = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new RuntimeException(ingredientId + "not found"));
        Cocktail cocktailFound = cocktailRepository.findById(cocktailId)
                .orElseThrow(() -> new RuntimeException(cocktailId + "not found"));
        cocktailFound.getIngredientList().add(ingredientFound);
        return cocktailRepository.save(cocktailFound);
    };
}
