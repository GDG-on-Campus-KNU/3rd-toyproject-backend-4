package com.example.kiosk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.kiosk.domain.option.Option;

public interface OptionRepository extends JpaRepository<Option, Long> {

}
