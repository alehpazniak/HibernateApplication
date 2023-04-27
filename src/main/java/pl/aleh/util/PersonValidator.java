package pl.aleh.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.aleh.models.Person;
import pl.aleh.service.PeopleService;

@Component
public class PersonValidator implements Validator {

  private final PeopleService peopleService;

  @Autowired
  public PersonValidator(PeopleService peopleService) {
    this.peopleService = peopleService;
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return Person.class.equals(aClass);
  }

  @Override
  public void validate(Object object, Errors errors) {
    Person person = (Person) object;

    if (peopleService.getPersonByFullName(person.getFullName()).isPresent()) {
      errors.rejectValue("fullName", "", "A person with the same name and surname already exists");
    }
  }

}
