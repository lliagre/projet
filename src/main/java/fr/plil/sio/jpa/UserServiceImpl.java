package fr.plil.sio.jpa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import javax.persistence.EnumType;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    @Transactional
    public User createUser(String name, String password, EnumType et) {
        if (name == null) {
            throw new NullPointerException("name must be not null");
        }

        if (userRepository.findByName(name) != null) {
            throw new IllegalArgumentException("user already present");
        }

        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setType(et);
        userRepository.save(user);

        return user;
    }

    @Override
    @Transactional
    public void removeUser(String name) {
        if (name == null) {
            throw new NullPointerException("name must be not null");
        }

        User user = userRepository.findByName(name);

        if (user == null) {
            throw new IllegalArgumentException("user not present");
        }

        userRepository.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findByName(String name) {
        if (name == null) {
            throw new NullPointerException("name must be not null");
        }

        return userRepository.findByName(name);
    }
}
