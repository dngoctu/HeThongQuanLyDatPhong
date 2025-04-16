package com.dnt.roombooking.user;

import com.dnt.roombooking.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponse> findAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    public Boolean isExistsById(Integer userId) {
        return userRepository.findById(userId).isPresent();
    }

    public UserResponse findById(Integer userId) {
        return userRepository.findById(userId)
                .map(userMapper::toUserResponse)
                .orElseThrow(() -> new UserNotFoundException(String.format("Không tìm thấy người dùng %s", userId)));
    }

    public String createUser(UserRequest userRequest) {
        var customer = userRepository.save(userMapper.toUserRequest(userRequest));
        return customer.getId().toString();
    }

    public void updateUser(UserRequest userRequest) {
        var user = userRepository.findById(userRequest.id())
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("Không tìm thấy người dùng %s", userRequest.id())
                ));
        mergeUser(user, userRequest);
        userRepository.save(user);
    }

    private void mergeUser(User user, UserRequest userRequest) {
        if(StringUtils.isNotBlank(userRequest.firstName()))
            user.setFirstName(userRequest.firstName());

        if(StringUtils.isNotBlank(userRequest.lastName()))
            user.setLastName(userRequest.lastName());

        if(StringUtils.isNotBlank(userRequest.email()))
            user.setEmail(userRequest.email());

        if(StringUtils.isNotBlank(userRequest.description()))
            user.setDescription(userRequest.description());

        if(userRequest.role() != null)
            user.setRole(userRequest.role());
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
