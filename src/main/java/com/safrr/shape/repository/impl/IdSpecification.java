package com.safrr.shape.repository.impl;

import com.safrr.shape.entity.Cone;

public class IdSpecification implements Specification {
    private long id;

    public IdSpecification(Long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Cone cone) {
        boolean result = cone.getId() == id;
        return result;
    }
}



