package com.devoxx.jvm.jvmmemoryfootprint.repository;

import com.devoxx.jvm.jvmmemoryfootprint.repository.entity.TaxCalculationResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaxCalculationResultRepository extends JpaRepository<TaxCalculationResultEntity, Long> {

}
