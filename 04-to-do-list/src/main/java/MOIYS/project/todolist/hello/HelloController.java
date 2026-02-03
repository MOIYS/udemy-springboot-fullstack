package MOIYS.project.todolist.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello! MOIYS";
    }

    @RequestMapping("hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuilder sb = new StringBuilder();

        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> html page </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("html page with body");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    @RequestMapping("hello-jsp")
    public String sayHelloJsp() {
        return "hello";
    }
}