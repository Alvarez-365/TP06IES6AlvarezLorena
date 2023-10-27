package ar.edu.ies6.controller;
	import java.time.LocalDate;

import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.alumno;

	@Controller
	public class alumnoController {
		@GetMapping("/alumno/formulario")
		public String mostrarFormulario(Model model) {
			alumno alu = new alumno();
			alu.setFechaNacimiento (LocalDate. of (2000, 2, 18));
			//LocalDate.parse("2008-12-28");
			System.out.println("Edad: "+alu.getEdad());

    
	
	
        model.addAttribute("alumno", new alumno());
        return "formulario";
    }

    @PostMapping("/alumno/submitForm")
    public String procesarFormulario(alumno alumno) {
        // Lógica para procesar el formulario (guardar en la base de datos, etc.)
        return "confirmacion";
    }
    
    @PostMapping("/cargarAlumno")

    public ModelAndView cargarAlumno (@ModelAttribute ("alumno") alumno alumno) {

    ModelAndView modelView = new ModelAndView("listadoAlumnos");
	return modelView; 
    
   
    
	}
    }
	
	
	


