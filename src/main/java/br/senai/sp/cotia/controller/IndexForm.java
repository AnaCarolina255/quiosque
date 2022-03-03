package br.senai.sp.cotia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.sp.cotia.dao.ConnectionFactoryForm;

@Controller
public class IndexForm {

	@RequestMapping("indexform")
	public String indexForm() {
		System.out.println("Passou aqui "+ConnectionFactoryForm.conectar());
		return "indexform";
	}
}
