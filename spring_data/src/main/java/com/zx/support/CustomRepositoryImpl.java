package com.zx.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

import static com.zx.specs.CustomerSpecs.*;

/**
 * Created by Credittone on 2017/4/10.
 */
public class CustomRepositoryImpl <T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements CustomRepository<T,ID>{

    private final EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> domainClass,EntityManager entityManager) {
        super(domainClass,entityManager);
        this.entityManager = entityManager;
    }


    public Page<T> findByAuto(T example, Pageable pageable) {
        return findAll(byAuto(entityManager,example),pageable);
    }
}
