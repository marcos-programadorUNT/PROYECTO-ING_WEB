package com.ingenieriaweb.springboot.web.app.services.Implementation;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.web.app.dao.USUARIO_DAO;
import com.ingenieriaweb.springboot.web.app.models.*;
import com.ingenieriaweb.springboot.web.app.services.Interface.USUARIO_SERVICE;

@Service
public class USUARIO_IMPL implements USUARIO_SERVICE {

	
	@Autowired
    private USUARIO_DAO usuarioDAO;

    @Override
    @Transactional(readOnly = true)
    public List<USUARIO> findAll() {
        return (List<USUARIO>) usuarioDAO.findAll();
    }

    @Override
    @Transactional
    public void save(USUARIO usuario) {
        usuarioDAO.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public USUARIO findOne(Long id) {
        return usuarioDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuarioDAO.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public USUARIO findByEmail(String email){
        return usuarioDAO.findByEmail(email);
    }

    @Override
    public USUARIO getUsuario() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        USUARIO usuario = findByEmail(userDetail.getUsername());
        return usuario;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        USUARIO usuario = usuarioDAO.findByEmail(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(List<ROL> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getDescripcion())).collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public USUARIO findTopByOrderByIdDesc() {
    	return usuarioDAO.findTopByOrderByIdDesc();
    }
}
