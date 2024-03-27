
package com.info6205.algorithm;

import java.util.List;

//  iterates each "Cloth" in "Order", and use "TreeToCategorizeCloth" to categorize "Cloth" based on their color and material.
public class TreeToCategorizeCloth {
    private WashingMethod[]methodTree;
    private TreeNode<String> beginNode;

    public TreeToCategorizeCloth(){
        beginNode=new TreeNode<String>("begin");
        setDefaultTree();
    }

    /*
     * 1.set default washingMethod node
     * 2. create */
    public void setDefaultTree(){
        //   TreeNode<String> root = new TreeNode<>("Root");

        TreeNode<String> root = new TreeNode<>("Clothing Color");

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
        TreeNode<String> darkColor = new TreeNode<>("Dark Color");
        TreeNode<String> lightColor = new TreeNode<>("Light Color");
        TreeNode<String> whiteColor = new TreeNode<>("White Color");
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
    }

    /*
     * recieve a cloth and search the wsh method in the tree*/
    public WashingMethod getMethod(Cloth cloth, TreeNode<String> currentNode) {
        if (currentNode == null) {
            return null;
        }
        if(currentNode.getValue().equals(cloth.getColor()) &&  currentNode.getValue().equals(cloth.getMaterial() + " Material")){
            return new WashingMethod(currentNode.getValue(), 0.0, 0);
        }

        return null;
    }
}

