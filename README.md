⚠️
LinkedList
==========
*   LinkedList’te contigious memory allocation yoktur yani nesneler bitişik bir halde bulunmazlar bunun yerine memory’de ayrı olarak random bir şekilde bulunur ve linkler ile bağlanırlar.

## Singly Linkedlist
![photo1](https://github.com/alpersener/custom-linkedlist-imp/assets/69325145/4b39ade2-1cf0-49a9-8359-b82207c02cf9)

*   Linkedlist arraylist’in aksine value’ları node’lar içerisinde saklar.Her node’un bir sonraki node’a bağlantısı vardır listeye bir value eklemek için yeni bir node’a value eklenir ardından listedeki diğer node’lara bağlanır.

*   Her bir node aslında bir node data structure’dır.Çünkü node oluştururken yeni bir obje yaratıyoruz her biri birer objedir aslında bundan dolayı zaten heap’te tutuluyor.

*   Head ilk nesneyi gösterirken tail ise en sondaki nesneyi gösterir.

*   Insert işlemi o(1) çünkü eklemeye kalktığımızda tek yapmamız gereken linke bağlamak bundan dolayı o(1)

*   Eğer linkedlist’in sonuna eleman eklemek istiyorsak tail.next=Yeni oluşturulan node şeklinde ekleriz ve böylece tail=Yeni oluşturulan node şeklinde eklenir.Ancak tail’i bilmiyorsak en baştan en sona kadar tek tek gezip item=null olduğu yere ekleriz.Tail’i eklemek işimizi kolaylaştırıyor vc o(1) de yapabiliyoruz öbür türlü o(n) sürede ekleme yapıyoruz.

### Insertion in Singly Linkedlist
![photo2](https://github.com/alpersener/custom-linkedlist-imp/assets/69325145/f79e3a5a-82eb-4260-9861-4bcc92bcca77)


*   Tail’i kullanmamızın sebebi bizi o(n) yerine direkt olarak o(1) olarak yapması öbür türlü tüm list’i gezip en sona eklememiz gerekecek ancak tail kullanırsak en sona eleman eklersek o(1)’de bu işi halledebiliriz.
```java
    public void insertFirst(int val){
            Node node=new Node(val);
            node.next=head;
            head=node;
            if (tail == null) {
                tail=head;
            }
            size+=1;
    
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
```

Deletion in Singly LinkedList
-----------------------------
![photo3](https://github.com/alpersener/custom-linkedlist-imp/assets/69325145/1af7b6ca-251b-4f07-b67e-25c91d48b19c)


Display Singly Linkedlist
-------------------------

Head ile tüm list gösterilebilir ancak bu yanlıştır çünkü head değeri her zaman en baştaki item’i göstermelidir.Eğer öyle olmaz ise head değeri en sonda null değeri alacak ve list’in yapısını bozacaktır onun yerine temp adında bir node oluşturup en başta temp=head sonra next diyerek en sondaki elemana kadar gösterilir temp değerinin en sonda null olması list’in yapısını bozmaz bu nedenle temp node oluşturmalıyız.
```
    public void display(){
            Node temp=head;
            while (temp != null) {
                System.out.print(temp.value+"->");
                temp=temp.next;
            }
            System.out.println("END");
        }
```
* * *

## Doubly Linkedlist
![photo4](https://github.com/alpersener/custom-linkedlist-imp/assets/69325145/470c68a6-04be-4d09-9e3e-fe509f1a952e)


### Insertion Doubly Linkedlist
![photo5](https://github.com/alpersener/custom-linkedlist-imp/assets/69325145/3868a3f6-ea71-4258-8d2c-7acc57315c4a)


* * *

## Circular LinkedList
![photo6](https://github.com/alpersener/custom-linkedlist-imp/assets/69325145/0f9bf10a-61e9-4a81-913a-8b53ea11c617)



* Single linkedlist ve doubly linkedlist en sondaeleman kalmayınca null gösterirken circular en sonda null göstermek yerine en baştaki elemanın yerini gösterir.

Insert,Delete,Display In Circular Linkedlist
--------------------------------------------
![photo7](https://github.com/alpersener/custom-linkedlist-imp/assets/69325145/8e14e80d-3b1f-47ed-8ae6-9199ec0dd6d1)

