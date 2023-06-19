package shakeit.backend.cocktail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shakeit.backend.ingredient.Ingredient;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Long> {

    @Query("SELECT i FROM Ingredient i WHERE i.id = :id")
    Ingredient findIngredientById(@Param("id") Long id);
}
