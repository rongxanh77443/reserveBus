package com.kltn.booking;

import com.kltn.booking.entities.Role;
import com.kltn.booking.entities.User;
import com.kltn.booking.repositories.RoleRepository;
import com.kltn.booking.repositories.UserRepository;
import com.kltn.booking.utils.EnumRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;

@SpringBootApplication
public class BookingApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            roleRepository.saveAll(Arrays.asList(
                    new Role(EnumRole.ROLE_ADMIN.name()),
                    new Role(EnumRole.ROLE_MANAGER.name()),
                    new Role(EnumRole.ROLE_USER.name())
            ));
        }
        if (userRepository.count() == 0) {
            User user = initUser("thangpx", "123456", "thangpx@hcmute.edu.vn", "Thắng Phạm");
            user.setRoles(roleRepository.findAll());
            userRepository.save(user);
        }
    }

    private User initUser(String username, String password, String email, String fullName) {
        User user = new User();
        user.setUsername(username.toLowerCase());
        user.setPassword(password);
        user.setEmail(email.toLowerCase());
        user.setFullName(fullName);
        user.setEnable(true);
        userRepository.save(user);
        return user;
    }
}
