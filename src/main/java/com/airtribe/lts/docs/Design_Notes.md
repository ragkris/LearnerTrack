# Design Notes

## Why ArrayList instead of an Array?

- ArrayList is used instead of an array because the size of the data is not fixed in advance.  

- Arrays have a fixed size, which means their length cannot be changed once they are created.

- In this application, ArrayList is used to store `Person` objects (Students and Trainers), where the number of elements can grow or shrink dynamically during program execution.

- ArrayList automatically resizes itself and provides useful built-in methods such as `add()`, `remove()`, and `size()`.  
These features make the code simpler, more flexible, and easier to read and maintain.  
Because of this flexibility and ease of use, ArrayList is preferred over arrays in this project.

---

## Usage of Static Members

- Static members were used in utility classes such as `IDGenerator`, `Util`, and `AppMessages`, as well as in service classes implemented using the Singleton pattern.  

- In utility classes, static methods and fields were used because the functionality is shared and does not depend on the state of any object.

- In service classes, static members were used to implement the Singleton pattern, ensuring that only one instance of each service  
(such as `StudentService`, `TrainerService`, `EnrolmentService`, and `CourseService`) exists throughout the application.  

- This provides a single point of access and helps maintain a consistent state while managing shared resources like repositories.

- Using static members in these cases avoids unnecessary object creation, improves memory efficiency, and ensures controlled access to core application services.

---

## Usage of Inheritance
- Inheritance was used by defining `Student` and `Trainer` as subclasses of a base class called `Person`.  

- Common attributes such as `id`, `firstName`, `lastName`, and `email` were placed in the `Person` class to avoid duplication.

- This approach improves code reuse, maintainability, and overall clarity of the design.  

- It also allows role-specific behavior to be added in subclasses while following the object-oriented “is-a” relationship principle.
---