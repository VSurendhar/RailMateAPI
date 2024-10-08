package org.example.repository.metaDataRepository;

import jakarta.transaction.Transactional;
import org.example.model.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IdGeneratorRepository extends JpaRepository<Seat, Integer> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM id_generator_table", nativeQuery = true)
    void deleteIdGeneratorData();

}