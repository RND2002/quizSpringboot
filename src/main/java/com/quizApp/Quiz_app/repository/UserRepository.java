package com.quizApp.Quiz_app.repository;

import com.quizApp.Quiz_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


   User findByUserName(String userNamme);
}
