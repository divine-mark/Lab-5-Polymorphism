# Object-Oriented Programming in Java — Lab 5: Polymorphism

**Author:** Divine Mark Makhomeya  
**Registration Number:** H250333E  
**Course:** Object Oriented Programming  


This repository contains my solutions for **Lab 5** of the OOP in Java lab manual.
The lab covers compile-time polymorphism (overloading), run-time polymorphism
(overriding), dynamic method dispatch, upcasting, downcasting with `instanceof`,
and the important distinction that fields and static methods are *not* polymorphic.

## Lab Objectives
- Distinguish compile-time polymorphism (overloading) from run-time polymorphism (overriding).
- Use a superclass reference to hold subclass objects (upcasting) and explain dynamic method dispatch.
- Downcast safely with `instanceof` and pattern matching.
- Write code that works with new subclasses without modification (the open/closed idea).

## Exercises

### Exercise 1: Overloaded `print` Method
- One method name, four overloads: `int`, `double`, `String`, `int[]`.
- Compiler resolves the right version at compile time.

**Expected Output:**
int: 42
double: 3.14
String: Hello
int[]: [1, 2, 3, 4]

### Exercise 2: `Animal`, `Cat`, `Cow`, `Duck`
- `Animal` base class with `sound()` and `name()`.
- Three subclasses each override both methods.
- Stored in an `Animal[]` and iterated with a single loop.

**Expected Output:**
Cat: Meow
Cow: Moo
Duck: Quack
Animal: Some generic animal sound


### Exercise 3: Employee Hierarchy with `Intern`
- Extends Lab 4's hierarchy: `Employee`, `Manager`, `Developer`.
- Adds `Intern` with a fixed stipend instead of a salary.
- Payroll loop is unchanged — demonstrates the open/closed idea.

**Expected Output:**
Kudzai 2000.00
Nyasha 4300.00
Tatenda 3250.00
Chipo 500.00
Total payroll: 10050.00


### Exercise 4: Field vs Method Through a Superclass Reference
- Shows that fields are **hidden**, not overridden.
- Shows that methods **are** overridden.
- Classic demonstration of why fields and static methods are not polymorphic.

**Expected Output:**
Field via Parent ref: Parent field
Method via Parent ref: Child method
Field via Child ref: Child field
Method via Child ref: Child method


### Exercise 5: `PaymentProcessor` — Two Designs

**Design 1: `instanceof` pattern matching**
- Centralised logic that checks the type of each payment object.
- Adding a new payment type requires editing `pay()`.

**Design 2: Polymorphic `process()` method**
- `Payment` interface with a `process()` method.
- Each payment type implements it.
- `pay(Payment p)` calls `p.process()` — no type checks.
- Adding a new type requires only a new class; `pay()` is unchanged.

Both produce the same output:
Charging card 4111-1111-1111-1111
Charging mobile money +263771234567


**Trade-offs discussed in code comments:**
- `instanceof` is fine for small, fixed sets of types.
- Polymorphism is better when the set of types is likely to grow.
- Polymorphism follows the open/closed principle: open for extension, closed for modification.

## Files
- `Printer.java` — Exercise 1
- `AnimalDemo.java` — Exercise 2
- `PayrollDemo.java` — Exercise 3
- `FieldVsMethod.java` — Exercise 4
- `PaymentProcessor.java` — Exercise 5, Design 1
- `PaymentProcessorPolymorphic.java` — Exercise 5, Design 2

