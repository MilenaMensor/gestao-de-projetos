package com.project_management.progirls.Service;

import com.project_management.progirls.Models.User;
import com.project_management.progirls.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Lista os usuários
    public List<User> userList() {
        return userRepository.findAll();
    }

    // Achar um usuário pelo seu ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Método para criar um novo usuário
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Método para editar um usuário já existente
    public User updateUser(Long id, User userDetails) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setName(userDetails.getName());
            existingUser.setEmail(userDetails.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    // Método para deletar um usuário da lista
    public boolean userDelete(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
