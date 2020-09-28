package br.com.eliza.smsproject.model;

import br.com.eliza.smsproject.enumerations.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity(name = "tbl_message")
public class Message {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PROCESSING;


    @NotNull @NotEmpty
    private String campaign;


    @NotNull @NotEmpty
    private String msgBody;


    private LocalDateTime dataCriacao = LocalDateTime.now();

    @JsonIgnore
    @ManyToOne
    private User user;

    public Message(@NotEmpty @NotNull String campaign, @NotEmpty @NotNull  String msgBody) {
        this.status = status;
        this.campaign = campaign;
        this.msgBody = msgBody;
    }

    public Message(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
