#include <iostream>
using namespace std;

int main(void)
{
    int round_cnt = 1;

    int round, num1, num2 = 0;

    cin >> round >> num1 >> num2;

    for (int i = 0; i < round; i++)
    {
        num1 = num1 / 2 + num1 % 2;
        num2 = num2 / 2 + num2 % 2;
        if (num1 == num2)
        {
            break;
        }
        round_cnt += 1;
    }
    cout << round_cnt;
}