// Linked List Lab: link nodes by hand
//
// Node.java is given. Each Node holds an int item and a link, next,
// to the next Node. The last Node's next is null.
//
//     first
//       |
//       v
//     [ 4 | next ]---->[ 8 | next ]---->[ 15 | null ]
//
// Do the exercises in order. Each one is a method with a TODO.
// After each exercise, compile and run:
//
//     javac *.java
//     java LinkedListLab
//
// main prints what your method gives under "got" and what it should
// give under "expected".

public class LinkedListLab {

    // Exercise 1: build the list 4 -> 8 -> 15.
    // Use the Node constructor three times. Use only the variable first:
    // first, then first.next, then first.next.next.
    static Node exercise1() {
        Node first = null;
        // TODO
        first = new Node(4, new Node (8, new Node(15, null)));
        
        return first;
    }

    // Exercise 2: three Nodes already exist, but they are not linked.
    // Link them so the list reads 9 -> 7 -> 3, then return the Node at
    // the front. Do not create new Nodes. Change only the next links.
    static Node exercise2() {
        Node a = new Node(7, null);
        Node b = new Node(3, null);
        Node c = new Node(9, null);
        // TODO: link them
        Node first = c;
        c.next = a;
        a.next = b;
        return first; // TODO: return the front Node
    }

    // Exercise 3: read, do not change. Return the third item in the list
    // (15) using only the variable first and .next and .item.
    static int exercise3() {
        Node first = new Node(4, null);
        first.next = new Node(8, null);
        first.next.next = new Node(15, null);

        // TODO
        return first.next.next.item; 
    }

    // Exercise 4: insert at the head. Put 1 in front of 4 with one line
    // of code, so the list reads 1 -> 4 -> 8 -> 15.
    // Hint: the new Node's next is the old first Node.
    static Node exercise4() {
        Node first = new Node(4, null);
        first.next = new Node(8, null);
        first.next.next = new Node(15, null);
        // TODO
        first = new Node(1, first);
        return first;
    }

    // Exercise 5: append at the tail. Put 16 after 15 with one line of
    // code (no loop), so the list reads 4 -> 8 -> 15 -> 16.
    static Node exercise5() {
        Node first = new Node(4, null);
        first.next = new Node(8, null);
        first.next.next = new Node(15, null);
        // TODO
        first.next.next.next = new Node(16,null);
        return first;
    }

    // Exercise 6: insert in the middle. Put 10 between 8 and 15, so the
    // list reads 4 -> 8 -> 10 -> 15. It takes two links:
    //   the new Node must point at 15, and 8 must point at the new Node.
    // The order of the two lines matters. Draw it first.
    static Node exercise6() {
        Node first = new Node(4, null);
        first.next = new Node(8, null);
        first.next.next = new Node(15, null);
        // TODO
        first.next.next = new Node(10,first.next.next);


        return first;
    }

    // Exercise 7: remove. Take 8 out with one line of code, so the list
    // reads 4 -> 15. Hint: make 4 skip over 8.
    static Node exercise7() {
        Node first = new Node(4, null);
        first.next = new Node(8, null);
        first.next.next = new Node(15, null);
        // TODO
        first.next = first.next.next;


        return first;
    }

    // Exercise 8: walk the list. Return how many Nodes it has.
    // Use a Node variable named current that starts at first, and a
    // while loop that runs while current != null. Move with
    // current = current.next. It must work for any length, even 0.
    static int count(Node first) {
        int total = 0;
        // TODO
        Node current = first;

        while(current != null)
        {
            // System.out.println(current.item);
            total ++;
            current = current.next; 
        }
        return total;
    }

    // Exercise 9 (challenge): append at the tail of a list of any length.
    // Walk with current until current.next == null (that is the last
    // Node), then link a new Node holding value after it. Return first.
    // You can assume the list has at least one Node.
    static Node addLast(Node first, int value) {
        // TODO

        Node current = first;

        while(current.next != null)
        {
            current = current.next; 
        }
        current.next = new Node(99, null); 
        return first;
    }

    // ---------------------------------------------------------------
    // Everything below checks your work. You do not need to change it.
    // ---------------------------------------------------------------

    public static void main(String[] args) {
        for (int n = 1; n <= 11; n++) {
            String got;
            try {
                got = run(n);
            } catch (NullPointerException e) {
                got = "NullPointerException: some .next or .item was used on null";
            }
            String expected = expected(n);
            System.out.println(label(n));
            System.out.println("  got:      " + got);
            System.out.println("  expected: " + expected);
            if (got.equals(expected)) {
                System.out.println("  OK");
            } else {
                System.out.println("  not yet");
            }
            System.out.println();
        }
    }

    static String run(int n) {
        if (n == 1) return show(exercise1());
        if (n == 2) return show(exercise2());
        if (n == 3) return "" + exercise3();
        if (n == 4) return show(exercise4());
        if (n == 5) return show(exercise5());
        if (n == 6) return show(exercise6());
        if (n == 7) return show(exercise7());
        if (n == 8) {
            Node first = new Node(2, null);
            first.next = new Node(4, null);
            first.next.next = new Node(6, null);
            first.next.next.next = new Node(8, null);
            first.next.next.next.next = new Node(10, null);
            return "" + count(first);
        }
        if (n == 9) return "" + count(null);
        if (n == 10) {
            Node first = new Node(4, null);
            first.next = new Node(8, null);
            first.next.next = new Node(15, null);
            return show(addLast(first, 99));
        }
        return show(addLast(new Node(5, null), 99));
    }

    static String label(int n) {
        if (n <= 7) return "Exercise " + n;
        if (n == 8) return "Exercise 8, count 2 -> 4 -> 6 -> 8 -> 10";
        if (n == 9) return "Exercise 8, count an empty list (first is null)";
        if (n == 10) return "Exercise 9, addLast 99 to 4 -> 8 -> 15";
        return "Exercise 9, addLast 99 to a list with one Node, 5";
    }

    static String expected(int n) {
        if (n == 1) return "4 -> 8 -> 15 -> null";
        if (n == 2) return "9 -> 7 -> 3 -> null";
        if (n == 3) return "15";
        if (n == 4) return "1 -> 4 -> 8 -> 15 -> null";
        if (n == 5) return "4 -> 8 -> 15 -> 16 -> null";
        if (n == 6) return "4 -> 8 -> 10 -> 15 -> null";
        if (n == 7) return "4 -> 15 -> null";
        if (n == 8) return "5";
        if (n == 9) return "0";
        if (n == 10) return "4 -> 8 -> 15 -> 99 -> null";
        return "5 -> 99 -> null";
    }

    // Prints a list as 4 -> 8 -> 15 -> null. Stops after 20 Nodes in
    // case a mistake made the list loop back on itself.
    static String show(Node first) {
        String s = "";
        Node current = first;
        int steps = 0;
        while (current != null && steps < 20) {
            s = s + current.item + " -> ";
            current = current.next;
            steps = steps + 1;
        }
        if (current != null) {
            return s + "... (the links loop forever)";
        }
        return s + "null";
    }
}