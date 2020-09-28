package br.com.eliza.smsproject.services;

import br.com.eliza.smsproject.model.User;
import br.com.eliza.smsproject.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class UserService {

    private UserRepository userRepository;

    @Transactional
    public User update(Long id) {
        User u = userRepository.getOne(id);
        u.setName(u.getName());
        u.setLogin(u.getLogin());
        u.setPassword(u.getPassword());
        u.getDataCriacao();
        return u;

    }

}




