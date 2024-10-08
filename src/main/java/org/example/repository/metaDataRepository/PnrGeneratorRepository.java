package org.example.repository.metaDataRepository;

import jakarta.transaction.Transactional;
import org.example.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PnrGeneratorRepository extends JpaRepository<Ticket, Integer> {

    @Transactional
    @Query(value = "SELECT pnrNo FROM pnr_generator_table", nativeQuery = true)
    int getValue();

    @Transactional
    @Modifying
    @Query(value = "DROP TABLE IF EXISTS pnr_generator_table", nativeQuery = true)
    void dropTable();

    @Transactional
    @Modifying
    @Query(value = "CREATE TABLE pnr_generator_table (pnrNo INT PRIMARY KEY)", nativeQuery = true)
    void createTable();

    @Transactional
    @Modifying
    @Query(value = "UPDATE pnr_generator_table SET pnrNo = 1", nativeQuery = true)
    void insertInitialValue();

    @Transactional
    @Modifying
    @Query(value = "UPDATE pnr_generator_table SET pnrNo = pnrNo + 1;", nativeQuery = true)
    void updateTable();

}
