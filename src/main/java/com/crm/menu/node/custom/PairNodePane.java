package com.crm.menu.node.custom;

import com.crm.menu.node.factory.NodeFactory;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * Created by Bohdan on 11.02.2017.
 */
public class PairNodePane<F extends Node, S extends Node> extends GridPane
{
    private F firstNode;
    private S secondNode;

    public F getFirstNode()
    {
        return firstNode;
    }

    public void setFirstNode(F firstNode)
    {
        this.firstNode = firstNode;
    }

    public S getSecondNode()
    {
        return secondNode;
    }

    public void setSecondNode(S secondNode)
    {
        this.secondNode = secondNode;
    }

    public PairNodePane()
    {
    }

    public PairNodePane(F firstNode, S secondNode)
    {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        init();
    }

    private void init()
    {
        NodeFactory.transformGridPane(this, 2, 1);

        add(firstNode, 0, 0);
        add(secondNode, 0, 1);
    }
}
