
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


        String[] colors = {"Dark", "Light", "White"};
        for (String color : colors) {
            TreeNode<String> colorNode = new TreeNode<>(color + " Color");
            root.addChildren(colorNode);

            String[] materials = {"Cotton", "Denim", "Silk", "Wool", "Polyester"};
            for (String material : materials) {
                TreeNode<String> materialNode = new TreeNode<>(material + " Material");
                colorNode.addChildren(materialNode);

                String[] methods = {"Strong", "Light", "Normal"};
                for (String method : methods) {
                    TreeNode<String> methodNode = new TreeNode<>(method + " Wash Method");
                    materialNode.addChildren(methodNode);
                }
            }
        }

        String[] methods = {"Strong", "Light", "Normal"};

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

