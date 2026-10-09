## Types of Exceptions

---
### Checked Exceptions

A Checked Exception is a type of exception in programming that is explicitly checked by the compiler during the compilation process. These exceptions are typically errors that a program might encounter during its normal operation, and the compiler forces the programmer to handle these exceptions explicitly in the code.

**Formal Definition**

In languages like Java, Checked Exceptions are exceptions that must be either caught (handled) using a try-catch block or declared in the method signature using the throws keyword. The compiler checks whether the programmer has handled or declared these exceptions, ensuring that the program doesn't ignore potential errors that could occur during runtime.

Checked exceptions typically represent recoverable conditions, such as file I/O errors, database connection issues, or network timeouts. These exceptions must be handled properly to prevent the program from terminating unexpectedly.

**Key Points:**

- **Compiler Enforced Handling:** The compiler requires that the programmer either catch the exception with a try-catch block or declare it in the method signature using the throws keyword.
- **Recoverable Errors:** These exceptions generally occur in conditions that can be recovered from, such as trying to open a file that doesn't exist, or failing to connect to a database. The programmer is expected to handle these scenarios gracefully.
- **Examples in Java:**
  - IOException: Happens during file I/O operations, such as reading or writing a file that may not be accessible.
  - SQLException: Thrown when there’s a problem with the database connection or query execution.

**Example Code**

Here is a simple example that demonstrates a Checked Exception (IOException):

```java
import java.io.*;

class FileReaderExample {
    public void readFile(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);  // This may throw an IOException
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        System.out.println(line);
        bufferedReader.close();
    }

    public static void main(String[] args) {
        FileReaderExample example = new FileReaderExample();
        try {
            example.readFile("somefile.txt"); // Must handle the IOException
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
```

In this example:

- The readFile method declares that it may throw an IOException using the throws keyword.
- The calling code (in the main method) must either handle the exception using a try-catch block or propagate it further.

**Advantages of Checked Exceptions**

- **Prevents Unhandled Errors:** By requiring explicit handling, checked exceptions reduce the likelihood of uncaught exceptions causing the program to crash unexpectedly.
- **Encourages Robust Code:** Programmers are forced to consider error handling, which results in more resilient and fault-tolerant software.

**Disadvantages of Checked Exceptions**

- **Increased Boilerplate Code:** Checked exceptions force developers to write additional try-catch blocks or throws declarations, leading to more code and potential complexity.
- **Overuse Can Lead to Clutter:** Excessive handling of checked exceptions in code can lead to overly verbose or cluttered code, making it harder to maintain and read.

**When to Use Checked Exceptions:**

- **External Resources:** When the program interacts with external resources like files, databases, or networks, where errors are expected and can be handled.
- **Recoverable Conditions:** When the program can recover from the exception by retrying the operation, alerting the user, or attempting alternative methods.
- **Client-Provided Input:** When the client (user or system) provides input, such as file paths, database credentials, or network settings. If invalid input is provided, exceptions can occur, and the program must handle these cases, often by prompting the user for corrections or fallback actions.

---
### Unchecked Exceptions

Unchecked Exceptions are exceptions that the compiler does not require to be explicitly handled or declared in the method signature. These exceptions typically represent programming bugs, such as logic errors or incorrect API usage, and they often cannot be easily recovered from at runtime.

**Formal Definition**

In languages like Java, Unchecked Exceptions are exceptions that do not need to be declared in the throws clause, nor do they require handling using try-catch blocks. They are subclasses of RuntimeException and are usually thrown due to issues in the code that should be fixed by the developer.

Unchecked exceptions are typically used for errors that are beyond the control of the program's flow, such as null pointer references, array index out-of-bounds errors, or invalid type casts. These exceptions often signal that there is a bug in the code that needs to be fixed, rather than something that should be handled by error-handling mechanisms.

**Key Points:**

- **No Compiler Requirement to Handle:** The compiler does not require the programmer to handle unchecked exceptions, so they do not need to be caught or declared in method signatures.
- **Represents Programming Bugs:** These exceptions usually indicate errors in the code, such as logic mistakes or invalid assumptions, that should be fixed rather than handled at runtime.
- **Examples in Java:**
  - NullPointerException: Thrown when trying to use a reference that points to null.
  - ArrayIndexOutOfBoundsException: Thrown when an invalid index is accessed in an array.
  - ClassCastException: Thrown when trying to cast an object to a type it is not an instance of.

---
### Custom Exceptions

Custom Exceptions are user-defined exception classes tailored to your application's specific domain. Rather than relying on generic exceptions (like IOException or NullPointerException), custom exceptions allow you to define more meaningful, application-specific errors that align with your business logic.

**Formal Definition**

In programming, a Custom Exception is a class that extends an existing exception class (often Exception or RuntimeException) to represent a specific error scenario in your application. Custom exceptions allow you to handle domain-specific errors in a structured and meaningful way, making your error handling more expressive and easier to maintain.

Unlike standard exceptions, custom exceptions enable developers to create their own error types that are directly tied to their application’s needs. These exceptions are usually thrown to indicate situations that require special handling or user notification.

**Why Use Custom Exceptions?**

- **Expressive Code:** Custom exceptions allow developers to make their error-handling code more expressive and relevant to the application’s context. Instead of catching general exceptions, you catch exceptions that directly map to your business rules.
- **Maintainable Code:** Custom exceptions make it easier to maintain your code. For example, if a specific domain-related error occurs, you can handle it separately from other types of errors, keeping your error-handling logic clean and organized.
- **Debugging:** Custom exceptions provide meaningful names and messages that make it easier to debug issues related to specific business logic.

**Example Code**

Let’s assume we are building a service in TUF+ that checks whether a user has access to a particular course. If a user doesn’t have the required subscription or access level, we want to throw a custom exception to indicate this clearly.

```java
// Custom Exception
class CustomerNotPlusException extends RuntimeException {
    public CustomerNotPlusException(String userId) {
        super("User " + userId + " is not a plus customer");
    }
}

class CourseService {
    public void accessCourse(String userId) {
        if (!hasAccess(userId)) {
            // Throwing the custom exception if the user doesn't have access
            throw new CustomerNotPlusException(userId);
        }
        // continue enrollment...
    }

    private boolean hasAccess(String userId) {
        // Logic to check if the user is a Plus customer from the database
        return false;  // For the sake of this example, assume the user doesn't have access
    }
}
```

In this example:

- The accessCourse method checks if the user has access to the course using the hasAccess method.
- If the user doesn't have access, a CustomerNotPlusException (Custom Exception) is thrown, and the message includes the userId, indicating the specific user who attempted the access.

**When to Use Custom Exceptions:**

- **To Represent Specific Domain Errors:** When a particular scenario in your application needs to be captured with a unique error message, such as UserNotFoundException or ProductOutOfStockException.
- **To Wrap Lower-Level Exceptions:** When you need to abstract lower-level errors, such as database connection issues, and present them in a more user-friendly way.
- **For Clear Separation of Concerns:** Custom exceptions allow you to separate different types of errors (validation errors, network errors, etc.), making your error handling clearer and more structured.
- **When Building APIs:** Custom exceptions are helpful when building APIs, as they allow you to define specific error codes and messages that clients can handle easily. For instance, an API might return InvalidRequestException when the input request is malformed.