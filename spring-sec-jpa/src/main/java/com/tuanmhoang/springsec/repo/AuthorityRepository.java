package com.tuanmhoang.springsec.repo;

import com.tuanmhoang.springsec.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    Optional<List<Authority>> findAllByUsername(String username);
}
