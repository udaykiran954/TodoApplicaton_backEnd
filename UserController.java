package com.TodoApplication.TodoApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/request")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        List<Todo> users = userService.getAllData();
        if(!users.isEmpty())
            return ResponseEntity.ok(users);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed to fetch the data");
    }
    @GetMapping("/user{id}")
    public ResponseEntity<Todo> getUserById(@PathVariable Long id){
        Todo user = userService.getUser(id);
        if(user!=null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    @PostMapping("/post")
    public ResponseEntity<?> AddTheUser(@RequestBody Todo user){
        if(user!=null){
            userService.Post(user);
            return ResponseEntity.ok("user created successfully");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed to post the data");
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody Todo user){
        if(user==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed to update the empty user");
        }
        Todo user1 = userService.getUser(user.getId());
        if(user1==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("your updating user doesn't exist");
        }
        userService.Update(user);
        return ResponseEntity.ok("Updated Successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteById(@PathVariable Long id){
        if(userService.deleteDataById(id)){
            return ResponseEntity.ok("Successfully deleted");
        }
       return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed delete empty user");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> DeleteAllData(@RequestBody Todo user){

        if(userService.deleteAllData()){
            return ResponseEntity.ok("Successfully Deleted all data");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete the data");
    }

}
