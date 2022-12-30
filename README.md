
# Object-Oriented Programming assignment 1

### second assignment in "Object-Oriented Programming" course at Ariel University 
## Description
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

## Authors

- [@Yoad Tamar](https://github.com/YoadTamar)
- [@Ron Shuster](https://github.com/shusteron)


## 🛠 Skills
Java , Observer design pattern

