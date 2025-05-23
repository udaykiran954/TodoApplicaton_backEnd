package com.TodoApplication.TodoApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    UserRepository repo;
    public List<Todo> getAllData(){
        return repo.findAll();
    }
    public void Post(Todo user){
        repo.save(user);
    }
    public void Update(Todo user){
        repo.save(user);

    }

    public boolean deleteDataById(Long id) {
        Optional<Todo> user = repo.findById(id);
        if (user!=null) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean deleteAllData(){
        repo.deleteAll();
        return true;
    }
    public Todo getUser(Long id){
        Optional<Todo> user = repo.findById(id);
        return user.orElse(null);
    }
}
