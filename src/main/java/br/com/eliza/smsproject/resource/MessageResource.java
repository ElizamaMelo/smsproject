package br.com.eliza.smsproject.resource;

import br.com.eliza.smsproject.model.Message;
import br.com.eliza.smsproject.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping( value = "/api/v1//message")
public class MessageResource {

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping
    @Transactional
    //Depois que user estiver ok. Criar atraves de user usando url message/idUser
    public ResponseEntity<Message> create (@RequestBody @Valid Message message){
        Message m = messageRepository.save(message);
        return new ResponseEntity<>(m, HttpStatus.CREATED);

    }

    @GetMapping
    @Transactional
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @GetMapping("/{id}")
    @Transactional
   public ResponseEntity<Message> findById (@PathVariable Long id){
        Message m = messageRepository.findById(id).get();
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Message> delete(@PathVariable Long id) {
      messageRepository.deleteById(id);
      return ResponseEntity.ok().build();
    }

}




