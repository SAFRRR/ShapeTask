package com.safrr.shape.entity;

import java.util.Map;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Warehouse {
    private final static Logger logger = LogManager.getLogger();
    private static final Warehouse instance = new Warehouse();
    private Map<Long, ConeParameters> map;

    private Warehouse() {
        this.map = new HashMap<>();
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public Optional<ConeParameters> get(Long id) {
        ConeParameters parameters = map.get(id);
        return parameters == null ? Optional.empty() : Optional.of(parameters);
    }

    public ConeParameters put(Long id, ConeParameters value) {
        return map.put(id, value);
    }

    public ConeParameters remove(Long id) {
        return map.remove(id);
    }
}
