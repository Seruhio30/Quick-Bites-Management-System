package com.seruhioCode30.quickbites.service;

import com.seruhioCode30.quickbites.model.Ingredient;
import com.seruhioCode30.quickbites.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    // Método para listar todos los ingredientes
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    // Método para buscar un ingrediente por ID
    public Optional<Ingredient> getIngredientById(Long id) {
        return ingredientRepository.findById(id);
    }

    // Método para crear un nuevo ingrediente
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    // Método para actualizar un ingrediente
    public Ingredient updateIngredient(Long id, Ingredient ingredient) {
        return ingredientRepository.findById(id)
                .map(existingIngredient -> {
                    existingIngredient.setName(ingredient.getName());
                    return ingredientRepository.save(existingIngredient);
                }).orElseThrow(() -> new RuntimeException("Ingrediente no encontrado"));
    }

    // Método para eliminar un ingrediente
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}
