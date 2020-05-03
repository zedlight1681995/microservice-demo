package com.smartosc.training.webservice.service.impl;

import com.smartosc.training.exception.EntityNotFoundException;
import com.smartosc.training.webservice.entity.User;
import com.smartosc.training.webservice.repository.UserRepository;
import com.smartosc.training.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

import static com.smartosc.training.webservice.utils.Constant.*;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private MessageSource messageSource;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository,
                           @Qualifier("bundleMessageSource") final MessageSource messageSource) {
        this.userRepository = userRepository;
        this.messageSource = messageSource;
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> result = userRepository.findByEmail(email);
        String message = messageSource.getMessage(
                ENTITY_NOTFOUND_ERROR,
                new Object[]{User.class.getSimpleName().toLowerCase(), "email", email},
                null,
                Locale.getDefault());
        return result.orElseThrow(() -> new EntityNotFoundException(message));
    }

}
