package rocketseat.todolist.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rota")
public class AppController {

    /**
     * GET - PEGAR
     * POST - ADD
     * PUT - ALTERAR MAIS DE UMA INFORMAÇÃO 
     * DELETE - DELETA
     * PATCH - ALTERAR SÓ UMA PARTE  
     */

    @GetMapping("/")
    public String mensdagem(){
        return "FUNCIONOU";
    }
}
