package com.sena.alekTours.controller;

import com.sena.alekTours.entity.Usuario;
import com.sena.alekTours.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;


@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private final UsuarioRepository usuarioRepository;


    public AuthController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    // ============================================
    // REGISTRO DE USUARIO
    // ============================================
    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@RequestBody Map<String, String> datos) {

        String username = datos.get("username");
        String password = datos.get("password");
        String nombre = datos.get("nombre");
        String email = datos.get("email");

        // Validar campos obligatorios
        if (username == null || password == null) {
            return ResponseEntity.badRequest().body("Username y password son obligatorios");
        }

        // Validar si el usuario ya existe
        if (usuarioRepository.existsByUsername(username)) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("El username ya existe");
        }

        // Crear nuevo usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsername(username);
        nuevoUsuario.setPassword(password); // Por simplicidad, sin encriptar
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setEmail(email);

        usuarioRepository.save(nuevoUsuario);

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Usuario registrado correctamente");
        respuesta.put("username", username);

        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }


    // ============================================
    // LOGIN DE USUARIO
    // ============================================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {

        String username = credenciales.get("username");
        String password = credenciales.get("password");

        // Buscar usuario en MySQL
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(username);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            // Comparar contraseña (sin encriptar)
            if (usuario.getPassword().equals(password)) {

                Map<String, Object> respuesta = new HashMap<>();
                respuesta.put("mensaje", "Login exitoso");
                respuesta.put("id", usuario.getId());
                respuesta.put("username", usuario.getUsername());
                respuesta.put("nombre", usuario.getNombre());
                respuesta.put("email", usuario.getEmail());

                return ResponseEntity.ok(respuesta);
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Usuario o contraseña incorrectos");
    }


    // ============================================
    // LISTAR TODOS LOS USUARIOS (SOLO PARA PRUEBA)
    // ============================================
    @GetMapping("/usuarios")
    public ResponseEntity<?> listarUsuarios() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }


    // ============================================
    // ENDPOINT DE PRUEBA
    // ============================================
    @GetMapping("/test")
    public String test() {
        return "✅ Sistema de autenticación con MySQL funcionando";
    }
}

