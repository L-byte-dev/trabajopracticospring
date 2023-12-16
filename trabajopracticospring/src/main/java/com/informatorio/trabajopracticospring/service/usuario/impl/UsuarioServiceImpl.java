package com.informatorio.trabajopracticospring.service.usuario.impl;

import com.informatorio.trabajopracticospring.repository.usuario.UsuarioRepository;
import com.informatorio.trabajopracticospring.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
}
