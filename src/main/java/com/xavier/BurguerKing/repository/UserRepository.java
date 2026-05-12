package com.xavier.BurguerKing.repository;


import com.xavier.BurguerKing.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserModel, Long> {
}
