package br.com.iss53.services;

import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.iss53.model.Titulo;

public interface TituloService {
	
	public ModelAndView findAll();
	
	public ModelAndView findOne(@PathVariable("id") final Long id, RedirectAttributes attributes);
	
	public ModelAndView cadastrar();
	
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes);
	
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attributes);
	
}