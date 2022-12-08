# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null`

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point.
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer


### Question 1

Il y a tout d'abord les années bissextiles. On peut donc tester des années qui sont bissextiles (multiple de 4 sans être multiple de 10 OU multiple de 400).

Cela est commun à `isLeapYear()` au constructeur et à `isValidDate`.

Nous avons ensuite les mois avec 30 jours : avril, juin, septembre, novembre.

Le mois de février avec 28 ou 29 jours si c'est une année bissextile.

Les autres mois comportent 31 jours.

Tous ses critères sont communs à `isLeapYear()` au constructeur et à `isValidDate`.
Ils peuvent aussi servir de données pour `previousDate` et `nextDate` .

Pour `compareTo` il faut prévoir des dates qui sont plus grandes que les autres avec notamment les jours égaux ou les mois égaux ou les années. Prévoir le cas où la date est identique.

### Question 2

On obtient alors :

| Coverage | Covered instructions | Missed instruction |
| ------ | ------ | ------ |
| 100% | 382 | 0 |

### Question 3

Il semblerait que le BCC soit satisfait.

### Question 4

| Line Coverage | Mutation coverage | Test Strength |
| ------ | ------ | ------ |
| 100% (58/58) | 99% (98/99) | 99% (98/99) |

Seul le mutant de changement de condition sur `year < 0 return false` reste vivant.
Je ne vois pas le moyen de tuer ce mutant avec un autre test, sachant qu'un test existe pour les années inférieures à 0.
