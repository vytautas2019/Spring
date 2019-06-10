package lt.codeacademy.cvbuilder.person;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service

public class PersonService {

    public   Person person =new

                Person("","","");

    public Person getPerson() throws NotFoundException {
        if (person==null) {
            throw new NotFoundException(("Person info not found"));
        }

        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public  void updatePerson(Person updatedPerson){
        if(updatedPerson.getFirstName() !=null){
            person.setFirstName(updatedPerson.getFirstName());
        }
        if(updatedPerson.getSecondName() !=null){
            person.setSecondName(updatedPerson.getSecondName());
        }
        if(updatedPerson.getAboutMe() !=null){
            person.setAboutMe(updatedPerson.getSecondName());
        }
    }
}
