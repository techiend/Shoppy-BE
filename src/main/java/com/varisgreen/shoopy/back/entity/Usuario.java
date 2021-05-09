package com.varisgreen.shoopy.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "correo")
    private String correo;

    @Column(name = "password")
    private String password;

    @Column(name = "tipo")
    private Integer tipo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "genero")
    private Integer genero;

    @Column(name = "fecha_nacimiento")
    private String fecha_nacimiento;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_ID", referencedColumnName = "id")
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Contacto> contactos;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rol_ID", referencedColumnName = "id")
    private Rol rol;

    public Usuario() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getGenero() {
        return genero;
    }

    public void setGenero(Integer genero) {
        this.genero = genero;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void addContacto(Contacto contacto){
        this.contactos.add(contacto);
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario1 = (Usuario) o;
        return id == usuario1.id &&
                Objects.equals(correo, usuario1.correo) &&
                Objects.equals(password, usuario1.password) &&
                Objects.equals(tipo, usuario1.tipo) &&
                Objects.equals(nombre, usuario1.nombre) &&
                Objects.equals(apellido, usuario1.apellido) &&
                Objects.equals(genero, usuario1.genero) &&
                Objects.equals(fecha_nacimiento, usuario1.fecha_nacimiento) &&
                Objects.equals(telefono, usuario1.telefono) &&
                Objects.equals(usuario, usuario1.usuario) &&
                Objects.equals(usuarios, usuario1.usuarios) &&
                Objects.equals(contactos, usuario1.contactos) &&
                Objects.equals(rol, usuario1.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, correo, password, tipo, nombre, apellido, genero, fecha_nacimiento, telefono, usuario, usuarios, contactos, rol);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", tipo=" + tipo +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", genero=" + genero +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", usuario=" + usuario +
                ", usuarios=" + usuarios +
                ", contactos=" + contactos +
                ", rol=" + rol +
                '}';
    }
}
