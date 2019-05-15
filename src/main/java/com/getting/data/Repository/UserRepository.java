package com.getting.data.Repository;

import com.getting.data.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Long> {
    List<Users> findByFirstname(String firstname);
}
