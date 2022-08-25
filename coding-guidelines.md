# **Java Coding Conventions**

While enjoying programming in Java, it is a good idea to follow some coding style guidelines, in order to make our code cleaner and easier to read for ourselves and our teammates.

Java coding conventions should be used consistently across the whole code base.

**Java Source File**

- Java source file length is less than 2000 lines of code.
- The source file is organized in the following order:
  1. optional documentation comment,
  2. package declaration, followed by
  3. grouped import statements (static imports last),
  4. class documentation comment,
  5. class/interface signature,
  6. static variables in order of visibility (public to private),
  7. instance variables in order of visibility (public to private),
  8. constructor and overloaded constructors in sequential order (constructor with less number of parameters first),
  9. methods in order of visibility (public to private),
  10. getters, setter, equals, hashCode, toString methods at the end.

Here is an example:
```
package com.example.model;

import com.example.util.FileUtil;

/**
 * Implementation-free perspective for a class SomeClass to be read
 * by developers who might not necessarily have the source code at
 * hand
 *
 * @author x,y,z
 * @date
 * @version
 * @copyright
 */

public class SomeClass {

  // Static variables in order of visibility
  public static final Integer PUBLIC_COUNT = 1;
  static final Integer PROTECTED_COUNT = 1;
  private static final Integer PRIVATE_COUNT = 1;

  // Instance variables in order of visibility
  public String name;
  String postalCode;
  private String address;

  // Constructor and overloaded constructors in sequential order
  public SomeClass() {}

  public SomeClass(String name) {
    this.name = name;
  }

  // Methods
  public String doSomethingUseful() {
    return "Something useful";
  }

  // getters, setters, equals, hashCode and toString at the end
}
```
**Naming Conventions**

***General***

Java identifier names are written in camel case. If an identifier consists of a single word, it is written in lowercase. If it consists of multiple words, the first letter of each word is written in upper case and other letters are written in lower case.

In addition to this, there are slight differences if we are naming classes or interfaces, versus methods, variables etc. (see below).

***Packages***

- Write package names in lower case.

  Prefer:`com.somespace`
  
  Avoid:`com.someSpace, com.some_space`

***Classes and Interfaces***

- All class and interface names should be nouns.
- Class and interface names are written in camel case: first letter of each word is upper case, other letters in each word are lower case (`Animal`, `PolarBear`).
- Avoid acronyms and abbreviations in class and interface names.

***Methods***

- A method name should be a verb.
- Method name is written in camel case, similar as for classes and interfaces, but first letter of the method name is lower case (`goToSleep()`).

***Variables***

- A variable name should be meaningful and related to what the variable represents.
- You should avoid single character variable name.
- Keep variable name short, and avoid including metadata.
- Variable names are written in camel case, same as method names (`colorOfFur`).
- Constant variable name is written in upper case, with "_" separating each word in the name (`COUNT`, `IS_MAMMAL`).

  Prefer:
  ```
  int schoolId;
  int[] filteredSchoolIds;
  int[] uniqueSchooldIds;
  Map<Integer, User> usersById;
  String value;
  ```
  Avoid:
  ```
  int schoolIdentificationNumber;// too detailed
  int[] userProvidedSchoolIds; // too detailed
  int[] schoolIdsAfterRemovingDuplicates; // too detailed
  Map<Integer, User> idToUserMap;// too detailed
  String valueString;// too detailed
  int var1; // undescriptive
  ```

**Indentation and Spaces**

- The unit of indentation should be 4 spaces.
- Tab stops should be set every 8 spaces.
- All indentation must be achieved by the space character, and tab characters must not exist in finalized source file.
- Make indentation and spaces usage consistent throughout the code.

To make the code more readable, these are some rules to follow:

- Apply the same indentation to alike items in a vertical list, such as identifiers declaration in a class.
  ```
  public class SomeClass {
    private int number;
    private double bigNumber;
    private String someText;
  }
  ```
- Surround binary operators, including assignments, by spaces.

  Prefer: `a = (b + c) * d;`

  Avoid: `a=(b+c)*d`


- Follow a semicolon, or comma by a space.

  Prefer: `for(int i = 0; i < 10; i++) {}`
  
  Avoid:`for(int i=0;i<10;i++){}`
  
  Prefer: `writeTitle(String text, String font, int size)`
  
  Avoid: `writeTitle(String text,String font,int size)`

