public class Tour {

    private class Node {
        private Point p;
        private Node next;

        public Node(Point p) {
            this.p = p;
            // this.next = null;
        }
    }

    static Node head;

    // creates an empty tour````````````````````
    public Tour() {
    }

    // creates the 4-point tour a->b->c->d->a (for debugging)
    public Tour(Point a, Point b, Point c, Point d) {
        Node first = new Node(a);
        Node second = new Node(b);
        Node third = new Node(c);
        Node fourth = new Node(d);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        head = first;
    }

    // returns the number of points in this tour
    public int size() {
        Node temp = head;
        int count = 0;
        if (head != null) {
            do {
                count++;
                temp = temp.next;
            } while (temp != head);
        }
        return count;
    }

    // returns the length of this tour
    public double length() {
        Node temp = head;
        double length = 0.0;
        if (head != null) {
            do {
                length = length + temp.p.distanceTo(temp.next.p);
                temp = temp.next;
            } while (temp != head);
        }
        return length;
    }

    // returns a string representation of this tour
    public String toString() {
        Node temp = head;
        String st = "";
        for (int i = 0; i < size(); i++) {
            st = st + temp.p.toString();
            if (temp.next != null) {
                st = st + "\n";
            }
            temp = temp.next;
        }
        return st;
    }

    // draws this tour to standard drawing
    public void draw() {
        Node temp = head;
        do {
            temp = temp.next;
            temp.p.drawTo(temp.next.p);
        }
        while (temp != head);
    }

    // inserts p using the nearest neighbor heuristic
    public void insertNearest(Point p) {
        if (head == null) {
            head = new Node(p);
            head.next = head;
            return;
        }

        Node temp = head;

        Node newNode = new Node(p);

        Node minNode = head;

        double min = Double.MAX_VALUE;
        do {
            double distance = p.distanceTo(temp.p);
            if (distance < min) {
                min = distance;
                minNode = temp;
            }
            temp = temp.next;
        }
        while (temp != head);
        newNode.next = minNode.next;
        minNode.next = newNode;
    }

    // inserts p using the smallest increase heuristic
    public void insertSmallest(Point p) {
        if (head == null) {
            head = new Node(p);
            head.next = head;
            return;
        }
        Node temp = head;

        Node newNode = new Node(p);

        Node minNode = head;

        double min = Double.MAX_VALUE;
        do {
            double a = temp.p.distanceTo(p);
            double b = p.distanceTo(temp.next.p);
            double c = temp.p.distanceTo(temp.next.p);
            double delta = a + b - c;
            if (delta < min) {
                min = delta;
                minNode = temp;
            }
            temp = temp.next;
        }
        while (temp != head);
        newNode.next = minNode.next;
        minNode.next = newNode;
    }

    // tests this class by calling all constructors and instance methods
    public static void main(String[] args) {
        // define 4 points, corners of a square
        Point a = new Point(1.0, 1.0);
        Point b = new Point(1.0, 4.0);
        Point c = new Point(4.0, 4.0);
        Point d = new Point(4.0, 1.0);

        // create the tour a -> b -> c -> d -> a
        Tour squareTour = new Tour(a, b, c, d);

        // print the size to standard output
        int size = squareTour.size();
        StdOut.println("# of points = " + size);

        // print the tour length to standard output
        double length = squareTour.length();
        StdOut.println("tour length = " + length);

        // print the tour to standard output
        StdOut.println(squareTour);

        StdDraw.setXscale(0, 6);
        StdDraw.setYscale(0, 6);

        squareTour.insertNearest(d);
        squareTour.insertSmallest(d);

        Point e = new Point(5.0, 6.0);
        squareTour.insertSmallest(e);
        squareTour.draw();
    }
}
