package com.mcallydevelops;

import java.util.*;

public class Repository<T extends DataRecord> {
    protected final Map<UUID, T> db;

    public Repository() {
        this.db = new HashMap<>();
    }

    public T save(T t) {
        this.db.put(t.id, t);
        return this.db.get(t.id);
    }

    public T find(UUID id) {
        return this.db.get(id);
    }

    public List<T> list() {
        return new ArrayList<>(this.db.values());
    }

    public void delete(UUID id) {
        this.db.remove(id);
    }
}
