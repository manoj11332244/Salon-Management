package com.salon.service.impl;

import com.salon.exception.UserException;
import com.salon.model.User;
import com.salon.repository.UserRepository;
import com.salon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {
        Optional<User> otp = userRepository.findById(id);
        if (otp.isPresent()) {
            return otp.get();
        }
        throw new UserException("user not found");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) throws UserException {
        Optional<User> otp = userRepository.findById(id);
        if (otp.isEmpty()) {
            throw new UserException("user not exist with id" + id);
        }

        userRepository.deleteById(otp.get().getId());
    }

    @Override
    public User updateUser(User user, Long id) throws UserException {
        Optional<User> otp = userRepository.findById(id);
        if (otp.isEmpty()) {
            throw new UserException("user not found with id" + id);
        }
        User exist = otp.get();
        exist.setFullName(user.getFullName());
        exist.setEmail(user.getEmail());
        exist.setRole(user.getRole());
        exist.setPhone(user.getPhone());
        exist.setUserName(user.getUserName());
        return userRepository.save(exist);
    }
}
