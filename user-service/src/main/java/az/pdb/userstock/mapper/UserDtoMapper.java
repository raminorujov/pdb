package az.pdb.userstock.mapper;

import az.pdb.userstock.domain.User;
import az.pdb.userstock.dto.UserDto;

import java.time.*;

public class UserDtoMapper {

    public UserDto map(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());
        ZonedDateTime zdt = user.getBirthDate().atStartOfDay(ZoneId.systemDefault());
        userDto.setBirthDate(zdt.toInstant().toEpochMilli());
        return userDto;
    }

    public User map(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        LocalDate dateTime = LocalDate.ofInstant(Instant.ofEpochMilli(userDto.getBirthDate()), ZoneId.systemDefault());
        user.setBirthDate(dateTime);
        return user;
    }
}
