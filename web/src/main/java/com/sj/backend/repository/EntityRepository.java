package com.sj.backend.repository;

import com.sj.backend.entity.Entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sanjay Jaiswar on 7/23/19
 */
@Repository
public interface EntityRepository extends CrudRepository<Entity, Integer> {
    List<Entity> findAll();
}