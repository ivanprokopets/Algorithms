package com.company;

public class List {
    Value first;

    List() {
        first = null;
    }

    Value add(int x, Value v) {
        Value l;
        if (first == null) {
            l = new Value(x, null);
            first = l;
        } else {
            l = new Value(x, v.next);
            v.next = l;
        }
        return l;
    }

    void delete(int x) {
        Value f = first;
        Value prev = null;
        while (f != null && f.value != x) {
            prev = f;
            f = f.next;
        }
        if (f != null)
            if (prev == null)
                first = f.next;
            else
                prev.next = f.next;
    }

    int searchValue(int x) {
        Value f = first;
        while (f != null && f.value != x)
            f = f.next;
        return f.value;
    }

    int searchValueRecursion(int x) {
        Value f = first;
        if (f != null && f.value != x) {
            f = f.next;
            return f.value + searchValueRecursion(x - 1);
        } else {
            return 0;
        }
    }
}
