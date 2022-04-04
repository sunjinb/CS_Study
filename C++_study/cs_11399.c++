#include <iostream>
#include <algorithm>
using namespace std;

int main(void)
{

    int num = 0;
    cin >> num;
    int cost[num];

    for (int i = 0; i < num; i++)
    {
        cin >> cost[i];
    }

    sort(cost, cost + num);

    int time, tmp = 0;
    for (int i = 0; i < num; i++)
    {
        tmp += cost[i];
        time += tmp;
    }

    cout << time;

    return 0;
}
