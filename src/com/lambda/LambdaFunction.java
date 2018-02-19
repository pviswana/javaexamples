package com.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaFunction {
    public static void main(String[] args) {
        System.out.println("Running Lambda Example!");
        LambdaFunction lambdaFunction = new LambdaFunction();
        List<Person> roster = lambdaFunction.createRoster();

        printPersonsOlderThan(roster, 22);
        printPersonsWithinAgeRange(roster, 22, 24);
        printPersons(roster, new CheckPersonEligibleForSelectiveService());
        printPersons(roster,
                new CheckPerson() {
                    @Override
                    public boolean test(Person p) {
                        return p.gender == Person.Sex.MALE &&
                                p.getAge() >= 22 &&
                                p.getAge() <= 25;
                    }
                });
        printPersonsWithPredicate(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );
        processPersons(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.printPerson()
        );

        processPersons(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.printPerson()
        );

        processPersonsWithFunction(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getName(),
                email -> System.out.println(email)
        );

        processElements(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getName(),
                email -> System.out.println(email)
        );

        log("\nprintPersonsUsingStream:");
        roster
                .stream()
                .filter(person -> person.getGender() == Person.Sex.MALE
                                    && person.getAge() >= 18
                                    && person.getAge() <= 25)
                .map(person -> person.getName())
                .forEach(name -> System.out.println(name));

        Calculator.IntegerMath addition = (a, b) -> {
            return a + b;
        };
        Calculator.IntegerMath subtraction = (a, b) -> a - b;
        Calculator c = new Calculator();
        log("Addition Value: " + c.binaryOperation(5, 3, addition));
        log("Subtraction Value: " + c.binaryOperation(5, 3, subtraction));
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        log("\nprintPersonsOlderThan:" + age);
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        log("\nprintPersonsWithinAgeRange:" + low + "-" + high);
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(
            List<Person> roster, CheckPerson tester) {
        log("\nprintPersons:");
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithPredicate(
            List<Person> roster, Predicate<Person> tester) {
        log("\nprintPersonsWithPredicate:");
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void processPersons(
            List<Person> roster,
            Predicate<Person> tester,
            Consumer<Person> block) {
        log("\nprocessPersons:");
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void processPersonsWithFunction(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        log("\nprocessPersonsWithFunction:");
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function <X, Y> mapper,
            Consumer<Y> block) {
        log("\nprocessElements:");
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public List<Person> createRoster() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Person1", 21, Person.Sex.MALE));
        persons.add(new Person("Person2", 22, Person.Sex.MALE));
        persons.add(new Person("Person3", 23, Person.Sex.MALE));
        persons.add(new Person("Person4", 24, Person.Sex.MALE));
        return persons;
    }

    public static void log(String logData) {
        System.out.println(logData);
    }
}

interface CheckPerson {
    boolean test(Person p);
}

class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person p) {
        return p.gender == Person.Sex.MALE &&
                p.getAge() >= 22 &&
                p.getAge() <= 25;
    }
}

class Person {
    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    int age;

    Person(String name, int age, Sex gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printPerson() {
        System.out.println("Name:" + name + "; Age:" + age);
    }
}

class Calculator {
    interface IntegerMath {
        int operation(int a, int b);
    }

    public int binaryOperation(int a, int b, IntegerMath integerMath) {
        return integerMath.operation(a, b);
    }
}