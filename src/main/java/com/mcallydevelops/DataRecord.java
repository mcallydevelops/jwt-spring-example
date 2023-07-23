package com.mcallydevelops;

import java.util.UUID;

public class DataRecord {
    protected final UUID id;

    public DataRecord(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
