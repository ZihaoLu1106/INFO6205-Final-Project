
package com.info6205.algorithm;

import java.util.ArrayList;
import java.util.List;

//  iterates each "Cloth" in "Order", and use "TreeToCategorizeCloth" to categorize "Cloth" based on their color and material.
public class TreeToCategorizeCloth {

    private TreeNode<String> root;
    private List<WashingMethod>washingMethods;

    public TreeToCategorizeCloth(){
        root = new TreeNode<>("Clothing Color");
        washingMethods=new ArrayList<>();
        setDefaultTree();
    }

    /*
     * 1.set default washingMethod node
     * 2. create */
    public void setDefaultTree(){
        TreeNode<String> Cotton1 = new TreeNode<>("Cotton");
        TreeNode<String> Denim1 = new TreeNode<>("Denim");
        TreeNode<String> Wool1 = new TreeNode<>("Wool");
        TreeNode<String> Polyester1 = new TreeNode<>("Polyester");

        TreeNode<String> Cotton2 = new TreeNode<>("Cotton");
        TreeNode<String> Denim2 = new TreeNode<>("Denim");
        TreeNode<String> Wool2 = new TreeNode<>("Wool");
        TreeNode<String> Polyester2 = new TreeNode<>("Polyester");

        TreeNode<String> Cotton3 = new TreeNode<>("Cotton");
        TreeNode<String> Denim3 = new TreeNode<>("Denim");
        TreeNode<String> Wool3 = new TreeNode<>("Wool");
        TreeNode<String> Polyester3 = new TreeNode<>("Polyester");

        //TO DO: create 3 colors
        TreeNode<String> darkColor = new TreeNode<>("Dark");
        TreeNode<String> lightColor = new TreeNode<>("Light");
        TreeNode<String> whiteColor = new TreeNode<>("White");
        root.addChildren(darkColor);
        root.addChildren(lightColor);
        root.addChildren(whiteColor);

        darkColor.addChildren(Cotton1);
        darkColor.addChildren(Denim1);
        darkColor.addChildren(Wool1);
        darkColor.addChildren(Polyester1);

        lightColor.addChildren(Cotton2);
        lightColor.addChildren(Denim2);
        lightColor.addChildren(Wool2);
        lightColor.addChildren(Polyester2);

        whiteColor.addChildren(Cotton3);
        whiteColor.addChildren(Denim3);
        whiteColor.addChildren(Wool3);
        whiteColor.addChildren(Polyester3);

        Cotton1.addChildren(new TreeNode<>("Strong"));
        Denim1.addChildren(new TreeNode<>("Light"));
        Wool1.addChildren(new TreeNode<>("Normal"));
        Polyester1.addChildren(new TreeNode<>("Strong"));

        Cotton2.addChildren(new TreeNode<>("Strong"));
        Denim2.addChildren(new TreeNode<>("Light"));
        Wool2.addChildren(new TreeNode<>("Normal"));
        Polyester2.addChildren(new TreeNode<>("Strong"));

        Cotton3.addChildren(new TreeNode<>("Strong"));
        Denim3.addChildren(new TreeNode<>("Light"));
        Wool3.addChildren(new TreeNode<>("Normal"));
        Polyester3.addChildren(new TreeNode<>("Strong"));

        WashingMethod strongWash=new WashingMethod("Strong",3,1);
        WashingMethod lightWash=new WashingMethod("Light",2,2);
        WashingMethod normalWash=new WashingMethod("Normal",2,1);

        washingMethods.add(strongWash);
        washingMethods.add(lightWash);
        washingMethods.add(normalWash);
    }

    /*
     * recieve a cloth and search the wsh method in the tree*/
    public WashingMethod getMethod(Cloth cloth) {
/*        if (currentNode == null) {
            return null;
        }
        if(currentNode.getValue().equals(cloth.getColor()) &&  currentNode.getValue().equals(cloth.getMaterial() + " Material")){
            return new WashingMethod(currentNode.getValue(), 0.0, 0);
        }
        */

        String color=cloth.getColor();
        String material=cloth.getMaterial();
        System.out.println("color: " +color);
        System.out.println("material: " +material);
        //search color;
        TreeNode<String>colorNode = null;
        TreeNode<String>materialNode=null;
        for(TreeInterface<String> node:root.getChildren()){
            System.out.println(node.getValue());
            if(node.getValue().equals(color)) {
                colorNode = (TreeNode) node;
                break;
            }
        }
        for(TreeInterface<String> node:colorNode.getChildren()){
            System.out.println(node.getValue());
            if(node.getValue().equals(material)) {
                materialNode = (TreeNode) node;
                break;
            }
        }
        TreeNode<String>washNode=(TreeNode<String>) materialNode.getChildren().get(0);
        String washMethod=washNode.getValue();

        WashingMethod result=null;

        for(WashingMethod w:washingMethods){
            if(w.getMethodName().equals(washMethod))
                result=w;
        }
        return result;
    }
    public List<PendingClothGroup> manageOrder(Order order){
        //1. for loop the clothes in order and create categorizedCloth for each cloth by TreeToCategorizedCloth
        //2. combine the same cloth
        List<PendingClothGroup>list=new ArrayList<>();

        for(int index=0;index<order.getCurrentSize();index++){
            System.out.println("1");
            WashingMethod washMethod=getMethod(order.getCloths()[index]);
            boolean found=false;
            //check if there is a same wash method in the list
            for(PendingClothGroup group:list){
                if(group.getMethod().getMethodName().equals(washMethod.getMethodName())) {
                    group.getCloths().add(order.getCloths()[index]);
                    found=true;
                }
            }
            //if there no such a wash method in the list, create one;
            if(found==false) {
                PendingClothGroup newGroup = new PendingClothGroup(order.getOrderID(), washMethod);
                newGroup.setPrice(washMethod.getPrice());
                newGroup.setDuration(washMethod.getDuration());
                newGroup.getCloths().add(order.getCloths()[index]);
                newGroup.setStatus("processing");
                list.add(newGroup);
                order.setTotalPrice(order.getTotalPrice()+washMethod.getPrice());
            }
        }
        for(PendingClothGroup g:list){
            System.out.println(g.getMethod().getMethodName());
            System.out.println(g.getDuration());
            System.out.println(g.getPrice());
            System.out.println(g.getOrderID());
        }

        return list;
    }
}

