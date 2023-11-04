package ar.edu.ies6.controller;
	

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.ies6.model.alumno;
import ar.edu.ies6.util.ListadoAlumnos;


	@Controller
	public class alumnoController {
		//mostrar el formulario
		
		@GetMapping("/formulario")
		public ModelAndView cargarAlumno() {
		
			alumno alu = new alumno();

			alu.setFechaNacimiento(LocalDate.parse("2000, 2, 18"));
			
			System.out.println("edad: "+ alu.getEdad());
		
			//mandar el objeto a la vista 
        ModelAndView modelView= new ModelAndView ("index");
        
		modelView.addObject ("alumno", alu);
		return modelView;
        }
		// procesar los datos del formulario
		
        @PostMapping("/alumno/submitForm")
        public String procesarFormulario(alumno alumno) {
        // Lógica para procesar el formulario (guardar en la base de datos, etc.)
        return "confirmacion";
        }
    
       @PostMapping("/cargarAlumno")
       public ModelAndView cargarAlumno (@ModelAttribute ("alumno") alumno alumno) {
    	
    	//TODO guardar al alumno en una list
    	ListadoAlumnos.getListado().add(alumno);
    	
        // cargar al alumno al array list
        
        ModelAndView modelView = new ModelAndView("listadoAlumno");
    
     
		//TODO enviar el listado a la tabla
        modelView.addObject("listado",ListadoAlumnos.getListado());
         return modelView;
       }
        		 
	  // metodo para eliminar un registro
       @GetMapping("/eliminarAlumno/{dni}") 
	   public ModelAndView eliminarAlumno(@PathVariable Integer dni) {
    	  // System.out.printlh("aaaaaa");
    	     //eliminarUnProducto (id);
    	   for (int i=0; i<ListadoAlumnos.getListado().size();i++) {
    		   if (ListadoAlumnos.getListado().get(i).getdni().equals(dni));{
    			   ListadoAlumnos.getListado().remove(i);
    		   }
    	   }
    	      ModelAndView modelView = new ModelAndView("listadoAlumnos");
    	   modelView.addObject("listado",ListadoAlumnos.getListado());
    	   
    	   return modelView;
    }
    }
	
	
	


