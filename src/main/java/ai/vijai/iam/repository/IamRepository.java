package ai.vijai.iam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ai.vijai.iam.entity.User;

@Repository
public interface IamRepository extends JpaRepository<User, Long>{

	

}
