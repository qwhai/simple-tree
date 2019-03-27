#pragma once
#include "node.h";

//Node* createNode(int val);
//void insert(Node* pnode, Node* cnode);
void insert(Tree* tree, int val);
void preorder(Tree* tree);
void inorder(Tree* tree);
void postorder(Tree* tree);
void sequence(Tree* tree);
