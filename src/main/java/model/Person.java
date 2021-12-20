/*
    Person is a COMPOSITE class in the composite pattern.

 */
package model;
import java.util.LinkedList;
import java.util.ListIterator;

public class Person implements Component {
    private String name;
    private long personId;
    private String details;
    private LinkedList<Component> partner = new LinkedList<>();
    private LinkedList<Component> parents = new LinkedList<>();
    private LinkedList<Component> children = new LinkedList<>();


    public Person(long personId, String name, String details)
    {
        this.personId = personId;
        this.name = name;
        this.details = details;
    }

    public void setPartner(Person e) {
        e.partner.add(this);
        partner.add(e);
    }

    public void setParent(Person e) {
        e.children.add(this);
        parents.add(e);
    }

    public void addChildren(Person e) {
        e.parents.add(this);
        children.add(e);
    }

    @Override
    public void showPersonPartners(){
        System.out.println(name+" partners are: ");
        ListIterator<Component> listIterator = partner.listIterator( partner.size() );
        while(listIterator.hasPrevious()){
            listIterator.previous().showPersonDetails();
        }
    }

    @Override
    public void showPersonParents(){
        System.out.println(name+" parents are: ");
        ListIterator<Component> listIterator = parents.listIterator( parents.size() );
        while(listIterator.hasPrevious()){
            listIterator.previous().showPersonDetails();
        }
    }

    @Override
    public void showPersonChildren(){
        System.out.println(name+" children are: ");
        ListIterator<Component> listIterator = children.listIterator( children.size() );
        while(listIterator.hasPrevious()){
            listIterator.previous().showPersonDetails();
        }
    }

    @Override
    public LinkedList<Component> getParents(){
        return parents;
    }

    @Override
    public LinkedList<Component> getChildren(){
        return children;
    }

    @Override
    public LinkedList<Component> getSuccessors() {
        LinkedList<Component> successors = this.getChildren();
        int size = successors.size();

        for (int i = 0; i < size; i++) {
            successors.get(i).showPersonDetails();
            if (successors.get(i).getChildren().isEmpty()){
                System.out.print("Has no children. \n");
            } else {
                System.out.print("Has " + successors.get(i).getChildren().size() + " children. \n");
                successors.addAll(successors.get(i).getChildren());
                size = size + successors.get(i).getChildren().size();
            }
        }
        return successors;
    }

    @Override
    public LinkedList<Component> getAncestry() {
        LinkedList<Component> ancestors = this.getParents();
        int size = ancestors.size();

        for (int i = 0; i < size; i++) {
            ancestors.get(i).showPersonDetails();
            if (ancestors.get(i).getParents().isEmpty()){
                System.out.print("Parents unknown. \n");
            } else {
                System.out.print("Number of known parents: " + ancestors.get(i).getParents().size() + ".\n");
                ancestors.addAll(ancestors.get(i).getParents());
                size = size + ancestors.get(i).getParents().size();
            }
        }
        return ancestors;
    }


    @Override
    public void showPersonDetails()
    {
        System.out.println(name+": "+details+" [PersonID:"+personId+"]");
    }

}
