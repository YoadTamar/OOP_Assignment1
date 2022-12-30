
# Object-Oriented Programming assignment 1

### second assignment in "Object-Oriented Programming" course at Ariel University 

## Authors

- [@Yoad Tamar](https://github.com/YoadTamar)
- [@Ron Shuster](https://github.com/shusteron)


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


### ConcreteMember()
Assigns the name of the member, and creates the UbdoableStringBuilder "usb".

### update()
When GroupAdmin object sends an update, it will update `usb` to the GroupAdmin's `UndoableStringBuilder` , and made with a sallow copy.

### toString()
return the name and what `usb` contains.

## 🛠 Skills
Java , Observer design pattern

