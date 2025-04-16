package com.dnt.roombooking.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }


    @GetMapping("/exist/{user-id}")
    public ResponseEntity<Boolean> isExistUser(
            @PathVariable("user-id") Integer userId
    ) {
        return ResponseEntity.ok(userService.isExistsById(userId));
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserResponse> findById(
            @PathVariable("user-id") Integer userId
    ) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PostMapping
    public ResponseEntity<String> createUser(
            @RequestBody @Valid UserRequest userRequest
            )
    {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(
            @RequestBody @Valid UserRequest userRequest
    )
    {
        userService.updateUser(userRequest);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping ("/{user-id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable("user-id") Integer userId
    ) {
        userService.deleteUser(userId);
        return ResponseEntity.accepted().build();
    }
}
