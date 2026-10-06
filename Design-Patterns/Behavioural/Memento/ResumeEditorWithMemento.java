/**
 The issues in the previous implementation can be effectively solved using the Memento Pattern.
 This pattern enables the originator (the object whose state we want to save) to produce a memento (a snapshot of its internal state), which can then be managed by a caretaker.
 The key advantage is that the object’s internal state is restored without breaking encapsulation, and we can maintain a history of changes.

 The Memento Pattern introduces three components:

     Originator: The object whose state we want to capture and restore. (In this case: ResumeEditor)
     Memento: An immutable object that stores the internal state of the originator.
     Caretaker: The object that holds and manages multiple mementos, enabling undo operations. (In this case: ResumeHistory)

 Here’s the updated code implementing the Memento Pattern:

 */
import java.util.*;

// Originator with Memento inside
class ResumeEditor
{
    private String name;
    private String education;
    private String experience;
    private List<String> skills;

    public void setName(String name) {
        this.name = name;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public void setExperience(String experience) {
        this.experience = experience;
    }
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void printResume()
    {
        System.out.println("x:----- Resume -----");
        System.out.println("Name: " + name);
        System.out.println("Education: " + education);
        System.out.println("Experience: " + experience);
        System.out.println("Skills: " + skills);
        System.out.println("x:------------------");
    }

    // Save the current state as a Memento
    public Memento save()
    {
        return new Memento(name, education, experience, List.copyOf(skills));
    }

    // Restore state from Memento
    public void restore(Memento memento)
    {
        this.name = memento.getName();
        this.education = memento.getEducation();
        this.experience = memento.getExperience();
        this.skills = memento.getSkills();
    }

    /**
     * ++++++++ Inner Memento class ++++++++
     */
    public static class Memento
    {
        private final String name;
        private final String education;
        private final String experience;
        private final List<String> skills;

        private Memento(String name, String education, String experience, List<String> skills)
        {
            this.name = name;
            this.education = education;
            this.experience = experience;
            this.skills = skills;
        }

        private String getName() {
            return name;
        }
        private String getEducation() {
            return education;
        }
        private String getExperience() {
            return experience;
        }
        private List<String> getSkills() {
            return skills;
        }
    }
}

// Caretaker
class ResumeHistory
{
    private Stack<ResumeEditor.Memento> history = new Stack<>();

    public void save(ResumeEditor editor)
    {
        history.push(editor.save());
    }

    public void undo(ResumeEditor editor)
    {
        if (!history.isEmpty())
        {
            editor.restore(history.pop());
        }
    }
}

// Main driver
public class Main
{
    public static void main(String[] args)
    {
        ResumeEditor editor = new ResumeEditor();
        ResumeHistory history = new ResumeHistory();

        editor.setName("Alice");
        editor.setEducation("B.Tech CSE");
        editor.setExperience("Fresher");
        editor.setSkills(Arrays.asList("Java", "DSA"));
        history.save(editor);

        editor.setExperience("SDE Intern at TUF+");
        editor.setSkills(Arrays.asList("Java", "DSA", "LLD", "Spring Boot"));
        history.save(editor);

        editor.printResume(); // Shows updated experience
        System.out.println("");

        history.undo(editor);
        editor.printResume(); // Shows resume after one undo
        System.out.println("");

        history.undo(editor);
        editor.printResume(); // Shows resume after second undo (initial state)
    }
}
/**
 Let's now understand how the Memento pattern solves the previously discussed issues.

    How Memento Pattern Solves The Issues

         Issues	- How Memento Pattern Fixes It

         No Caretaker -	ResumeHistory class manages all snapshots (mementos) and performs undo operations.
         Only one level of undo -	Stack<ResumeEditor.Memento> maintains history of states, enabling multiple undo levels.
         Public fields in snapshot -	Memento fields are private final, ensuring proper encapsulation.
         Tight coupling with ResumeEditor -	Memento acts as a data capsule, hiding internal structure of ResumeEditor.
         Snapshot logic spread outside class -	Snapshot creation/restoration is internal to ResumeEditor, improving cohesion.

 Additionally, the Memento Pattern delegates the responsibility of creating state snapshots to the actual owner of the state, i.e., the originator itself.
 Since the originator has full access to its internal state, it is the most suitable component to generate accurate and complete mementos.
 This maintains encapsulation while still enabling full rollback capabilities.

 */