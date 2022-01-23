package Lesson_2.Exercise_one;

public class CustomLinkedListRealization<E> implements CustomLinkedList {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;
    private Node<E> linkFirst;
    private Node<E> linkLast;


    @Override
    public void add(Object elem) {
        if (size == 0) {
            first = new Node(first, elem, last);
            linkFirst(first);
        } else {
            Node<E> nextNode = new Node(first, elem, null);
            last = nextNode;
            first.setNext(last);
            first = nextNode;
            linkLast(last);
        }
        size++;
    }

    @Override
    public void clear() {
        if (size != 0) {
            Node<E> elem = linkFirst;
            Node<E> elem2;
            for (int buff = 0; buff < size; buff++) {
                elem2 = elem.getNext();
                elem.prev = null;
                elem.next = null;
                elem.item = null;
                elem = elem2;
            }
            size = 0;
            linkFirst = null;
            linkLast = null;
            System.out.println("Все элементы успешно удалены");
        } else {
            System.out.println("Нет элементов в коллекции");
        }
    }

    @Override
    public void getSize() {
        System.out.println("На текущий момент создано " + size + " элементов");
    }

    private void linkFirst(Node<E> firstLink) {
        linkFirst = firstLink;
    }

    private void linkLast(Node<E> lastLink) {
        linkLast = lastLink;
    }

    private static class Node<E> {

        private E item;
        private Node<E> next;
        private Node<E> prev;

        private Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        private void setNext(Node<E> next) {
            this.next = next;
        }


        private void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        private Node<E> getPrev() {
            return prev;
        }

        private Node<E> getNext() {
            return next;
        }

        private E getItem() {
            return item;
        }
    }

}
