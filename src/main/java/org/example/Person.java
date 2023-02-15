package org.example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class representing a person with a name, age and gender.
 *
 * @author Ana Bejarano Ramet
 */
public class Person {
    private final String name;
    private final int age;
    private final String gender; //Male, Female

    /**
     * Construct a person with a name, age and gender
     *
     * @param name   the name of the person
     * @param age    the age of the person
     * @param gender the gender of the person
     */
    public Person(String name, int age, String gender) throws Exception {
        if (name == null || age < 0 || gender == null || (!gender.equals("Male") && !gender.equals("Female"))){
            throw new Exception("Bad arguments");
        }

        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public String gender() {
        return gender;
    }

    /**
     * Computes the average age of male and female persons in a list and returns the result in
     * an array of two elements (the first element is the male mean age and the second one is the
     * female mean age)
     *
     * @param persons a list of people, with different names, ages and genders
     * @return an array with two positions
     */
    public static double[] averageAgePerGender(List<Person> persons) {
        if (persons == null) {
            throw new RuntimeException();
        }

        persons = persons.stream().distinct().collect(Collectors.toList());

        double[] averagePersons = new double[2];

        int mAge = 0, fAge = 0, malePersons = 0, femalePersons = 0;

        for (Person p : persons) {
            if (p.gender.equals("Male")) {
                mAge = mAge + p.age;
                malePersons++;
            } else {
                fAge = fAge + p.age;
                femalePersons++;
            }
        }

        if (malePersons == 0) {
            malePersons = 1;
        }

        if (femalePersons == 0) {
            femalePersons = 1;
        }

        averagePersons[0] = (float)mAge / malePersons;
        averagePersons[1] = (float)fAge / femalePersons;

        return averagePersons;
    }
}