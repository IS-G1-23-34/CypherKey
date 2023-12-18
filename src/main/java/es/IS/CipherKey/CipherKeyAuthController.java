package es.IS.CipherKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CipherKeyAuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        // Encode the password before saving it to the database
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // You can add more login-related methods as needed

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Verificar si el usuario existe en la base de datos
        User user = userRepository.findById(username).orElse(null);

        if (user != null && user.getPassword().equals(password)) {
            // Si el usuario existe y la contraseña coincide, realiza las acciones adicionales según tus necesidades
            // Obtener el objeto Authentication del contexto de segurida

            // Puedes realizar más acciones según tus necesidades, como guardar registros de inicio de sesión, etc.
            return "redirect:/"; // Redirigir a la página de inicio después del inicio de sesión exitoso
        } else {
            // Si el usuario no existe o la contraseña no coincide, puedes agregar un mensaje de error al modelo
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }
}


