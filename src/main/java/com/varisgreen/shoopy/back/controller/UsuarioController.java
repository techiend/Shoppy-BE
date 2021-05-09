package com.varisgreen.shoopy.back.controller;

import com.varisgreen.shoopy.back.entity.Response;
import com.varisgreen.shoopy.back.entity.Usuario;
import com.varisgreen.shoopy.back.exception.UsuarioNotFoundException;
import com.varisgreen.shoopy.back.service.implementation.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/user/")
public class UsuarioController {

    @Autowired
    private final UsuarioServiceImpl usuarioService;

    public UsuarioController(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("add")
    public ResponseEntity addUsuario (@RequestBody Usuario user){
        Response<Usuario> response = new Response<>();
        Usuario usuario = usuarioService.save(user);
        response.setCodigo(0);
        response.setObj(usuario);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity getUsers (){
        Response<List<Usuario>> response = new Response<>();
        List<Usuario> usuarios = usuarioService.findAll();
        response.setCodigo(0);
        response.setObj(usuarios);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getUser (@PathVariable long id){
        Response<Usuario> response = new Response<>();
        try {
            Usuario usuario = usuarioService.findById(id);
            response.setCodigo(0);
            response.setObj(usuario);
        }
        catch (UsuarioNotFoundException e){
            response.setCodigo(1);
            response.setMsg(e.getMessage());
        }
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
