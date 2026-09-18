## Factory Pattern
The Factory Pattern is a creational design pattern that provides an interface for creating objects but allows subclasses to alter the type of objects that will be created.

In simpler terms:
- Rather than calling a constructor directly to create an object, we use a factory method to create that object based on some input or condition.

---

**Real-World Analogy:** Ordering Pizza

Imagine you walk into a pizza shop and say, “I'd like a pizza.” The shop doesn't ask you to go into the kitchen and make it yourself. Instead, it asks, “Which type? Margherita? Pepperoni? Veggie?” Based on your choice, the kitchen (factory) creates the specific pizza for you and hands it over.

You (the client), don't care how it's made or what specific class of ingredients is used. You just want your pizza. The factory (kitchen) handles the creation logic behind the scenes.

This is exactly what the Factory Pattern does in code: it creates an object based on some input without exposing the instantiation logic to the client.

---