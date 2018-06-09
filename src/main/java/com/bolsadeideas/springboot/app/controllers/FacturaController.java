package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.Service.IClienteService;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Factura;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {
	
	@Autowired
	private IClienteService clienteService;

	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable("clienteId") long id, Map<String, Object> model, RedirectAttributes flash) {
		Cliente cliente = clienteService.findOne(id);
		if (cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}
		Factura factura = new Factura();
		factura.setCliente(cliente);
		model.put("titulo", "Crear Factura");
		model.put("factura", factura);
		return "factura/form";
	}
}
