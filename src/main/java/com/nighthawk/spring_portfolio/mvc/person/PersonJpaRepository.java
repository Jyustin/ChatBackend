package com.nighthawk.spring_portfolio.mvc.person;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
Extends the JpaRepository interface from Spring Data JPA.
-- Java Persistent API (JPA) - Hibernate: map, store, update and retrieve database
-- JpaRepository defines standard CRUD methods
-- Via JPA the developer can retrieve database from relational databases to Java objects and vice versa.
 */
public interface PersonJpaRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String email);

    Person findByName(String name);

    List<Person> findAllByOrderByNameAsc();

    // JPA query, findBy does JPA magic with "Name", "Containing", "Or", "Email", "IgnoreCase"
    List<Person> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);

    /* Custom JPA query articles, there are articles that show custom SQL as well
       https://springframework.guru/spring-data-jpa-query/
       https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    */
    Person findByEmailAndPassword(String email, String password);

    // Custom JPA query
    @Query(
            value = "SELECT * FROM Person p WHERE p.name LIKE ?1 or p.email LIKE ?1",
            nativeQuery = true)
    List<Person> findByLikeTermNative(String term);
    /*
      https://www.baeldung.com/spring-data-jpa-query
    */

    List<Person> findTop5ByOrderByCspPointsDesc();

    List<Person> findTop5ByOrderByCsaPointsDesc();

    List<Person> findTop5ByOrderByCyberPointsDesc();


    List<Person> findTop5ByOrderByGamesPlayedDesc();

    List<Person> findTop5ByOrderByKeysCollectedDesc();



    // You can use no query or query

    @Query("SELECT p FROM Person p ORDER BY p.cspPoints DESC")
    List<Person> findTop5ByCspPoints();

    @Query("SELECT p FROM Person p ORDER BY p.csaPoints DESC")
    List<Person> findTop5ByCsaPoints();

    @Query("SELECT p FROM Person p ORDER BY p.cyberPoints DESC")
    List<Person> findTop5ByCyberPoints();


    //!!!!!!!commented for now unless you fix this
    // @Query("SELECT p FROM Person p ORDER BY p.gamesPlayed DESC")
    // List<Person> findByGamesPlayed();

     @Query("SELECT p FROM Person p ORDER BY p.keysCollected DESC")
     List<Person> findByKeysCollected();

     @Query("SELECT p FROM Person p ORDER BY p.gamesPlayed DESC")
     List<Person> findByGamesPlayed();

    // @Query("SELECT p FROM Person p ORDER BY p.keysCollected DESC")
    // List<Person> findByKeysCollected();


    // @Query("SELECT p FROM Person p ORDER BY p.gamesPlayed DESC")
    // List<Person> findByGamesPlayed();

    // @Query("SELECT p FROM Person p ORDER BY p.keysCollected DESC")
    // List<Person> findByKeysCollected();

}




