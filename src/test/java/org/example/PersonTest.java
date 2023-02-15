package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.example.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ana Bejarano Ramet
 */

class PersonTest {
    @Test
    void constructorNameIsRight() throws Exception {
        Person pers = new Person("Ana", 22, "Female");
        assertEquals(pers.name(), "Ana", "Bad name");
    }

    @Test
    void constructorAgeIsRight() throws Exception {
        Person p = new Person("Ana", 22, "Female");
        assertEquals(p.age(), 22, "Bad age");
    }

    @Test
    void constructorGenderIsRight() throws Exception {
        Person p = new Person("Ana", 21, "Female");
        assertEquals(p.gender(), "Female", "Bad gender");

        Person p2 = new Person("Eduardo", 21, "Male");
        assertEquals(p2.gender(), "Male", "Bad gender");
    }

    @Test
    void badArgumentInConstructorName() {
        assertThrows(Exception.class, () -> new Person(null, 7, "Female"), "Correct name");
    }

    @Test
    void badArgumentInConstructorAge() {
        assertThrows(Exception.class, () -> new Person("Jose", -7, "Male"), "Correct age");
    }

    @Test
    void badArgumentInConstructorGender() {
        assertThrows(Exception.class, () -> new Person("Antonio", 59, "Fem"), "Correct gender");
        assertThrows(Exception.class, () -> new Person("Antonio", 59, null), "Correct gender");
    }

    @Test
    void averageAgePerGenderOnlyFemales() throws Exception {
        List<Person> onlyFemales = new ArrayList<>();
        onlyFemales.add(new Person("Ana", 22, "Female"));
        onlyFemales.add(new Person("Pepa", 46, "Female"));

        double[] meanFemales = Person.averageAgePerGender(onlyFemales);

        assertEquals(0, meanFemales[0]);
        assertEquals(24, meanFemales[1]);
    }
    @Test
    void averageAgePerGenderOnlyMales() throws Exception{
        List<Person> onlyMales = new ArrayList<>();
        onlyMales.add(new Person("Jose",40,"Male"));
        onlyMales.add(new Person("Luis",50,"Male"));
        double[] meanMales = Person.averageAgePerGender(onlyMales);

        assertEquals(0,meanMales[1]);
        assertEquals(40,meanMales[0]);
    }

    @Test
    void averageAgePerGenderShouldThrowAnException() {
        assertThrows(Exception.class,()-> Person.averageAgePerGender(null));
    }

    @Test
    void averageAgePerGenderShouldGiveAnEmptyValue() {
        List<Person> emptyList = new ArrayList<>();
        double[] emptyMean = Person.averageAgePerGender(emptyList);

        assertEquals(0,emptyMean[0],"Males are not empty!");
        assertEquals(0,emptyMean[1],"Females are not empty!");
    }
}