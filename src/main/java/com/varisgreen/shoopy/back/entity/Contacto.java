package com.varisgreen.shoopy.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Contacto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "valor")
    private String valor;

    @Column(name = "tipo")
    private int tipo;

    @ManyToOne
    @JoinColumn(name = "usuario_ID", referencedColumnName = "id")
    @JsonIgnore
    private Usuario usuario;

    public Contacto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return id == contacto.id &&
                tipo == contacto.tipo &&
                Objects.equals(valor, contacto.valor) &&
                Objects.equals(usuario, contacto.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, tipo, usuario);
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", valor='" + valor + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
