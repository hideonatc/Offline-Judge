#include<iostream>
using namespace std;
int main(){
	int a,b;
	while(cin>>a){
		if(a==-1)break;
		cin>>b;
		cout<<a<<"+"<<b<<"="<<a+b<<endl;
	}
}