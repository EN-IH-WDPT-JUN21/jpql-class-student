package com.ironhack.StudentSystem.respository;

import com.ironhack.StudentSystem.dao.Grade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GradeRepositoryTest {

    @Autowired
    private GradeRepository gradeRepository;

    private List<Grade> grades;

    @BeforeEach
    void setUp() {
        grades = gradeRepository.saveAll(List.of(
                new Grade("Maya Charlotte", "CS101-A", 98),
                new Grade("James Fields", "CS101-A", 82),
                new Grade("Michael Alcocer", "CS101-B", 65),
                new Grade("Maya Charlotte", "CS103-A", 89),
                new Grade("Tomas Lacroix", "CS101-A", 99),
                new Grade("Sara Bisat", "CS101-A", 87),
                new Grade("James Fields", "CS101-B", 46),
                new Grade("Helena Sepulvida", "CS103-A", 72)
        ));

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAverageScoreBySection_ValidateSectionAndAVG(){
        List<Object[]> result = gradeRepository.findAverageScoreBySection();
        assertEquals(3, result.size());

        assertEquals(55.5, result.get(0)[1]);
        assertEquals(80.5, result.get(1)[1]);
    }

    @Test
    void findAverageScoreLowerThanParamValue(){
        List<Object[]> avgScore = gradeRepository.findAverageScoreLowerThan(70);
        assertEquals(2, avgScore.size());
        assertEquals("James Fields", avgScore.get(0)[0] );

    }
    @Test
    void findAverageScoreBySectionWithCapacityTest(){
        List<Object[]> capacity = gradeRepository.findAverageScoreBySectionWithCapacity(3);
        assertEquals(1,capacity.size());
    }
}