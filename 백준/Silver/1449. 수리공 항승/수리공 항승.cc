#include <iostream>
#include <algorithm>
using namespace std;

int main(void){

  int num, length = 0;
  
  cin >> num;
  cin >> length;

  int pipe[99];

  for(int i = 0; i < num; i++){
    cin >> pipe[i];
  }

  sort(pipe, pipe + num);

  int tape_count = 1;
  int start = pipe[0];
  
  for (int i = 0; i < num; i++){
    if(pipe[i] < (start + length)){
      continue;
    }
    else{
      tape_count++;
      start = pipe[i];
    }
  } 
  cout << tape_count;
}