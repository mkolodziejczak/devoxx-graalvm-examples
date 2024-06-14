package com.devoxx.graalvm.graalvmmemoryfootprint.repository;

import com.devoxx.graalvm.graalvmmemoryfootprint.repository.entity.TaxCalculationResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxCalculationResultRepository extends JpaRepository<TaxCalculationResultEntity, Long> {

}
