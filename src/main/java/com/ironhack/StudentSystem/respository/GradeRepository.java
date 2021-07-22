package com.ironhack.StudentSystem.respository;

import com.ironhack.StudentSystem.dao.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade,Integer >{

    @Query("SELECT sectionId, AVG(score) from Grade GROUP BY sectionId ORDER BY AVG(score) ASC ")
    List<Object[]> findAverageScoreBySection();

    // Find all the students with an average score lower than value passed as parameter

    @Query("Select studentName, AVG(score) FROM Grade GROUP BY studentName HAVING AVG(score) < :score")
    List<Object[]> findAverageScoreLowerThan(@Param("score") double score);

    // Find all the students with an average score having atleast a minimum quantity of students enrolled

    @Query("SELECT sectionId, AVG(score), COUNT(*) FROM Grade GROUP BY sectionId HAVING COUNT(*) >= :minEnrolled ORDER BY AVG(score)" )
    List<Object[]> findAverageScoreBySectionWithCapacity(@Param("minEnrolled") long minEnrolled);

}
