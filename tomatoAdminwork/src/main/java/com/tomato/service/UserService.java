package com.tomato.service;

import com.tomato.model.LoginRequest;
import com.tomato.model.LoginResponse;
import com.tomato.model.SignupResponse;
import com.tomato.model.User;
import com.tomato.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    String pepper = "tomato1234";
    @Autowired
    UserRepository userRepository;

    public LoginResponse authenticate(LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail());
        LoginResponse loginResponse = new LoginResponse();
        if(user == null)
        {
            loginResponse.setStatus(false);
            loginResponse.setMessage("User not found");
        }
        else
        {
            String hashedPassword = BCrypt.hashpw(loginRequest.getPassword()+pepper,user.getSalt());
            if(user.getPassword().equals(hashedPassword))
            {
                loginResponse.setStatus(true);
                loginResponse.setMessage("Login Successful");
            }
            else
            {
                loginResponse.setStatus(false);
                loginResponse.setMessage("User not found");
            }
        }
        return loginResponse;
    }
    public SignupResponse register(User user){

        SignupResponse signupResponse = new SignupResponse();
        if(user.getUserType()==2){
            signupResponse.setStatus(false);
            signupResponse.setMessage("Cannot register as Admin");
        }

        User currentUser = userRepository.findByEmail(user.getEmail());
        if(currentUser!=null)
        {
            signupResponse.setStatus(false);
            signupResponse.setMessage("User already exists");
            return signupResponse;
        }else{
            String salt = BCrypt.gensalt();
            String hashedPassword = BCrypt.hashpw(user.getPassword()+pepper,salt);
            user.setPassword(hashedPassword);
            user.setSalt(salt);
            user.setWalletAmount((long)(1000* Math.random()));
            userRepository.save(user);
            signupResponse.setMessage("Signup successful");
            signupResponse.setStatus(true);
            return signupResponse;
        }
    }
}
