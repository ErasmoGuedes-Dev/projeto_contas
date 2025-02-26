package br.com.projetocontas.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetocontas.entities.Usuario;
import br.com.projetocontas.repositories.UsuarioRepository;

@Controller 
public class CriarUsuarioController { 
	
	@RequestMapping(value = "/criar-usuario") 
	public ModelAndView criarUsuario() { 
		ModelAndView modelAndView = new ModelAndView("criar-usuario"); 
	return modelAndView; 
	} 
	
	
	// Método para receber o SUBMIT POST do usuário
	@RequestMapping(value = "/criar-usuario-post", method = RequestMethod.POST) 
	public ModelAndView criarUsuarioPost(HttpServletRequest request) { 
		ModelAndView modelAndView = new ModelAndView("criar-usuario"); 
		
		try {
			Usuario usuario = new Usuario();
			usuario.setNome(request.getParameter("nome"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setSenha(request.getParameter("senha"));
			
			//gravar no banco de dados
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			usuarioRepository.create(usuario);
			
			//enviando mensagem de sucesso para a página
			modelAndView.addObject("mensagem_sucesso", "Usuário cadastrado com sucesso!");
			
		} catch (Exception e) {
			//enviando mensagem de erro para a página 
			modelAndView.addObject("mensagem_erro", e.getMessage());

		}
		
	return modelAndView; 
	} 
	
}