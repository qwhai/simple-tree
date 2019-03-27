#include <malloc.h>
#include <stdlib.h>
#include "node.h";
#include "bt.h";

int main() {
	Tree* tree = (Tree*)malloc(sizeof(Tree));
	tree->root = NULL;
	insert(tree, 1);
	insert(tree, 2);
	insert(tree, 3);
	insert(tree, 4);
	insert(tree, 5);

	preorder(tree);

	system("pause");
	return 0;
}
