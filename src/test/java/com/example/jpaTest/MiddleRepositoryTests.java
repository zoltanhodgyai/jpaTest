package com.example.jpaTest;

import com.example.jpaTest.model.Left;
import com.example.jpaTest.model.Middle;
import com.example.jpaTest.model.Right;
import com.example.jpaTest.repository.LeftRepository;
import com.example.jpaTest.repository.MiddleRepository;
import com.example.jpaTest.repository.RightRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiddleRepositoryTests {

    private static final String NAME = "String";

    @Autowired
    private LeftRepository leftRepository;

    @Autowired
    private RightRepository rightRepository;

    @Autowired
    private MiddleRepository middleRepository;

    @Test
    public void testCreateMiddle() {

        Left left = new Left();
        left.setName(NAME);
        Left createdLeft = leftRepository.save(left);

        Right right = new Right();
        right.setName(NAME);
        Right createdRight = rightRepository.save(right);

        Middle middle = new Middle();
        middle.setLeftS(createdLeft);
        middle.setRightS(createdRight);
        middle.setName(NAME);

        Middle created = middleRepository.save(middle);

        Assert.assertNotNull(created);
        Assert.assertNotNull(created.getId());
        Assert.assertEquals(createdLeft.getId(), created.getLeftS().getId());
        Assert.assertEquals(createdRight.getId(), created.getRightS().getId());
    }
}
