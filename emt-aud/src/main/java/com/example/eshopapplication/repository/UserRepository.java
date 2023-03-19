package com.example.eshopapplication.repository;

import com.example.eshopapplication.model.User;
import com.example.eshopapplication.model.enumerations.Role;
import com.example.eshopapplication.model.projections.UserProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"carts"})
    @Query("select u from User u")
    List<User> fetchAll();

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"carts", "discount"})
    @Query("select u from User u")
    List<User> loadAll();
    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);

    UserProjection findByRole(Role role);

    @Query("select u.username, u.name, u.surname from User u")
    List<UserProjection> takeUsernameAndNameAndSurnameByProjection();
}
