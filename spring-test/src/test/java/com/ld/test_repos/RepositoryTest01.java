package com.ld.test_repos;

import com.ld.cfg.ReposConfig;
import com.ld.cfg.TestDbConfig;
import com.ld.repos.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;


//@ExtendWith(SpringExtension.class)
////@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {TestDbConfig.class, ReposConfig.class})
@SpringJUnitConfig(classes = {TestDbConfig.class, ReposConfig.class})
public class RepositoryTest01 {

    static final Long PERSON_ID = 1L;

    @Autowired
    UserRepository userRepo;

    @Test
    public void testConnection(){
        assertNotNull(userRepo);
    }

}
