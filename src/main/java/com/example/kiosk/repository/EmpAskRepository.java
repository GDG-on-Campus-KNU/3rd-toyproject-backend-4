package com.example.kiosk.repository;

import com.example.kiosk.domain.empAsk.EmpAsk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpAskRepository extends JpaRepository<EmpAsk, Long> {
}
