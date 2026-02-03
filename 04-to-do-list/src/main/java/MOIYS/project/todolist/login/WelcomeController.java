package MOIYS.project.todolist.login;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequiredArgsConstructor
@SessionAttributes("name")
public class WelcomeController {

//    private final AuthenticationService authenticationService;

    @GetMapping("/")
    public String welcomePage(ModelMap model) {
        model.put("name", getLoggedinUsername());
        return "welcome";
    }

    private String getLoggedinUsername() {
        Authentication authentication =
            SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }

//    @PostMapping("login")
//    public String login(@RequestParam String name, @RequestParam String password,
//                        ModelMap model) {
//
//        if(authenticationService.authenticate(name, password)) {
//            model.put("name", name);
//
//            return "welcome";
//        }
//
//        model.put("errorMessage", "Invalid Credentials. Please try again.");
//        return "login";
//    }

    // login => MOIYS.project.to_do_list_web_app.login.LoginController => login.jsp
//    @RequestMapping("login")
//    public String login() {
//        return "login";
//    }

//    private Logger logger = LoggerFactory.getLogger(getClass());

    // http://localhost:8080/login?name=MOIYS
    // Model
//    @RequestMapping("login")
//    public String login(@RequestParam String name, @RequestParam int age, ModelMap model) {
//        logger.debug("Request param is {}", name);
//        logger.info("info level");
//        logger.warn("warn level");
//        model.put("name", name);
//        model.put("age", age);
//
//        return "login";
//    }

}
