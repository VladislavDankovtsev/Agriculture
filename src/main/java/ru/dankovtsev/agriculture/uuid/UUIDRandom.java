package ru.dankovtsev.agriculture.uuid;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDRandom {
    public UUID randomkey() {
        UUID uuid = UUID.randomUUID();
         return uuid;
    }
}
