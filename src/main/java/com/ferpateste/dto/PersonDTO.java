package com.ferpateste.dto;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

//@JsonPropertyOrder({"id", "nome", "email", "cpf"})
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    //@JsonProperty("name")
    private String nome;

    //@JsonProperty("e-mail")
    private String email;

    //@JsonIgnore
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDay;

    public PersonDTO() {
    }

    public PersonDTO(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
