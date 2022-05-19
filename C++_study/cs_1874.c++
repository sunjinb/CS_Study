#include <iostream>
using namespace std;

int main(void){

  int count = 0;
  cin >> count;

  int stack[99];

  int index, header = 0;

  string answer;

  while(count-- > 0){
    int value = 0;
    cin >> value;

    if(value > header) {
      for(int i = header + 1; i <= value; i++){
        stack[index] = i;
        index++;
        answer += '+';
      }
      header = value;
    }

    else if (stack[index - 1] != value){
      cout << "NO";
      return 0;
    }

    index--;
    answer += '-';
  }
  cout << answer;
  
}