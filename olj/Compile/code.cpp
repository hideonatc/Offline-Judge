#include<iostream>
#include<stack>
#include<cstring>
#include<string>
#include<cstdio>
#include<cstdlib>
using namespace std;
bool ch(char a,char b){
	if(a=='r'&&b=='R')
		return 1;
	else if(a=='l'&&b=='L')
		return 1;
	else
		return 0;
}
int main(){
	string s;
	while(cin>>s){
		if(s[0]=='-')break;
		stack<char> st;
		for(int i=0;i<s.length();i++){
			if(st.empty())
				st.push(s[i]);
			else{
				if(ch(st.top(),s[i]))
					st.pop();
				else
					st.push(s[i]);
			}
		}
		if(st.empty())
			printf("Yes\n");
		else
			printf("No\n");
	}
}