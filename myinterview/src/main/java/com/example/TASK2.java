package com.example;

import com.example.model.ElementTask2;

import java.util.ArrayList;
import java.util.List;

/**
 * Task here is to write a list. Each element must know the element before and
 * after it. Print out your list and them remove the element in the middle of
 * the list. Print out again.
 *
 */


public class TASK2 {
    public static void main(String[] args) {

        List<ElementTask2> linkedList = new ArrayList<>();
        linkedList.add( new ElementTask2(0, 78, 10, null));
        linkedList.add( new ElementTask2(1, 10, 42, 78));
        linkedList.add( new ElementTask2(2, 42, 38, 10));
        linkedList.add( new ElementTask2(3, 38, 93, 42));
        linkedList.add( new ElementTask2(4, 93, null, 38));

        System.out.println("Original List: ");
        printList(linkedList);

        linkedList = removeMiddleElement(linkedList);

        System.out.println("List after removing middle element: ");
        printList(linkedList);
    }

    private static void printList(List<ElementTask2> list) {
        for(ElementTask2 element : list) {
            System.out.println("Value: " + element.getValue() + ", Next value: " + element.getNext() + ", Previous value: " + element.getPrevious());
        }
        System.out.println();
    }

    private static List<ElementTask2> removeMiddleElement(List<ElementTask2> list) {
        int indexMiddle = identifyIndexMiddle(list);

        setNextValueAndPrevious(list, indexMiddle);

        List<ElementTask2> newList = new ArrayList<>();
        updateList(list, indexMiddle, newList);
        return newList;
    }

    private static void updateList(List<ElementTask2> list, int indexMiddle, List<ElementTask2> newList) {
        for(ElementTask2 element : list) {
            if (element.getIndex() > indexMiddle) {
                element.setIndex(element.getIndex() - 1);
                element.setNext(list.get(element.getIndex() + 1).getNext());
                element.setPrevious(list.get(element.getIndex() + 1).getPrevious());
                newList.add(element);
            } else if (element.getIndex() != indexMiddle) {
                newList.add(element);
            }
        }
    }

    private static int identifyIndexMiddle(List<ElementTask2> list) {
        int indexMiddle = -1;
        if (list.size() % 2 == 0) {
            indexMiddle += list.size() / 2;
        } else {
            indexMiddle += list.size() / 2 + 1;
        }
        return indexMiddle;
    }

    private static void setNextValueAndPrevious(List<ElementTask2> list, int indexMiddle) {
        list.get(indexMiddle - 1).setNext(list.get(indexMiddle).getNext());
        list.get(indexMiddle + 1).setPrevious(list.get(indexMiddle).getPrevious());
    }

}