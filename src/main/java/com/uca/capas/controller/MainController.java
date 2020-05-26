package com.uca.capas.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;

@Controller
public class MainController {
	
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping("/index")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping("/saveCate")
	public ModelAndView mostrarCat() {
		ModelAndView mav = new ModelAndView();
		Categoria categoria = new Categoria();
		mav.addObject("categoria", categoria);
		mav.setViewName("saveCat");
		return mav;
	}
	
	
	@RequestMapping("/saveB")
	public ModelAndView mostrarLib() {
		ModelAndView mav = new ModelAndView();
		Libro libro = new Libro();
		List<Categoria> categorias = null;
		try {
			categorias = categoriaService.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		mav.addObject("categorias",categorias);
		mav.addObject("libro", libro);
		mav.setViewName("saveBook");
		return mav;
	}
	
	@RequestMapping("/saveCategory")
	public ModelAndView guardarCat(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			List<Categoria> categorias = null;
			try {
				categorias = categoriaService.findAll();
				} catch (Exception e) {
					e.printStackTrace();
				}
			mav.addObject("categorias", categorias);
			mav.setViewName("saveCat");
		} else {
			categoriaService.save(categoria);
			mav.addObject("verify", "Se ha ingresado con exito");
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/saveBook")
	public ModelAndView guardarLibro(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			List<Categoria> categorias = null;
			try {
				categorias = categoriaService.findAll();
				} catch (Exception e) {
					e.printStackTrace();
				}
			mav.addObject("categorias", categorias);
			mav.setViewName("saveBook");
		} else {
			Date date = new Date();
			libro.setfIngreso(date);
			libroService.save(libro);
			mav.addObject("verify", "Se ha ingresado con exito");
			mav.setViewName("/index");
		}
		return mav;
	}
	
	@RequestMapping("/showBooks")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Libro> libros = null;
		try {
			libros = libroService.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("libros", libros);
		mav.setViewName("lista");
		return mav;
	}
	
	

}
