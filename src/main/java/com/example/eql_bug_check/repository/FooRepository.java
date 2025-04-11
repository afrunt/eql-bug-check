package com.example.eql_bug_check.repository;

import com.example.eql_bug_check.entity.FooEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FooRepository extends JpaRepository<FooEntity, Long> {

    @Query("select f from FooEntity f where upper(f.name) IN :names")
    List<FooEntity> findByNameIn(@Param("names") List<String> names);

    @Query("select f from FooEntity f where f.size IN :sizes AND f.size > 10")
    List<FooEntity> findBySizeIn(@Param("sizes") List<Integer> sizes);

    @Query("select f from FooEntity f where upper(f.name) IN ('Y', 'Basic', 'Remit')")
    List<FooEntity> findByNameInConstantArray();

    @Query("select count(f) from FooEntity f where f.status IN (com.example.eql_bug_check.entity.FooStatus.FOO, com.example.eql_bug_check.entity.FooStatus.BAR)")
    int findCountByStatusIn();
}
