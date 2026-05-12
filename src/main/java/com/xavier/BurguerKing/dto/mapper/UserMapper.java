package com.xavier.BurguerKing.dto.mapper;

import com.xavier.BurguerKing.dto.UserDto;
import com.xavier.BurguerKing.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto map(UserModel userModel){
        UserDto userDto = new UserDto();
        userDto.setId(userModel.getId());
        userDto.setName(userModel.getName());
        userDto.setPhone(userModel.getPhone());
        userDto.setEmail(userModel.getEmail());
        userDto.setPedido(userModel.getPedido());
        return userDto;
    }

    public UserModel map(UserDto userDto){
        UserModel userModel = new UserModel();
        userModel.setId(userDto.getId());
        userModel.setName(userDto.getName());
        userModel.setPhone(userModel.getPhone());
        userModel.setEmail(userDto.getEmail());
        userModel.setPedido(userDto.getPedido());
        return userModel;
    }
}
