package br.com.intelipost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intelipost.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	UserEntity findByloginAndPassword(String login, String  password);

}
