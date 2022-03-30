#include <iostream>
using namespace std;

int main(void)
{
    int score = 0;
    int sum = 0;
    int distance = 100;
    int result = 0;
    int my_abs = 0;

    for (int i = 0; i < 10; i++)
    {
        cin >> score;
        sum += score;
        my_abs = abs(100 - sum);
        if (my_abs <= distance)
        {
            distance = my_abs;
            result = sum;
        }
    }
    cout << "result : " << result;
    cout << "changes" << endl;
    return 0;
}