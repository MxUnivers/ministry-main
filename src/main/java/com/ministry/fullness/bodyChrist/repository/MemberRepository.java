package com.ministry.fullness.bodyChrist.repository;

import com.ministry.fullness.bodyChrist.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Members,Long> {
}
