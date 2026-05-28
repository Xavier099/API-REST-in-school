package com.xavier.BurguerKing.Service;

import com.xavier.BurguerKing.dto.UserDto;
import com.xavier.BurguerKing.dto.mapper.UserMapper;
import com.xavier.BurguerKing.model.UserModel;
import com.xavier.BurguerKing.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    final UserMapper userMapper;
    final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public UserDto addUser(UserDto userDto){
        UserModel user = userMapper.map(userDto);
        user = userRepository.save(user);
        return userMapper.map(user);
    }

    public UserDto findbyId(Long id){
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        return userMapper.map(user);
    }

    public List<UserDto> listAll(){
        List<UserModel> user = userRepository.findAll();
        return user.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<UserDto> deletar(Long id){
        return userRepository.findById(id)
                .map(user -> {UserDto dto = userMapper.map(user);
                userRepository.deleteById(id);
                return dto;});
    }

    @Transactional
    public UserDto updateUser(Long id, UserDto userDto){
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        user.setName(userDto.getName());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        user.setProdutos(userDto.getPedido());
        return userMapper.map(userRepository.save(user));
    }
}
