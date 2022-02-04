package ru.geekbrains;

public class HomeWorkApp {
    public static void main(String[] args) {
        OwnLinkedList<Integer> integerOwnLinkedList = new OwnLinkedList<>();
        integerOwnLinkedList.add(150);
        integerOwnLinkedList.add(347);
        integerOwnLinkedList.add(111);
        integerOwnLinkedList.add(789);
        integerOwnLinkedList.add(222);
        integerOwnLinkedList.add(345);

        integerOwnLinkedList.display();
        System.out.println("------------display by index------------");
        integerOwnLinkedList.display(0);
        System.out.println("-----------delete by index-------------");
        integerOwnLinkedList.delete(0);
        integerOwnLinkedList.delete(2);
        integerOwnLinkedList.delete(integerOwnLinkedList.getSize() - 1);
        integerOwnLinkedList.display();
        System.out.println("------------------------");
        integerOwnLinkedList.add(integerOwnLinkedList.getSize(), 345);
        integerOwnLinkedList.add(2, 789);
        integerOwnLinkedList.add(0, 150);

        integerOwnLinkedList.display();
    }
}
