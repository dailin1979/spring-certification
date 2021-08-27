package ioc.bean.lifecycle.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonServiceImpl implements PersonService{

}
