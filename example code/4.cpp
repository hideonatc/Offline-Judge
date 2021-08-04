#include<iostream>
#include<string>
using namespace std;
int main(){
	string s;
	while(cin>>s){
		if(s=="-1")break;
		cout<<"hello ,"<<s<<endl;
	}
}