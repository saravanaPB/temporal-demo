package org.example;

public class NameActivityImpl implements NameActivity{
    @Override
    public String composeName(String name) {
        return "Hello " + name;
    }
}
