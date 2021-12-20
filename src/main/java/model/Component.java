package model;

import java.util.LinkedList;

public interface Component {
    void showPersonDetails();
    void showPersonPartners();
    void showPersonParents();
    void showPersonChildren();
    LinkedList<Component> getParents();
    LinkedList<Component> getChildren();
    LinkedList<Component> getSuccessors();
    LinkedList<Component> getAncestry();

}
