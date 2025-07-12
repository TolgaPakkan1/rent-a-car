package com.example.RentACar.service;

import com.example.RentACar.dto.AuthDto;
import com.example.RentACar.dto.LoginDto;
import com.example.RentACar.dto.UserDto;
import com.example.RentACar.enumm.RoleEnum;
import com.example.RentACar.model.User;
import com.example.RentACar.repository.UserRepository;
import com.example.RentACar.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service

public class UserService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    public UserDto createUser(User user){
        if (Objects.isNull(user.getRoles())){
            user.setRoles(RoleEnum.ROLE_USER.toString());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return UserMapper.INSTANCE.userToUserDto(userRepository.save(user));
    }

    public LoginDto login(AuthDto authDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getPassword()));
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(authentication);
        }
        throw new UsernameNotFoundException("invalid user.");
    }
}
