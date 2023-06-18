package shakeit.backend.ingredient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService service;

    @GetMapping
    private List<Ingredient> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Ingredient getById(@PathVariable Long id){
        return service.getById(id);
    };

    @PostMapping("/add")
        public Ingredient add(@RequestBody Ingredient ingredient){
            return service.add(ingredient);
        };

    @PutMapping("/update/{id}")
    public Ingredient update(@RequestBody Ingredient ingredient, @PathVariable Long id){
        return service.update(ingredient, id);
    };

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
