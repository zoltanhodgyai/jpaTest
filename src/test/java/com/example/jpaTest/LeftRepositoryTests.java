package com.example.jpaTest;

import com.example.jpaTest.model.Left;
import com.example.jpaTest.repository.LeftRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeftRepositoryTests {

    @Autowired
    private LeftRepository leftRepository;

    @Test
    public void createReadLeft() {
        Left left = new Left();
        left.setName("Left");

        Left created = leftRepository.save(left);
        Assert.assertNotNull(created);
        Assert.assertNotNull(created.getId());

        Left read = leftRepository.findLeftById(created.getId());

        Assert.assertNotNull(read);
        Assert.assertEquals(created.getName(), read.getName());
    }
}
