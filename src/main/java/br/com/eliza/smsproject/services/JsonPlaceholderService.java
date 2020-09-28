package br.com.eliza.smsproject.services;

import br.com.eliza.smsproject.dto.CommentsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class JsonPlaceholderService {

    public CommentsDto[] getComments(){
        String url = "https://jsonplaceholder.typicode.com/comments";
        ResponseEntity<CommentsDto[]> response = new RestTemplate().getForEntity(url, CommentsDto[].class);

       if (response.getStatusCodeValue() != 200) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "A system error has occurred!");
        }

       CommentsDto[] comments = response.getBody();
       return comments;

    }
}
