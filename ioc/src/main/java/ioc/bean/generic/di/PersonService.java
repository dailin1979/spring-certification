package ioc.bean.generic.di;

import ioc.bean.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends BaseService<Person> {

  public PersonService(BaseRepository<Person> repository) {
    super(repository);
  }
}
