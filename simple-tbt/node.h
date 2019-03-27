typedef struct node {
	int data;
	struct node* left;
	struct node* right;
} Node;

typedef struct {
	Node* root;
} Tree;
