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
    void constructorNameOk() throws Exception {
        Person pers = new Person("Ana", 22, "Female");
        assertEquals(pers.name(), "Ana", "Bad name");
    }

    @Test
    void constructorAgeOk() throws Exception {
        Person p = new Person("Ana", 22, "Female");
        assertEquals(p.age(), 22, "Bad age");
    }

    @Test
    void constructorGenderOk() throws Exception {
        Person p = new Person("Ana", 21, "Female");
        assertEquals(p.gender(), "Female", "Bad gender");

        Person p2 = new Person("Eduardo", 21, "Male");
        assertEquals(p2.gender(), "Male", "Bad gender");
    }

    @Test
    void throwExceptionBadName() {
        assertThrows(Exception.class, () -> new Person(null, 7, "Female"), "Correct name");
    }

    @Test
    void throwExceptionBadAge() {
        assertThrows(Exception.class, () -> new Person("Jose", -7, "Male"), "Correct age");
    }

    @Test
    void throwExceptionBadGender() {
        assertThrows(Exception.class, () -> new Person("Antonio", 59, "Fem"), "Correct gender");
        assertThrows(Exception.class, () -> new Person("Antonio", 59, null), "Correct gender");
    }

    @Test
    void averageAgeFemales0Because0Females() throws Exception {
        List<Person> onlyFemales = new ArrayList<>();
        onlyFemales.add(new Person("Ana", 22, "Female"));
        onlyFemales.add(new Person("Pepa", 46, "Female"));

        double[] meanFemales = Person.averageAgePerGender(onlyFemales);

        assertEquals(0, meanFemales[0]);
        assertEquals(34, meanFemales[1]);
    }
    @Test
    void averageAgeMales0Because0Males() throws Exception{
        List<Person> onlyMales = new ArrayList<>();
        onlyMales.add(new Person("Jose",40,"Male"));
        onlyMales.add(new Person("Luis",50,"Male"));
        double[] meanMales = Person.averageAgePerGender(onlyMales);

        assertEquals(0,meanMales[1]);
        assertEquals(45,meanMales[0]);
    }

    @Test
    void averageFunctionExc() {
        assertThrows(Exception.class,()-> Person.averageAgePerGender(null));
    }

    @Test
    void averageAgePerGenderShouldGiveAnEmptyValue() {
        List<Person> emptyList = new ArrayList<>();
        double[] emptyMean = Person.averageAgePerGender(emptyList);

        assertEquals(0,emptyMean[0]);
        assertEquals(0,emptyMean[1]);
    }
}