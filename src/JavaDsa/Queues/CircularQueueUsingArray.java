package JavaDsa.Queues;

public class CircularQueueUsingArray {
    static class CircularQueue{
        static int arr[];
        static int size;
        static int front;
        static int rear;

        CircularQueue(int n){
            arr= new int[n];
            front=rear=-1;
            size=n;
        }

        public static boolean isEmpty(){
            return rear==-1 && front==-1;
        }

        public static boolean isFull(){
            return (rear+1)%size == front;
        }

        public static void add(int data){
            if(isFull()){
                System.out.println("Queue already full");
                return;
            }
            if(front==-1){  // adding 1st element
                front=0;
            }
            rear= (rear+1) % size;
            arr[rear]= data;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue already empty");
                return -1;
            }
            int data= arr[front];
            if(front== rear) {
                front = rear = -1;
            } else{
                front= (front+1)% size;
            }
            return data;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue Empty");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args){
        CircularQueue q= new CircularQueue(4);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        System.out.println(q.remove());
        q.add(6);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
