import model.Person;
import model.RelationshipNode;

public class HighestTreeCompositeClient
{
    public static void main (String[] args)
    {
        // The Smiths
        Person p1 = new Person(1, "James Smith", "Spouse to Maria, Parent of Robert and John Smith");
        Person p2 = new Person(2, "Maria Smith", "Spouse to James, Parent of Robert and John Smith");
        RelationshipNode relNode1 = new RelationshipNode();
        relNode1.addPerson(p1);
        relNode1.addPerson(p2);

        // They have two children
        Person p3 = new Person(3, "Robert Smith", "Child of James and Maria");
        Person p4 = new Person(3, "John Smith", "Child of James and Maria");
        relNode1.addPerson(p3);
        relNode1.addPerson(p4);

        // Robert Smith is married to Patricia Stooge
        Person p5 = new Person(4, "Patricia Stooge", "Child of Robert and Roberta");
        RelationshipNode relNode2 = new RelationshipNode();
        relNode2.addPerson(p3);
        relNode2.addPerson(p5);


        RelationshipNode theSmiths = new RelationshipNode();
        theSmiths.addPerson(relNode1);
        theSmiths.addPerson(relNode2);
        theSmiths.showPersonDetails();
    }
}