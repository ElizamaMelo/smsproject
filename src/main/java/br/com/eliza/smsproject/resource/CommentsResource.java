package br.com.eliza.smsproject.resource;

import br.com.eliza.smsproject.dto.CommentsDto;
import br.com.eliza.smsproject.services.JsonPlaceholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentsResource {

    private final JsonPlaceholderService jsonPlaceholderService;

    @Autowired
    public CommentsResource(JsonPlaceholderService jsonPlaceholderService) {
        this.jsonPlaceholderService = jsonPlaceholderService;
    }

    @GetMapping
    public ResponseEntity<CommentsDto> getComments (){
        CommentsDto[] commentsDto = jsonPlaceholderService.getComments();
        return new ResponseEntity(commentsDto, HttpStatus.OK);

    }

}
