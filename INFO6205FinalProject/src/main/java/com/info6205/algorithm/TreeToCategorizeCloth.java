package com.info6205.algorithm;
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

        //TO DO: create three wash method node

        //TO DO: create 12 material , 4 kinds in one group

        //TO DO: create 3 colors

        //TO DO : connect each node( set the tree)

    }
    /*
    * recieve a cloth and search the wsh method in the tree*/
    public WashingMethod getMethod(Cloth cloth){
    return null;
    }


}
