package com.example.jpaTest;

import com.example.jpaTest.model.Right;
import com.example.jpaTest.repository.RightRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RightRepositoryTests {

    @Autowired
    private RightRepository rightRepository;

    @Test
    public void createReadLeft() {
        Right right = new Right();
        right.setName("Right");

        Right created = rightRepository.save(right);
        Assert.assertNotNull(created);
        Assert.assertNotNull(created.getId());

        Right read = rightRepository.findRightById(created.getId());

        Assert.assertNotNull(read);
        Assert.assertEquals(created.getName(), read.getName());
    }
}
