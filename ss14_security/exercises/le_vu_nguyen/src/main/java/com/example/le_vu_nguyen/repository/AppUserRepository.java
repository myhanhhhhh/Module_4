package com.example.le_vu_nguyen.repository;

import com.example.le_vu_nguyen.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findAppUserByUserName(String name);
}
