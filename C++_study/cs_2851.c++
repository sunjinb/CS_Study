#include <iostream>
using namespace std;

int main(void)
{
    int score = 0;
    int sum = 0;
    int last_distance = 100; //이전 거리
    int result = 0;
    int distance = 0;

    for (int i = 0; i < 10; i++)
    {
        cin >> score;
        sum += score;
        distance = abs(100 - sum);
        if (distance <= last_distance)
        {
            last_distance = distance;
            result = sum;
        }
    }

    cout << "result : " << result;
    return 0;
}
