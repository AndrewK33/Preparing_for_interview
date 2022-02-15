package ru.geekbrains.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.dtos.ErrorDto;
import ru.geekbrains.entitys.User;
import ru.geekbrains.exceptions.NotFoundException;
import ru.geekbrains.repositories.UserRepository;

import java.lang.annotation.Target;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {

    private final UserRepository userRepository;



    @GetMapping("/all")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}/id")
    public User findById(@PathVariable("id") Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id = " + id + " is not exists"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        if (user.getId() != null) {
            throw new IllegalArgumentException("Can't create user with id != null");
        }
        return userRepository.save(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User update(@RequestBody User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("Can't update user with id = null");
        }
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}/id")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto notFoundExceptionHandler(IllegalArgumentException ex) {
        return new ErrorDto(ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto notFoundExceptionHandler(NotFoundException exception) {
        return new ErrorDto(exception.getMessage());
    }



}
