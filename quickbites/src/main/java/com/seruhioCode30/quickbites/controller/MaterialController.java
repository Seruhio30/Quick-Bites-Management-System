package com.seruhioCode30.quickbites.controller;

import com.seruhioCode30.quickbites.model.Material;
import com.seruhioCode30.quickbites.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    // Obtener todos los materiales
    @GetMapping
    public List<Material> getAllMaterials() {
        return materialService.getAllMaterials();
    }

    // Obtener un material por ID
    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialById(@PathVariable Long id) {
        return materialService.getMaterialById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo material
    @PostMapping
    public Material createMaterial(@RequestBody Material material) {
        return materialService.saveMaterial(material);
    }

    // Actualizar un material existente
    @PutMapping("/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable Long id, @RequestBody Material material) {
        return ResponseEntity.ok(materialService.updateMaterial(id, material));
    }

    // Eliminar un material por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }
}
