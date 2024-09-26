package JavaDsa.Heap;

import java.util.PriorityQueue;

public class PQforObjects {
    static class Student implements Comparable<Student>{  //overriding
        String name;
        int rank;

        public Student(String name, int rank){
            this.name= name;
            this.rank= rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank- s2.rank;  //the one with lower rank has higher priority
            //if it returns negative, then 'this' Student has higher priority
            // if it returns positive, then s2 has higher priority
            // if zero is returned, then Java assumes equal priority
        }
    }
    public static void main(String[] args){
        PriorityQueue<Student> pq= new PriorityQueue<>();   // again write Comparator.reverseOrder to reverse priority

        pq.add(new Student("A", 4));
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 2));
        pq.add(new Student("D", 12));

        while(!pq.isEmpty()){
            System.out.print(pq.peek().name+" ");
            pq.remove();
        }
    }
}
