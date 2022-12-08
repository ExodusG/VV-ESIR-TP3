# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

En classe nous avons parlé de la règle `closeRessource` qui dit que toutes connexions (fichier, réseau, bdd, ..) doivent être fermées après utilisation.


J'analyse le projet commonsCollection avec la règle `JUnitTestContainsTooManyAsserts` qui dit qu'un test doit avoir qu'un seul assert, ce qui est une bonne pratique. Donc en appliquant :
```
./run.sh pmd -d ../../commons-collections-master -R category/java/bestpractices.xml/JUnitTestContainsTooManyAsserts
```
On obtient de nombreuse sortie :

```
/home/exodus/Documents/esir/vv/tp2/commons-collections-master/src/test/java/org/apache/commons/collections4/AbstractArrayListTest.java:42:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/home/exodus/Documents/esir/vv/tp2/commons-collections-master/src/test/java/org/apache/commons/collections4/AbstractArrayListTest.java:52:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/home/exodus/Documents/esir/vv/tp2/commons-collections-master/src/test/java/org/apache/commons/collections4/AbstractLinkedListTest.java:116:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/home/exodus/Documents/esir/vv/tp2/commons-collections-master/src/test/java/org/apache/commons/collections4/AbstractLinkedListTest.java:134:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/home/exodus/Documents/esir/vv/tp2/commons-collections-master/src/test/java/org/apache/commons/collections4/AbstractLinkedListTest.java:152:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/home/exodus/Documents/esir/vv/tp2/commons-collections-master/src/test/java/org/apache/commons/collections4/AbstractLinkedListTest.java:174:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/home/exodus/Documents/esir/vv/tp2/commons-collections-master/src/test/java/org/apache/commons/collections4/AbstractObjectTest.java:121:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/home/exodus/Documents/esir/vv/tp2/commons-collections-master/src/test/java/org/apache/commons/collections4/AbstractTreeMapTest.java:46:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/home/exodus/Documents/esir/vv/tp2/commons-collections-master/src/test/java/org/apache/commons/collections4/AbstractTreeMapTest.java:54:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
....
```
Regardons le premier cas :

```java
    @Test
    public void testNewArrayList() {
        final ArrayList<E> list = makeObject();
        assertTrue("New list is empty", list.isEmpty());
        assertEquals("New list has size zero", 0, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }
```
Il faudrait ici créer 3 cas de tests différents, un pour chaque assert.

```java

    @Test
    public void testNewArrayList() {
        final ArrayList<E> list = makeObject();
        assertTrue("New list is empty", list.isEmpty());
    }

    @Test
    public void testNewArrayListSize() {
        final ArrayList<E> list = makeObject();
        assertEquals("New list has size zero", 0, list.size());
    }

    @Test
    public void testNewArrayListThrows() {
        final ArrayList<E> list = makeObject();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }
```
