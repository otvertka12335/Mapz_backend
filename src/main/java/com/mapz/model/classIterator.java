package com.mapz.model;

import java.util.ArrayList;
import java.util.List;

public class classIterator implements Agregate {

    private List<Hall> halls = new ArrayList<>();

    @Override
    public Iterator getIterator() {
        return new CinemasIterator();
    }

    private class CinemasIterator implements Iterator{

        int index = 0;

        @Override
        public boolean hasNext() {
            if(index < halls.size()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object next() {
            return halls.get(index++);
        }
    }
}
