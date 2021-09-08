package com.ld.test_repos;

import com.ld.cfg.ReposConfig;
import com.ld.cfg.TestDbConfig;
import com.ld.repos.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;


//@ExtendWith(SpringExtension.class)
////@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {TestDbConfig.class, ReposConfig.class})
@SpringJUnitConfig(classes = {TestDbConfig.class, ReposConfig.class})
public class RepositoryTest01 {

    static final Long USER_ID = 1L;

    @Autowired
    UserRepo userRepo;

    @BeforeEach
    public void setUp(){
        assertNotNull(userRepo);
    }

    @Test
    public void testFindByIdPositiv(){
        userRepo.findById(USER_ID).ifPresent(
                user -> Assertions.assertEquals(user.getFirstName(), "Sherlock")
        );
    }

}
