# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

### Question 1
L'assertion échoue à cause d'un problème de représentation des nombres. En effet, il va y avoir un problème d'arrondi.
Alors que `1.2` donne bien un 1.2, `3* .4` vas donner :`  1.2000000000000002`
La solution est donc de donner une précision dans le test :
```
assertTrue(Math.abs(3 * .4 - 1.2)<0.000001);
```
Ici on veut que cela soit vrai avec une précision de 0.000001.

### Question 2

`assertEquals()` permet de savoir si 2 objets sont égaux. `assertSame()` permet de savoir si les 2 variables pointent vers le même objet.

```java
ArrayList<String> test=new ArrayList<String>();
test.add("test");
ArrayList<String> test2=test;

assertSame(test,test2);
assertEquals(test,test2);
```
Ici les 2 variables pointent vers le même objets, donc asserSame passe car ce sont les mêmes références et assertEquals aussi, car un objets est forcément égal à lui même.

```java
ArrayList<String> test=new ArrayList<String>();
test.add("test");
ArrayList<String> test2=new ArrayList<String>();
test2.add("test");
//assertSame(test,test2);
assertEquals(test,test2);
```
Ici assertSame ne passe pas car ce ne sont pas les mêmes références, assertEquals lui passe car les 2 listes contiennent la même chose.

### Question 3

On peut utiliser `fail()` pour tester des conditions :
```java
@Test
public void test() {
	int random = randomInteger();
	if(random > Integer.MAX_VALUE) {
    	fail("random was to bigger");
	}
	// test
}
```
On peut aussi l'utiliser pour savoir si on est pas passer dans la bonne condition avant le return

```java
@Test
public void test() {
	int index = randomInteger();
	for (int i = 0; i < 2; i++) {
    	if ((i + index) % 3 == 0) {
        	return;
    	}
	}
	fail("Should have returned before");
}
```
On peut aussi l'utiliser si une exception est levé alors que ça devrait pas être le cas
```java
@Test
public void test() {
	try {
    	someMethodToTest();
	} catch (Exception e) {
    	fail("Unexpected exception");
	}
}
```
On peut aussi utiliser la méthode fail dans des lambdas fonctions pour aller plus vite.
### Question 4

Avec Junit5 il est plus facile de contrôler à quel endroit l'exception est levée et donc entre quelle interaction de méthode précisément.
Il est plus simple de tester le message de l'exception.
On peut aussi ajouter du polymorphisme dans l'attente de quelle exception souhaite avoir (par exemple dire qu'on attend Exception(), on peut donc recevoir tout type)
