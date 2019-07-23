package com.sj.backend.service;

import com.sj.backend.data.Request;
import com.sj.backend.entity.Entity;

import java.util.List;

/**
 * Created by Sanjay Jaiswar on 7/23/19
 */
public interface Service {
    // Entity operations
    List<Entity> getAllEntities();
    Entity getEntity(Integer entityId);
    boolean saveEntity(Request Request);
    boolean deleteEntity(Integer entityId);

}
