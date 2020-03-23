package ru.dankovtsev.agriculture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dankovtsev.agriculture.model.Agriculture;

import java.util.UUID;

@Repository
public interface AgriculureRepository extends JpaRepository<Agriculture, UUID> {
}
