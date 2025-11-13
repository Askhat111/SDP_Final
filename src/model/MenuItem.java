package model;

import visitor.Visitor;

public interface MenuItem {
    String getName();
    double getBasePrice();
    String getDescription();
    void accept(Visitor visitor);
}