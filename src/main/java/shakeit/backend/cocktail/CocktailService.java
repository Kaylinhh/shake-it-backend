package shakeit.backend.cocktail;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CocktailService {

    private final CocktailRepository repository;

    public List<Cocktail> getAll(){
        return repository.findAll();
    };

    public Cocktail getById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + "not found"));
    };

    public Cocktail update(Cocktail cocktail, Long id){
        Cocktail found = getById(id);
        found.setLabel(cocktail.getLabel());
        return repository.save(found);
    };

    public Cocktail add(Cocktail cocktail){
        return repository.save(cocktail);
    };

    public void delete(Long id){
        repository.deleteById(id);
    };
}
