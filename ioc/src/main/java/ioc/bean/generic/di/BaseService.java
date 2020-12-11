package ioc.bean.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

  private BaseRepository<T> repository;

  @Autowired
  public BaseService(BaseRepository<T> repository) {
    this.repository = repository;
  }

  public void add(){
    System.out.println("add...");
    System.out.println(repository);
  }

}
