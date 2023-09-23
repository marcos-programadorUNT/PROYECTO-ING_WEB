package com.ingenieriaweb.springboot.web.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.ingenieriaweb.springboot.web.app.models.*;
import com.ingenieriaweb.springboot.web.app.services.Interface.*;

@Controller
public class LoginController {
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private USUARIO_SERVICE usuarioService;
    @Autowired
    private ADMINISTRADOR_SERVICE administradorService;
    @Autowired
    private SUCURSAL_SERVICE sucursalService;
    @Autowired
    private EMPLEADO_SERVICE empleadoService;




    @Autowired
    private ROL_SERVICE rolService;

    @RequestMapping(value = {"","/"},method = RequestMethod.GET)
    public String index (Model model){
        model.addAttribute("titulo","Página de Inicio");
        USUARIO usuario = usuarioService.getUsuario();
        model.addAttribute("titulo","Página de Inicio");
        model.addAttribute("usuario",usuario);
        model.addAttribute("sesion",usuario);
        return "redirect:/admin/busCreate";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String IniciarSesion (Model model){
        model.addAttribute("titulo", "Inicio de sesión");
        return "autenticacion/login";
    }

    @RequestMapping(value = "/registrar",method = RequestMethod.GET)
    public String registroCliente (Model model){
        USUARIO usuario=new USUARIO();
        model.addAttribute("usuario",usuario);
        model.addAttribute("roles",rolService.findAll());
        model.addAttribute("sucursales",sucursalService.findAll());
        //model.addAttribute("titulo", "Registro de usuario");
        return "autenticacion/registrar";
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public String guardar(@Valid USUARIO usuario,
                          BindingResult result,
                          Model model,
                          SessionStatus status,
                          @RequestParam(value = "idRol", required = true) Long idRol,
                          @RequestParam(value = "idSucursal", required = true) Long idSucursal) {
    	 if(result.hasErrors()) {
             model.addAttribute("usuario",usuario);
             return "autenticacion/registrar";
         }

         ROL rol = rolService.findOne(idRol);
         usuario.addRol(rol);
         usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
         usuarioService.save(usuario);

         switch (rol.getDescripcion())
         {
             case "administrador":
                 ADMINISTRADOR administrador = new ADMINISTRADOR();
                 administrador.setSucursal(sucursalService.findByIdSucursal(idSucursal));
                 administrador.setUsuario(usuarioService.findTopByOrderByIdDesc());
                 administradorService.save(administrador);
                 break;
             case "empleado":
                 EMPLEADO empleado = new EMPLEADO();
                 empleado.setSucursal(sucursalService.findByIdSucursal(idSucursal));
                 empleado.setUsuario(usuarioService.findTopByOrderByIdDesc());
                 empleadoService.save(empleado);
                 break;
         }
         

         /*

        */


         
         /*
         System.out.println(usuarioService.findTopByOrderByIdDesc().getId());
         System.out.println(sucursalService.findByIdSucursal(Long.valueOf(1)).getDireccion());
         System.out.println(usuarioService.findTopByOrderByIdDesc().getNombre());
		*/
         
         
         status.setComplete();
         return "redirect:/";
    }
}
