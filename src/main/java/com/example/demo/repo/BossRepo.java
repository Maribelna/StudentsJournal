package com.example.demo.repo;

import com.example.demo.entity.Boss;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BossRepo extends JpaRepository<Boss,Long> {
}
