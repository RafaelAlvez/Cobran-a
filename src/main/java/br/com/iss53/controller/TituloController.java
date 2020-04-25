package br.com.iss53.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.iss53.model.StatusTitulo;
import br.com.iss53.model.Titulo;
import br.com.iss53.services.TituloService;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	@Autowired
	private TituloService tituloService;

	@GetMapping()
	public ModelAndView findAll() {
		return tituloService.findAll();
	}

	@GetMapping("/{id}")
	public ModelAndView findOne(@PathVariable("id") final Long id, RedirectAttributes attributes) {
		return tituloService.findOne(id, attributes);
	}

	@GetMapping("/novo")
	public ModelAndView novo() {
		return tituloService.cadastrar();
	}

	@PostMapping()
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {
		return tituloService.salvar(titulo, errors, attributes);
	}
	
	@DeleteMapping("/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attributes) {
		return tituloService.excluir(id, attributes);
	}

	@ModelAttribute("statusTitulo")
	public List<StatusTitulo> statusNovoTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}

}