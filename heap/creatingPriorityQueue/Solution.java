import java.util.*;

class Solution {
    
    public static class Student implements Comparable<Student> {

        String name;
        int roll;

        Student(String name, int roll) {
            this.name = name;
            this.roll = roll;
        }
        public int compareTo(Student s) {
            return this.roll - s.roll;
        }
        
    }
    public static void main(String args[]) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.naturalOrder());

        pq.add(new Student("Sounak", 1));
        pq.add(new Student("Ayan", 5));
        pq.add(new Student("Subrata", 2));


        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name);
            pq.remove();
        }


    }
}