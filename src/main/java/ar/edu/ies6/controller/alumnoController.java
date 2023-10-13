package ar.edu.ies6.controller;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.ies6.model.alumno;

	@Controller
	public class alumnoController {

	    @GetMapping("/alumno/formulario")
	    public String mostrarFormulario(Model model) {
	        model.addAttribute("alumno", new alumno());
	        return "formulario";
	    }

	    @PostMapping("/alumno/submitForm")
	    public String procesarFormulario(alumno alumno) {
	        // Lógica para procesar el formulario (guardar en la base de datos, etc.)
	        // Puedes redirigir a una página de confirmación u otra según sea necesario.
	        return "confirmacion";
	    }
	}
	
	
	
	
	
	


