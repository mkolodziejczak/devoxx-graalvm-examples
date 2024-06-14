package com.devoxx.graalvm.graalvmcontainersizeexample.repository;

import com.devoxx.graalvm.graalvmcontainersizeexample.repository.entity.CreditScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditScoreCalculationRepository extends JpaRepository<CreditScoreEntity, Long> {


    public Optional<CreditScoreEntity> findLatestByFirstNameAndLastName(String firstName, String lastName);

}
