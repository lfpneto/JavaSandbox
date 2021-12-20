import model.Person;

public class Client
{
    public static void main (String[] args)
    {
        // The Smiths are maried
        Person p1 = new Person(1, "James Smith", "Spouse to Maria, Parent of Robert and John Smith");
        Person p2 = new Person(2, "Maria Smith", "Spouse to James, Parent of Robert and John Smith");
        p1.setPartner(p2);
        p1.showPersonPartners();
        p2.showPersonPartners();

        // They have two children
        Person p3 = new Person(3, "Robert Smith", "Child of James and Maria");
        Person p4 = new Person(4, "John Smith", "Child of James and Maria");
        p3.setParent(p1);
        p3.setParent(p2);
        p4.setParent(p1);
        p4.setParent(p2);
        p3.showPersonParents();
        p4.showPersonParents();
        //
        System.out.println("### Let's see how many children does James have.");
        p1.showPersonDetails();
        p1.showPersonChildren();


        // Robert Smith is married to Patricia Stooge
        Person p5 = new Person(5, "Patricia Stooge", "Married to Robert Smith, Child of Robert and Roberta");
        p3.setPartner(p5);
        p5.showPersonPartners();

        // Robert Smith was previously married to Jennifer
        Person p6 = new Person(6, "Jennifer", "Ex-wife of Robert Smith");
        p3.setPartner(p6);
        p3.showPersonPartners();

        // Robert Smith and Jennifer had a son, James Smith
        Person p7 = new Person(7, "James Smith", "Jennifer and Robert Smith and child");
        p7.setParent(p6);
        p7.setParent(p3);
        p3.showPersonChildren();

        // James Smith adopted a child called Vanessa Smith
        Person p8 = new Person(8, "Vanessa Smith", "Orphan, adopted by James Smith");
        p8.setParent(p7);


        //
        System.out.println("### I want to see James Smith, the first (Grandparent), all succession");
        p1.getSuccessors();

        //
        System.out.println("### I want to see James Smith, the second (Grandson), ancestors");
        p7.getAncestry();


    }
}