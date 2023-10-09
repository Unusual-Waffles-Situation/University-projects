#include <iostream>

using std::cin;
using std::cout;
using std::cerr;
using std::string;
using std::endl;

int main()
{
    char *p = nullptr;

    cout << p << endl;
    *p = 'Z';
    cout << "g" << endl;

    return 0;
}
