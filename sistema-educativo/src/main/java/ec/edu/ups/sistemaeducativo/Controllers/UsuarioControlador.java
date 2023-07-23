package ec.edu.ups.sistemaeducativo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class UsuarioControlador {
   
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Esta es la vista para mostrar el formulario de inicio de sesión
    }


}
