#include<iostream>
using namespace std;
int main(){
	int a,b,c;
	while(cin>>a){
		if(a==-1)break;
		cin>>b>>c;
		int ans=0,n=a+b;
		while(n>=c){
			ans+=n/c;
			n=n%c+n/c;
		}
		cout<<ans<<endl;
	}
}