package br.com.eliza.smsproject;

import br.com.eliza.smsproject.enumerations.Status;
import br.com.eliza.smsproject.model.Message;
import br.com.eliza.smsproject.model.Role;
import br.com.eliza.smsproject.model.User;
import br.com.eliza.smsproject.repository.MessageRepository;
import br.com.eliza.smsproject.repository.RoleRepository;
import br.com.eliza.smsproject.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SmsprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmsprojectApplication.class, args);
    }

    @Bean
    public CommandLineRunner sampleData(UserRepository userRepository, RoleRepository roleRepository, MessageRepository messageRepository) {
        return (args -> {
           /* User eliza = userRepository.save(new User("Eliza Melo", "Eliza", new BCryptPasswordEncoder().encode("123")));
            User rodrigo = userRepository.save(new User("Rodrigo F.", "Rodrigo", new BCryptPasswordEncoder().encode("123")));

            roleRepository.save(new Role("ROLE_USER", rodrigo));
            roleRepository.save(new Role("ROLE_ADMIN", eliza));*/

            Message message1 = messageRepository.save(new Message("Subject1", "Msg body 1"));
            Message message2 = messageRepository.save(new Message("Subject2","Msg body 2"));
            Message message3 = messageRepository.save(new Message("Subject3","Msg body 3"));
            Message message4 = messageRepository.save(new Message("Subject4","Msg body 4"));
            Message message5 = messageRepository.save(new Message("Subject5","Msg body 5"));
            Message message6 = messageRepository.save(new Message("Subject6","Msg body 6"));
        });

    }

}