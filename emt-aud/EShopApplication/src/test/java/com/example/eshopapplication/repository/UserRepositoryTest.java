package com.example.eshopapplication.repository;

import com.example.eshopapplication.model.User;
import com.example.eshopapplication.model.enumerations.Role;
import com.example.eshopapplication.model.exceptions.UserNotFoundException;
import com.example.eshopapplication.model.projections.UserProjection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll() {
        List<User> userList = this.userRepository.findAll();
        Assert.assertEquals(2L, userList.size());
    }

    @Test
    public void testFetchAll() {
        List<User> userList = this.userRepository.fetchAll();
        Assert.assertEquals(2L, userList.size());
    }

    @Test
    public void testLoadAll() {
        List<User> userList = this.userRepository.loadAll();
        Assert.assertEquals(2L, userList.size());
    }

    @Test
    public void testProjectUsernameAndNameAndSurname() {
        UserProjection userProjection = this.userRepository.findByRole(Role.ROLE_USER);
        Assert.assertEquals("user", userProjection.getUsername());
    }

    @Test
    public void testOptimisticLock() {
        User user1 = this.userRepository.findByUsername("user").orElseThrow(() -> new UserNotFoundException("user"));
        User user2 = this.userRepository.findByUsername("user").orElseThrow(() -> new UserNotFoundException("user"));

        user1.setName("user1");
        user2.setName("user2");

        this.userRepository.save(user1);
        this.userRepository.save(user2);

    }
}
