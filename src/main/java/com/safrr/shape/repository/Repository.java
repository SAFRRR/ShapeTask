package com.safrr.shape.repository;

import com.safrr.shape.entity.Cone;

import java.util.Collection;
import java.util.List;
import java.util.logging.LogManager;

public class Repository {
    private final static Logger logger = LogManager.getLogger();
    private List<Cone> cones;
    private final static Repository instance ;

    public static Repository getInstance() {
        if (instance == null) {
            logger.info("creating singleton repository");
            instance = new Repository();
        }
        return instance;
    }

    private Repository() {
        cones = new ArrayList<>();
    }

    public List<Cone> getCones() {
        List<Cone> result = new ArrayList<>(cones);
        return result;
    }

    public boolean add(Cone cone) {
        return cones.add(cone);
    }

    public boolean addAll(Collection<? extends Cone> c) {
        return cones.addAll(c);
    }

    public boolean remove(Cone element) {
        return cones.remove(element);
    }

    public boolean removeAll(Collection<Cone> c) {
        return cones.removeAll(c);
    }

    public Cone get(int index) {
        return cones.get(index);
    }

    public Cone set(int index, Cone element) {
        return cones.set(index, element);
    }

    public List<Cone> query(Specification specification) {
        List<Cone> result = new ArrayList<>();
        for (Cone cone : cones) {
            if (specification.specify(cone)) {
                result.add(cone);
            }
        }
        return result;
    }

    public List<Cone> queryStream(Specification specification) {
        return cones.stream().filter(specification::specify).collect(Collectors.toList());
    }

    public List<Cone> sort(Comparator<? super Cone> comparator) {
        return cones.stream().sorted(comparator).collect(Collectors.toList());
    }
}

