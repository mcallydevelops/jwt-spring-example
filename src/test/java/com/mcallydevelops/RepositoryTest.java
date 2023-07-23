package com.mcallydevelops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    private Repository<DataRecord> repository;

    @BeforeEach
    void setup() {
        repository = new Repository<>();
    }

    @Test
    void save() {
        DataRecord expected = new DataRecord(UUID.randomUUID());
        assertEquals(expected, repository.save(expected));
    }

    @Test
    void find() {
        DataRecord expected = new DataRecord(UUID.randomUUID());
        repository.save(expected);
        assertEquals(expected, repository.find(expected.getId()));
    }

    @Test
    void list() {
        DataRecord expected = new DataRecord(UUID.randomUUID());
        repository.save(expected);
        assertEquals(expected, repository.list().get(0));
    }

    @Test
    void delete() {
        DataRecord item = new DataRecord(UUID.randomUUID());
        repository.save(item);
        repository.delete(item.getId());
        assertEquals(0, repository.list().size());
    }
}