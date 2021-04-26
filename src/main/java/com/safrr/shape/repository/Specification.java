package com.safrr.shape.repository;

import com.safrr.shape.entity.Cone;

@FunctionalInterface
public interface Specification {
    boolean specify(Cone cone);
}