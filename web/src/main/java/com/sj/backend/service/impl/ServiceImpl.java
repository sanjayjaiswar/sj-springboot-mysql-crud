package com.sj.backend.service.impl;

import com.sj.backend.data.Request;
import com.sj.backend.entity.Entity;
import com.sj.backend.repository.EntityRepository;
import com.sj.backend.service.Service;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sanjay Jaiswar
 * Date: 6/30/18.
 */
@org.springframework.stereotype.Service
@Slf4j
@Transactional(readOnly = true)
public class ServiceImpl implements Service {

    private EntityRepository entityRepository;

    @Inject
    public ServiceImpl(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public List<Entity> getAllEntities() {
        return entityRepository.findAll();
    }

    @Override
    public Entity getEntity(Integer entityId) {
        return entityRepository.findOne(entityId);
    }

    @Override
    @Transactional(readOnly = false)
    public boolean saveEntity(Request Request) {
        Entity entity = new Entity();

        entity.setEntityId(Request.getEntityId());
        entity.setEntityName(Request.getEntityName());
        entity.setCreatedAt(new Date());
        entity.setModifiedAt(new Date());

        entityRepository.save(entity);

        return true;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean deleteEntity(Integer entityId) {
        entityRepository.delete(entityId);

        return true;
    }

}
