
# Object-Oriented Programming assignment 1

## Authors

- [@Yoad Tamar](https://github.com/YoadTamar)
- [@Ron Shuster](https://github.com/shusteron)

## General Description
This is the second assignment in "Object-Oriented Programming" course at Ariel University. <br>
We were asked to implement the principles of the Observe design pattern. <br>
In this program we will implement the GroupAdmin class that implements the Sender interface which describes the sender of the updates (Observable).
The GroupAdmin class contains the UndoableStringBuilder class and a members list that should receive updates on any changes.
we also implement the ConcreteMember class that implements the Member interface which describes the recipient of the updates (Observer).
The class contains a copy (copy sallow) of the UndoableStringBuilder repository. 
 


## ConcreteMember
Implements the `Member` interface which describes the recipient of the updates (Observer). <br>
The class contains a copy (sallow copy) of the `UndoableStringBuilder`. 

ConcreteMember has 2 private variables:
-  `String name` 
- `UndoableStringBuilder usb`

  
in addition, has the following methods:
- `ConcreteMember`
- `update`
- `toString`


### ConcreteMember(String name)
Assigns the name of the member, and creates the UbdoableStringBuilder "usb".

### update(UndoableStringBuilder usb)
When GroupAdmin object sends an update, it will update `usb` to the GroupAdmin's `UndoableStringBuilder` , and made with a sallow copy.

### toString()
return the name and what `usb` contains.

## GroupAdmin

implements the `Sender` interface which 
Describes the sender of the updates (Observable). 
It contains the state (`UndoableStringBuilder`) 
and a members who should receive updates on any changes made.


GroupAdmin has 2 private variables: 
- `UndoableStringBuilder usb`
- `List<Member> members`

  
in addition, has the following methods:
- `GroupAdmin`
- `register`
- `unregister`
- `insert`
- `append`
- `delete`
- `undo`
- `notifyObservers`
- `toString`


### GroupAdmin()
Assigns `usb` and creates the ArrayList `members`.

### register(Member obj)
It used to register observers. each member can register only once! (if he didn't unregister). 

### unregister(Member obj)
It used to unregister observers. each member can unregister only if he already register. 

### insert(int offset, String obj)
inserts "obj" string into `usb` from the position "offset". 

### append(String obj)
It use to appends "obj" string to `usb`.

### delete(int start, int end)
It use to delete from `usb` the substring starting at "start" and ending at "end" (not included).

### undo()
Erases the last change done in `usb` and reverts it to the previous state it was at.

### notifyObservers()
notify to each member(Observe), with the `update` method.

### toString()
Returns `members` list; (toString for each member).


## Run The Project And Tests 

#### To open the project:

Clone the project

```bash
  git clone https://github.com/YoadTamar/OOP_Assignment1
```
#### To run the test

Open the project 

open src directory

Open test directory

For test of memory - run the `Tests` class

For test of the classes open observer directory

and choose the class you want to test - ConcreteMember or GroupAdmin.

## Tests

The test made with JUnit 5.
We test two thing - the memory and the correctness of the classes.

We test the memory with `JvmUtilities` and `pom.xml` which implemets the `JOL` interface.

We test the classes `ConcreteMember` and `GroupAdmin` methods.
For each method we create his own test.

#### For example - memory:

![testmemory_photo](https://user-images.githubusercontent.com/119599940/210111443-7bb62884-1cd0-432f-ab3b-3b9f9a05dc52.png)


#### For example - method:

![test_photo](https://user-images.githubusercontent.com/119599940/210111176-5a90fa9a-ef4c-488b-9dfc-a1d4f8470abd.png)

## ???? Skills
Java , Observer design pattern



