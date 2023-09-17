package educibertecisaiasgsh.educibertecisaiasgsh.contoller;

import educibertecisaiasgsh.educibertecisaiasgsh.model.PromedioModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class FormimcController {

    @GetMapping("/promedionotas")
    public String index(Model model){
        model.addAttribute("promediomodel",
                new PromedioModel());
        model.addAttribute("verresultado",
                false);
            return "formpromedio";
        }
        @PostMapping("/promedionotas")
    public String calcularpromedio(

            @ModelAttribute("promediomodel")
                PromedioModel promedioModel,
            Model model
            ){
        Double promedio = (promedioModel.getCl1()*0.15)+
                (promedioModel.getCl2()*0.2)+
                (promedioModel.getCl3()*0.35)+
                (promedioModel.getProyectF()*0.3);
        String condicion = (promedio > 10.5) ? "Aprobado" : "Desaprobado";

        model.addAttribute("resultado",
            "El promedio de notas es: " + promedio + " usted se encuentra " + condicion);
        model.addAttribute("verresultado", true);
        model.addAttribute("promediomodel", new PromedioModel());

        return "formpromedio";
    }
}
