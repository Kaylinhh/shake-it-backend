package shakeit.backend.cocktail;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cocktails")
public class CocktailController {

    private final CocktailService service;

    @GetMapping
    private List<Cocktail> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Cocktail getById(@PathVariable Long id){
        return service.getById(id);
    };

    @PostMapping("/add")
    public Cocktail add(@RequestBody Cocktail cocktail){
        return service.add(cocktail);
    };

    @PutMapping("/update/{id}")
    public Cocktail update(@RequestBody Cocktail cocktail, @PathVariable Long id){
        return service.update(cocktail, id);
    };

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
