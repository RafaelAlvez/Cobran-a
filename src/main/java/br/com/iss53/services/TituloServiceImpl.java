package br.com.iss53.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.iss53.dto.InterfaceHandler;
import br.com.iss53.model.Titulo;
import br.com.iss53.repository.TitulosRepository;

@Service
public class TituloServiceImpl implements TituloService {

	public static final Logger LOGGER = LoggerFactory.getLogger(TituloService.class);

	@Autowired
	private TitulosRepository titulosRepo;

	@Override
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView(InterfaceHandler.UI_TITULOS);
		List<Titulo> allTitulos = titulosRepo.findAll();
		mv.addObject(InterfaceHandler.OBJECT_TITULOS, allTitulos);
		return mv;
	}

	@Override
	public ModelAndView findOne(final Long id, final RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView(InterfaceHandler.UI_CADASTRO_TITULO);
		Optional<Titulo> titulo = titulosRepo.findById(id);

		if (!titulo.isPresent()) {
			attributes.addFlashAttribute(InterfaceHandler.MSG_WARNING, InterfaceHandler.MSG_TITULO_NAO_ENCONTRADO);
			return new ModelAndView(InterfaceHandler.REDIRECT_TO_TITULOS);
		}

		mv.addObject(InterfaceHandler.OBJECT_TITULO, titulo.get());
		return mv;
	}

	@Override
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView(InterfaceHandler.UI_CADASTRO_TITULO);
		mv.addObject(new Titulo());
		return mv;
	}

	@Override
	public String salvar(Titulo titulo, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return InterfaceHandler.UI_CADASTRO_TITULO;
		}
		try {
			titulosRepo.save(titulo);
			attributes.addFlashAttribute(InterfaceHandler.MSG_SUCCESS, InterfaceHandler.MSG_TITULO_SALVO);
		} catch (DataIntegrityViolationException e) {
			errors.rejectValue("dataDeVencimento", null, "Formato da data inválido");
			return InterfaceHandler.UI_CADASTRO_TITULO;
		}
		
		return InterfaceHandler.REDIRECT_TO_CADASTRO_NOVO_TITULO;
	}

	@Override
	public String excluir(Long id, RedirectAttributes attributes) {
		titulosRepo.deleteById(id);
		attributes.addFlashAttribute(InterfaceHandler.MSG_WARNING, InterfaceHandler.MSG_TITULO_EXCLUIDO);
		return InterfaceHandler.REDIRECT_TO_TITULOS;
	}

}