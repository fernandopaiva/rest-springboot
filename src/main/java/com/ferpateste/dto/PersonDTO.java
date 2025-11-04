package com.ferpateste.dto;

import java.io.Serializable;

public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String nome;
    private String email;
    private String cpf;

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


}
