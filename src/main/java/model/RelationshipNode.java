package model;

import java.util.ArrayList;
import java.util.List;

/*
    COMPOSITE

 */
public class RelationshipNode implements Tree
{
    private List<Tree> nodes = new ArrayList<>();

    @Override
    public void showPersonDetails() {
        for(Tree people: nodes)
        {
            people.showPersonDetails();
        }
    }

    public void addPerson(Tree person)
    {
        nodes.add(person);
    }

    public void removePerson(Tree person)
    {
        nodes.remove(person);
    }
}
