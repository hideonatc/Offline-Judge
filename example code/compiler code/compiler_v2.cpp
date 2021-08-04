#include<iostream>
#include<cstdlib>
#include<stdexcept>
#include<cstdio>
#include<fstream>
#include<string>
#include<cstring>
using namespace std;
bool shellCmd(const string &cmd, string &result) {
    char buffer[512];
    result ="";
    FILE* pipe = popen(cmd.c_str(), "r");
    if (!pipe) {
        return false;
    }
    while (!feof(pipe)) {
        if (fgets(buffer, sizeof(buffer), pipe) != NULL)
            result += buffer;
    }
    pclose(pipe);
    return true;
}

int main(){
	string result,i;
	shellCmd("g++ code.cpp -o code.exe",result);//compile
	ifstream in("input.txt");//get input data
  string cmd = "echo ";
  while(!in.eof()){
    getline(in,i);
    cout<<i<<endl;
    cmd+=i;
    cmd+=" ";
  }
  cmd += "| code";
  in.close();
  shellCmd(cmd,result);//run code
  ofstream out("output.txt");//output result
  out<<result;
  out.flush();
  out.close();
  bool ac=true;
  int l=1;
  string a,o;
  ifstream op("output.txt");
  ifstream as("answer.txt");
  while(!op.eof()){//compare output with answer
  	getline(op,o);
  	getline(as,a);
  	if(o!=a){
  		ac=false;
  		break;
  	}
	}
	op.close();
  as.close();
  ofstream myfile;
  myfile.open("result.txt");//write result
  if(ac)
  	myfile<<"AC";
  else
  	myfile<<"WA";
  myfile.flush();
  	myfile.close();
}