package com.pajeuhub.backend.infra.persistence.sport;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<SportEntity, Long> {}
