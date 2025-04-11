package com.example.eql_bug_check;

import com.example.eql_bug_check.repository.FooRepository;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EqlBugCheckApplicationTests {
    @Autowired
    private FooRepository fooRepository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    void contextLoads() {
        entityManagerFactory.createEntityManager().createQuery("select f from FooEntity f where lower(f.name) IN :names")
                .setParameter("names", List.of("foo", "bar"))
                .getResultList();

        entityManagerFactory.createEntityManager().createQuery("select f from FooEntity f where f.size IN :sizes")
                .setParameter("sizes", List.of(1, 2))
                .getResultList();

        entityManagerFactory.createEntityManager().createQuery("select f from FooEntity f where upper(f.name) IN ('Y', 'Basic', 'Remit')")
                .getResultList();

        entityManagerFactory.createEntityManager().createQuery("select count(f) from FooEntity f where f.status IN (com.example.eql_bug_check.entity.FooStatus.FOO, com.example.eql_bug_check.entity.FooStatus.BAR)")
                .getResultList();

        assertNotNull(fooRepository.findByNameIn(List.of("foo", "bar")));
        assertNotNull(fooRepository.findBySizeIn(List.of(1, 2)));
        assertNotNull(fooRepository.findByNameInConstantArray());
        assertEquals(0, fooRepository.findCountByStatusIn());
    }

}