- A colon should be surrounded by a space.

  Prefer:
  ```
  case 0 : break;
  case 1 : break;
  ```
  
  Avoid:
  ```
  case 0:break;
  case 1:break;
  ```
- Add a space between a keyword and a succeeding parenthesis.

  Prefer: `while (someCondition){}`
  
  Avoid: `while(someCondition){}`

- Surplus parenthesis can help to highlight the structure of expressions but avoid using too many nested parentheses.
- Insert blank lines to differentiate between the important parts of the code.

**Methods**

***Curly Braces***

Curly braces are used to define the body of a class, interface, method, loop etc.

A curly brace is applied at the end of the line that starts the class, method, loop etc., and the closing brace is on a line by itself, lined up vertically with the start of the first line. No blank lines should be present after the opening brace, or before the closing brace.
```
public class BootcampDemo{

  public String readAThing(){
    // do some reading
  }
  
  public void writeAnotherThing(){
    // do some writing
  }

}
```
***Method Parameters***

Here are some best practices for writing methods.

1. Add double count of spaces for deep indent of method parameters
  ```
  private static synchronized doSomethingBig(int anArg,
    Object anotherArg, String yetAnotherArg,
    Object andStillAnother) {
  
      System.out.println("Start working");
      // do something
    }
  ```
2. Use double indent for method parameters and put each parameter on its own line.
  ```
  private static synchronized doSomethingBig(
      int anArg,
      Object anotherArg,
      String yetAnotherArg,
      Object andStillAnother) {
  
    System.out.println("Start working");
    // do something
  }
  ```
***If Statements***

- When if check body contains only one line of code, avoid omitting curly braces.
  ```
  // avoid 
    
  if (condition)
    statement;
  ```
- Avoid putting if check and the body in the same line of code.
  ```
  if (x < 0) negative(x);
  ```
- Prefer
  ```
  if (condition) {
    statements;
  } else if (condition) {
    statements;
  } else if (condition) {
    statements;
  }
  ```
- Avoid
  ```
  if ((condition1 && condition2)
    || (condition3 && condition4)
      ||!(condition5 && condition6)) { // Bad wraps
      doSomethingAboutIt(); // Make this line easy to miss
  }
  ```
- Prefer
  ```
  if ((condition1 && condition2)
      || (condition3 && condition4)
      ||!(condition5 && condition6)) {
    doSomethingAboutIt();
  }
  ```
***Ternary Operator***

These are preferred practices for writing ternary operator:

```
alpha = (aShortBooleanExpression) ? beta : gamma;
```
or
```
alpha = (aLongBooleanExpression)
   ? beta
   : gamma;
```
***Switch Statement***

- Always have a default case, even without code.
- Use `/* falls through */` to indicate the control falls to the next case.
  ```
  switch (condition) {
    case ABC:
      statements;
      /* falls through */
    case DEF:
      statements;
      break;
    default:
      statements;
      break;
  }
  ```
***Exception Messages***

Here is an example of good and poorly indented messages when throwing an exception.
```
// Avoid - not easy to read
throw new IllegalStateException("Failed to process request" + request.getId()
  + " for user " + user.getId() + " query: '" + query.getText()
  + "'");
```
```
// Prefer - easier to read
throw new IllegalStateException("Failed to process"
  + " request " + request.getId()
  + " for user " + user.getId()
  + " query: '" + query.getText() + "'");
```
***Declarations and Assignments***

- It is recommended to write one declaration per line.
  ```
  // Prefer
  int level; // indentation level
  int sizeMeter; // size of table
  ```
  ```
  // Avoid
  int level, sizeMeter;
  ```
- Include unit in variable name or type
  ```
  long pollIntervalMs;
  int fileSizeGb;
  Amount<Integer, Data> fileSize;
  ```
- Avoid mixing types in variable declaration.
  ```
  int foo, fooarray[];
  ```
- Avoid multiple assignments
  ```
  fooBar.fChar = barFoo.lchar = 'c';
  ```
- Avoid embedded assignments in attempt to increase performance or save a line.
  ```
  d = (a = b + c) + r;
  
  // Prefer this
  a = b + c;
  d = a + r;
  ```
- In array declarations:
  ```
  // Prefer – it is more clear that this is a String array
  String[] args;
  ```
  ```
  // Avoid – easy to confuse String for String array
  String args[];
  ```
