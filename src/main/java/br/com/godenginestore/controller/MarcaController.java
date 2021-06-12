package br.com.godenginestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.godenginestore.model.Marca;
import br.com.godenginestore.services.MarcaService;

@Controller
@RequestMapping(path = "/marca/")
public class MarcaController {
	
	@Autowired
	MarcaService marcaService;
	
	@GetMapping(path = "/")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("marca");
		List<Marca> marcas = marcaService.getTodasAsMarcas();
		model.addObject("marcas", marcas);
		
		return model;
	}
	
	@RequestMapping(path = "/form")
	public ModelAndView marcaForm() {
		ModelAndView model = new ModelAndView("forms/marcaForm");
		model.addObject("marca", new Marca());
		
		return model;
	}
	
	@PostMapping(path = "/cadastrar")
	public ModelAndView cadastrarMarca(Marca marca) {
		marcaService.cadastrarMarca(marca);
		ModelAndView model = new ModelAndView("redirect:/marca/");
		
		return model;
	}
	
}
