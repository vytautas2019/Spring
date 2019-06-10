package lt.codeacademy.cvbuilder.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/person")

public class PersonController {

    @GetMapping(path = "/info")
    public  Person getPersonInfo(){
        return new
                Person("Vytautas","Pavardis","Java developer");

    }
}
