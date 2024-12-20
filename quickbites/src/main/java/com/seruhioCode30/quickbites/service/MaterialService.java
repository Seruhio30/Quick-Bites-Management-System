package com.seruhioCode30.quickbites.service;

import com.seruhioCode30.quickbites.model.Material;
import com.seruhioCode30.quickbites.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    // Obtener todos los materiales
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    // Obtener un material por ID
    public Optional<Material> getMaterialById(Long id) {
        return materialRepository.findById(id);
    }

    // Crear un nuevo material
    public Material saveMaterial(Material material) {
        return materialRepository.save(material);
    }

    // Actualizar un material
    public Material updateMaterial(Long id, Material material) {
        return materialRepository.findById(id)
                .map(existingMaterial -> {
                    existingMaterial.setName(material.getName());
                    existingMaterial.setQuantity(material.getQuantity());
                    existingMaterial.setUnit(material.getUnit());
                    return materialRepository.save(existingMaterial);
                }).orElseThrow(() -> new RuntimeException("Material no encontrado"));
    }

    // Eliminar un material
    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }
}
