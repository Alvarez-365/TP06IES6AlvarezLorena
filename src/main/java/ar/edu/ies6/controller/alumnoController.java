package ar.edu.ies6.controller;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.ies6.model.alumno;
import ar.edu.ies6.service.AlumnoService;
import ar.edu.ies6.util.ListadoAlumnos;


	@Controller
	public class alumnoController {
		@Autowired
		alumno alu;
		@Autowired
		AlumnoService alumnoService;
		
	
		
		//mostrar el formulario
		@GetMapping("/formulario")
		public ModelAndView cargarAlumno() {
		
			//alumno alu = new alumno();

			//alu.setFechaNacimiento(LocalDate.parse("2000, 2, 18"));
			
			//System.out.println("edad: "+ alu.getEdad());
		
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
    	  
    	     //eliminarUnProducto (id);
    	   for (int i=0; i<ListadoAlumnos.getListado().size();i++) {
    		// System.out.printlh("aaaaaa"dni);
    		   if (ListadoAlumnos.getListado().get(i).getdni().equals(dni));{
    			   //ListadoAlumnos.getListado().get(i).setEstado(false);
    			   ListadoAlumnos.getListado().remove(i);
    			   //System.out.printlh{"bbbbbbbb"+ListadoAlumnos.getListado().size()};
    		   }
    	   }
    	      ModelAndView modelView = new ModelAndView("listadoAlumnos");
    	   modelView.addObject("listado",ListadoAlumnos.getListado());
    	   
    	   return modelView;
    }
       //metodo para mostrar listado
       @PostMapping("/mostrarListado")
       public ModelAndView mostrarAlumno() {
    	   
    	   ModelAndView listado = new ModelAndView("listadoAlumnos");
    	    listado.addObject("listado", ListadoAlumnos.getListado());
    	    return listado;
    	}
       //metodo para modificar un registro 
       @GetMapping("/modificarAlumno/{dni}") 
	   public ModelAndView modificarAlumno(@PathVariable Integer dni) throws Exception {
    	   ModelAndView modificarAlumno = new ModelAndView("index");
    	   modificarAlumno.addObject("nuevoAlumno", alumnoService.encontrarUnAlumno(dni));
    	   return modificarAlumno;
       }
       
       @PostMapping("/modificarAlumno")
       public ModelAndView modificarUnAlumno(@ModelAttribute("alumno")alumno alumno) {
    	   ModelAndView modelView = new ModelAndView("listadoAlumno");
    	   
    	   modelView.addObject("listado", alumnoService.buscarTodosAlumnos());
    	   return modelView;
       }
        
	}
	
	
	


