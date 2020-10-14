#include<iostream>
#include <cstdlib>

using namespace std;

/***
An XOR linked list is a more memory efficient doubly linked list.
Instead of each node holding next and prev fields,
it holds a field named both, which is an XOR of the next node and the previous node.
Implement an XOR linked list; it has an add(element) which adds the element to the end,
and a get(index) which returns the node at index.
***/

class Node{
public:
	int item;

	Node *left;

	Node *right;

	Node(int n){
		item = n;
		left = NULL;
		right = NULL;
	}

};

class DoubleLinkList{

public:
	Node head = Node(0);

	DoubleLinkList(int n){
		head = Node(n);
	}

	void insert(int n){
		Node *p = &head;
		while(p->right != NULL){
			p= p->right;
		}
		auto node = new Node(n);
		node->left = p;
		p->right = node;
	}

	Node *getItem(int pos){
		Node *p = &head;
		while(pos != 0 && p!=NULL){
			p= p->right;
			pos--;
		}
		return p;
	}

};

class XORNode{
public:
	int item;

	XORNode *addr = NULL;

	XORNode(int n){
		item = n;
	}

};

class DoubleLinkListXOR{

public:
	XORNode head = XORNode(0);

	DoubleLinkListXOR(int n){
		head = XORNode(n);
	}

	void insert(int n){
		XORNode *p = &head;
		XORNode *q = NULL;
		while(true){
			auto x = xorAddresses(q,p->addr);
			if(x == NULL){
				break;
			}
			q = p;
			p = x;
		}

		auto node = new XORNode(n);
		p->addr = xorAddresses(q,node);
		node->addr = xorAddresses(p,NULL);
	}

	XORNode *getItem(int pos){

		XORNode *p = &head;
		XORNode *q = NULL;
		while(pos != 0 && p!=NULL){
			auto x = xorAddresses(q,p->addr);
			q = p;
			p = x;
			pos--;
		}
		return p;
	}


	XORNode * xorAddresses(XORNode *node1,XORNode *node2){
		return (XORNode *)((uintptr_t)node1 ^ (uintptr_t)node2);
	}

};

class SumNode{
   public:
	int item;

	SumNode *addr = NULL;

	SumNode(int n){
		item = n;
	}
};

class DoubleLinkListSum{
	public:
	SumNode head = SumNode(0);

	DoubleLinkListSum(int n){
		head = SumNode(n);
	}

	void insert(int n){
		SumNode *p = &head;
		SumNode *q = NULL;
		while(true){
			auto x = diffAddress(q,p->addr);
			if(x == NULL){
				break;
			}
			q = p;
			p = x;
		}

		auto node = new SumNode(n);
		p->addr = sumAddress(q,node);
		node->addr = sumAddress(p,NULL);
	}

	SumNode *getItem(int pos){

		SumNode *p = &head;
		SumNode *q = NULL;
		while(pos != 0 && p!=NULL){
			auto x = diffAddress(q,p->addr);
			q = p;
			p = x;
			pos--;
		}
		return p;
	}

	SumNode * sumAddress(SumNode *node1,SumNode *node2){
		return (SumNode *)((long)node1 + (long)node2);
	}

	SumNode * diffAddress(SumNode *node1,SumNode *node2){
		return (SumNode *)abs(((long)node1 - (long)node2));
	}
};


int main(){

	cout<<"Simple Two pointer Doubly Linked List"<<endl;

	auto x = DoubleLinkList(10);
	x.insert(20);

    cout<<"Head: "<<x.head.item<<endl;
	cout<<"Head right: "<<x.head.right->item<<endl;
	cout<<"Head right left: "<<x.head.right->left->item<<endl<<endl<<endl;


	cout<<"XOR Doubly Linked List Testing: (Understanding things)"<<endl;
	//XOR LIST
	auto xn = new XORNode(10);
	auto xn2 = new XORNode(20);
	auto xn3 = new XORNode(30);
	auto xn4 = new XORNode(40);

	cout<<"Converting pointer to integer: "<<(uintptr_t)xn3<<endl;
	cout<<"Size of  uintptr_t: "<<sizeof(uintptr_t)<<endl;
	cout<<"Size of  int: "<<sizeof(int)<<endl;
	cout<<"Size of  char: "<<sizeof(char)<<endl;
	cout<<"Size of  long: "<<sizeof(long)<<endl;

	cout<<endl<<"We can use long and uintptr_t to hold integer value of an address"<<endl<<endl;

	xn->addr = (XORNode *)((long)NULL ^ (long)xn2);
	xn2->addr = (XORNode *)((uintptr_t)xn ^ (uintptr_t)xn3);
	xn3->addr = (XORNode *)((uintptr_t)xn2 ^ (uintptr_t)xn4);
	xn4->addr = (XORNode *)((uintptr_t)xn3 ^ (uintptr_t)NULL);

	
	
	cout<<"Head: "<<x.getItem(0)->item<<endl;
	cout<<"Head left: "<<x.getItem(1)->item<<endl;

	cout<<"Node1: "<<xn->item<<endl;
	auto xnRight = (XORNode *)((uintptr_t)xn->addr ^ (uintptr_t)NULL);
	cout<<"Node1 Right: "<<xnRight->item<<endl;

	auto xn2Right = (XORNode *)((uintptr_t)xn2->addr ^ (uintptr_t)xn);
	cout<<"Node2 Right: "<<xn2Right->item<<endl;

	auto xn2Left = (XORNode *)((uintptr_t)xn2->addr ^ (uintptr_t)xn3);
	cout<<"Node2 Left: "<<xn2Left->item<<endl;

	cout<<"Test: "<<(uintptr_t)NULL<<endl<<endl<<endl;


	cout<<"XOR Doubly Linked List"<<endl;
	auto xorList = DoubleLinkListXOR(1);
	xorList.insert(2);
	xorList.insert(3);

	cout<<"Head: "<<xorList.getItem(0)->item<<endl;
	cout<<"Head right: "<<xorList.getItem(1)->item<<endl;
	cout<<"Head right: "<<xorList.getItem(2)->item<<endl;

	cout<<"Sum/Diff Doubly Linked List"<<endl;
	auto sumList = DoubleLinkListSum(1);
	sumList.insert(2);
	sumList.insert(3);

	cout<<"Head: "<<sumList.getItem(0)->item<<endl;
	cout<<"Head right: "<<sumList.getItem(1)->item<<endl;
	cout<<"Head right right: "<<sumList.getItem(2)->item<<endl;


	return 0;
}
