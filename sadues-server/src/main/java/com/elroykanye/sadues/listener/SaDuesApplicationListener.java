package com.elroykanye.sadues.listener;

import com.elroykanye.sadues.data.entity.User;
import com.elroykanye.sadues.data.enums.Role;
import com.elroykanye.sadues.data.repository.UserRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SaDuesApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public SaDuesApplicationListener(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(@NotNull ApplicationReadyEvent event) {
        log.info("Creating default admin account");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        List<User> superAdmins = userRepository.findAllByRole(Role.ADMIN);
        if (superAdmins.size() == 0) {
            log.info("Creating default admin account");
            User superAdmin = User.builder()
                    .name("Admin").email("admin")
                    .password(passwordEncoder.encode("password"))
                    .id(null).approved(true)
                    .role(Role.ADMIN)
                    .build();
            userRepository.save(superAdmin);
        }
    }
}
