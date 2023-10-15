package rocketseat.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")
public class userController {
    
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody userModel userModel){
        var user = this.userRepository.findByUsername(userModel.getUsername());
        if(user!=null){
            return ResponseEntity.status(400).body("deu ruim");
        }

        var password = BCrypt.withDefaults()
        .hashToString(12, userModel.getPassword().toCharArray() );
        userModel.setPassword(password);
        var userCreated =this.userRepository.save(userModel);
        return ResponseEntity.status(201).body("jóia");
    }
}
