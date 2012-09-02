#include <stdio.h>

#include "eulier_problems.h"
#include "my_functions.h"

void problem2(){
    int sum = 0;
    int i = 1;
    int num = fib(i);
    while(num < 4000000){
        if(num%2==0){
            sum += num;
        }
        i++;
        num = fib(i);
    }

    printf("%d", sum);
}