- Long values
  ```
  // Prefer - Use "L" instead of "l" for long values
  // to avoid confusion with number 1
  long timeout = 3000000000L;
  ```
  ```
  // Avoid - Hard to tell last letter is l and not 1
  long timeout = 3000000000l;
  ```
- Declare variables et the beginning of the code block.
  ```
  // Prefer – Declare variables at the beginning of the block.
  public void doSomething() {
    int whatIRepresent; // beginning of method block
    if (condition) {
      int someFlag; // beginning of "if" block
      …
    }
  }
  ```
- Avoid local declarations that hide declarations of the higher levels.
```
int count;
...
public void doSomething() {
  if (condition) {
    int count; // AVOID!
    ...
  }
...
}
```
**Comments**

There are 2 types of comments in Java programming: implementation comments and documentation comments. Comments should contain only information that is relevant to reading and understanding the program.

***Implementation Comments***

Implementation comments are delimited by // or /* … */. Implementation comments are used for notes about a particular implementation or for temporarily removing code. Programs can have 4 types of implementation comments: block, single line, trailing and temporarily removing code.

**Block comments** are used to give descriptions of files, methods, algorithms, data structures etc. Bolock comments may be used at the beginning of a file, before beginning of the method, or within the method. A block comment should be indented at the same level as the code it describes, and it should have a blank line before it starts.
```
void doSomething() {
  doSomeStuff();
  // block comment line 1
  // block comment line 2
  // block comment line 3
  doSomeComplicatedStuffThatNeedsAdditionalDescription();
}
```
**Single-line comment** appears on a single line indented at the same level as the code that follows it. If a comment cannot be written in a single line, it should follow the format of a block comment. A single-line comment should be preceded by a blank line unless it comes immediately after the start of a compound statement.
```
a = 10;
b = 20;
// a single-line comment
c = a * b;
```
**Trailing comments** appear on the same line of the code they describe but should be separated from the code at a far-off distance. If more than one short comment appears in a section of related code, they should all be indented to the same tab setting.
```
if (a == 2) {
  b = true; // special case
}
else {
  c = isPrime(x); // works only for odd
}
```
**Temporarily removing code comments** : The // delimiter can comment out a partial or a complete line. It can also be used in multiple lines to comment out entire sections of code. It is important to note that this should only be used temporarily while the code is in active development; the unused code should eventually be physically removed as it can make the source more difficult to maintain.
```
if (a > 1) {
  b = a; // + 1;
  ...
}
else {
  // b = 2;
  ...
}
```
**Documentation Comments**

Documentation comments describe Java classes, interfaces, constructors, methods, and fields. They are delimited by /**…*/. Note the double-asterisk (**) at the beginning of the comment. There is one comment per class, interface, or member. This comment should appear just before the declaration with no space between the comment and the code it refers to.

Documentation comments can be extracted to HTML files using the javadoc tool. Javadoc of class members can be specified on a single line as follows:
```
/** This is a java documentation comment */
private int comments;
```
Documentation comments are meant to describe the specification of the code, from an implementation-free perspective, to be read by developers who might not necessarily have the source code at hand. Java associates documentation comments with the first declaration after the comment. As a result, documentation comments should not be present inside a method or constructor definition block.

**DTOs (Data Transfer Objects)**

DTO objects are used for request/response parts of some transfer process. When creating class that 
serves as DTO class, it should always have `Dto` suffix in its name.

Request DTOs should also contain `Request` suffix. Similarly, Response DTOs should also contain `Response` suffix.

These two combined - DTOs should end with either of `RequestDto` or `ResponseDto`.

**Builder pattern**

Pattern used for creating objects - we won't create objects using their constructors and/or setters - instead, we'll create designated builder classes
that will take care of creating that object for us.

If we create builder class inside of class for which we create builder, builder class **has to be public static class**.

If we create some object using the builder pattern, all constructors used in **builder class have to be private** - this way we prevent
user from using constructor and force him to use the builder.

If we use builder pattern, we can provide access to builder class over static method, like this:
* i.e. we have Article class
* We have ArticleBuilder inside of that class (**public static one**)
* inside od **Article** class, we create `public static ArticleBuilder builder()` method that returns new instance of ArticleBuilder
* **Do not use** `new Article.ArticleBuilder()...` - instead, use `Article.builder()...`


**Response entities - Spring Controller**

Do not use `new ResponseEntity<>.....` - instead, use ResponseEntity builder static methods for building this object.