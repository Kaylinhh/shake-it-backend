package shakeit.backend.ingredient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {
    
    private final IngredientRepository repository;
    
    public List<Ingredient> getAll(){
        return repository.findAll();
    };
    
    public Ingredient getById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + "not found"));
    };
    
    public Ingredient update(Ingredient ingredient, Long id){
        Ingredient found = getById(id);
        found.setLabel(ingredient.getLabel());
        return repository.save(found);
    };

    public Ingredient add(Ingredient ingredient){
        return repository.save(ingredient);
    };
    
    public void delete(Long id){
        repository.deleteById(id);
    };
    
}
