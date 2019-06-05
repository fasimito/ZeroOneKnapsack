package com.fasimito.zoknapsack;

import java.util.ArrayList;
import java.util.List;

public class ZOKnapsack {

    private List<Node> list;

    public void init(List<Node> list){
        this.list = list;
    }

    public int knapsack(int index, int cap){  // start from zero
        if(index<0)
            return 0;
        Node node = list.get(index);
        if(node.getWeight()>cap){
            return knapsack(index-1,cap);
        }else{
            int value1 = knapsack(index-1,cap);
            int value2 = knapsack(index-1,cap-node.getWeight())+node.getValue();
            if(value1>value2)
                return value1;
            else
                return value2;
        }
    }

    public static void main(String[] args){
        ZOKnapsack zoKnapsack = new ZOKnapsack();
        Node node1 = new Node(9,9);
        Node node2 = new Node(6,6);
        Node node3 = new Node(4,4);
        List<Node> ls = new ArrayList<>();
        ls.add(node1);
        ls.add(node2);
        ls.add(node3);
        zoKnapsack.init(ls);
        int result = zoKnapsack.knapsack(2,10);
        System.out.println(result);
    }

}

class Node{
    private int weight;
    private int value;
    public Node(int weight,int value){
        this.weight = weight;
        this.value = value;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
