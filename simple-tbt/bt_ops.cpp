#include <malloc.h>
#include <stdlib.h>
#include "node.h"

Node* createNode(int val) {
	Node* node = (Node*)malloc(sizeof(Node));
	node->data = val;
	node->left = NULL;
	node->right = NULL;

	return node;
}

void insert(Node* pnode, Node* cnode);

void insert(Tree* tree, int val) {
	Node* node = createNode(val);
	if (NULL == tree->root) {
		tree->root = node;
		return;
	}

	insert(tree->root, node);
}

void insert(Node* pnode, Node* cnode) {
	if (NULL == pnode->left) {
		pnode->left = cnode;
		return;
	}
	if (NULL == pnode->right) {
		pnode->right = cnode;
		return;
	}

	insert(pnode->left, cnode);
	insert(pnode->right, cnode);
}

void preorder(Tree* tree) {
	// TODO
}

void inorder(Tree* tree) {
	// TODO
}

void postorder(Tree* tree) {
	// TODO
}

void sequence(Tree* tree) {
	// TODO
}

int main() {
	Tree* tree = (Tree*)malloc(sizeof(Tree));
	tree->root = NULL;
	insert(tree, 1);
	insert(tree, 2);
	insert(tree, 3);
	insert(tree, 4);
	insert(tree, 5);
	insert(tree, 6);
	insert(tree, 7);

	preorder(tree);

	system("pause");
	return 0;
}
