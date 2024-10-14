package ru.ivonin.testsecurity2dbthemeleaf.service;

import ru.ivonin.testsecurity2dbthemeleaf.dto.UserDto;
import ru.ivonin.testsecurity2dbthemeleaf.repository.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
