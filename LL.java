package Lists.LinkedList;

//Custom Linkedlist
public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size=0;
    }



    public int delete(int index){
        //o(n)
        //index 0 'sa yani tek eleman varsa
        if (index == 0) {
            return deleteFirst();
        }
        //index size-1 ise yani son eleman ise
        if (index == size - 1) {
            return deleteLast();
        }
        Node prev=get(index-1);
        int val=prev.next.value;
        prev.next=prev.next.next;
        return val;
    }

    public int deleteLast(){
        //o(n)
        if(size<=1){
            return deleteFirst();
        }
        Node secondLast=get(size-2);
        int val=tail.value;
        tail=secondLast;
        tail.next=null;
        return val;
    }

    public Node find(int value){
        //O(n)
        Node node =head; //en baştan başlaması için.
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node=node.next;
        }

        return null;
    }



    public Node get(int index){
        Node node =head;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        return node;
    }

    public int  deleteFirst(){
       int val=head.value;
       head=head.next;
        if (head == null) {
            tail=null;
        }
        size--;
        return val;
    }




    public void insert(int val,int index){
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        Node temp=head;
        for (int i = 1; i <index ; i++) {
            temp=temp.next;
        }
        Node node=new Node(val,temp.next);
        temp.next=node;
        size++;
    }

    public void display(){
        //burada tail kullanma derlerse display methodunun aynısı olacak şekilde en sonuna kadar gidip en sona ekleriz.
        Node temp=head;
        while (temp != null) {
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println("END");
    }

    public void insertWithoutTail(int val){
        //o(n)
        Node temp=head;
        Node newnode=new Node(val);
        while (temp.next != null) {
            temp=temp.next;
        }
        temp.next=newnode;
    }


    public void insertLast(int val){
        Node node=new Node(val);
        if (tail == null) {
            insertFirst(val);
            return;
        }
        tail.next=node;
        tail=node;
        size++;
    }



    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;
        if (tail == null) {
            tail=head;
        }
        size+=1;

    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }
}
