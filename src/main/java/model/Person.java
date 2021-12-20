package model;

public class Person implements Tree {
    private String name;
    private long personId;
    private String details;

    public Person(long personId, String name, String details)
    {
        this.personId = personId;
        this.name = name;
        this.details = details;
    }

    @Override
    public void showPersonDetails()
    {
        System.out.println(personId +" " +name+": "+details);
    }
}
