package com.varisgreen.shoopy.back.controller;

import com.varisgreen.shoopy.back.entity.Usuario;
import com.varisgreen.shoopy.back.repository.UsuarioRepository;
import com.varisgreen.shoopy.back.service.implementation.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/user/")
public class UsuarioController {

    @Autowired
    private final UsuarioServiceImpl usuarioService;
    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioServiceImpl usuarioService, UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("add")
    public ResponseEntity addUsuario (@RequestBody Usuario user){
        System.out.println("[CONTROLLER] Usuario: "+user.toString());
        return new ResponseEntity(usuarioService.save(user), HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity getUsers (){
        return new ResponseEntity(usuarioRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getUser (@PathVariable long id){
        return new ResponseEntity(usuarioRepository.findById(id), HttpStatus.OK);
    }
}
