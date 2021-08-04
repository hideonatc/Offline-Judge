#include<iostream>
#include<cstdio>
#include<cmath>
using namespace std;
int m(int x,int y, int z){
	if(x<y&&x<z)
		return x;
	if(y<x&&y<z)
		return y;
	return z;
}
int main(){
	int a,b,c;
	while(cin>>a){	
		if(a==-1)break;
		cin>>b>>c;
		printf("The smallest number is %d.\n",m(a,b,c));
	}
}