package com.seruhioCode30.quickbites.service;

import com.seruhioCode30.quickbites.model.User;
import com.seruhioCode30.quickbites.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Crear un nuevo usuario
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Actualizar un usuario
    public User updateUser(Long id, User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setUsername(user.getUsername());
                    existingUser.setPassword(user.getPassword());
                    existingUser.setRole(user.getRole());
                    return userRepository.save(existingUser);
                }).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // Eliminar un usuario
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
