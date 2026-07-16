# 🏏 Cricket Player Stats Management System

A desktop-based **Cricket Player Stats Management System** built using **Java Swing** and **Object-Oriented Programming (OOP)** paradigms. This application allows users to dynamically add, manage, and view different types of cricket players (Batsmen, Bowlers, and Allrounders) along with their performance metrics.

---

## 💡 Core OOP Concepts Demonstrated

* **Abstraction:** Implemented via the `abstract class Player` which defines a template interface (`getStats()`) for all types of players.
* **Inheritance:** Specialized classes (`Batsman`, `Bowler`, and `Allrounder`) inherit common properties (Name, Age, Type) from the parent `Player` class.
* **Polymorphism:** Method overriding of `getStats()` allows the system to output unique statistics dynamically depending on the active player object inside the list.
* **Encapsulation:** Class variables are kept strictly `private` and accessed safely via standard getter and setter methods.

---

## 💻 Tech Stack Used

* **Language:** Java (JDK 8 or above)
* **GUI Framework:** Java Swing (`JFrame`, `JComboBox`, `JTextField`, `JTextArea`)
* **Build Tool:** Maven
