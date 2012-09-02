#include <stdio.h>

#include "eulier_problems.h"

void problem6(){
    unsigned long long int sum_of_sqrt = 0, sqrt_of_sum = 0, i;

    for(i = 0; i <= 100; i++){
        sum_of_sqrt += i*i;
        sqrt_of_sum += i;
    }

    sqrt_of_sum *= sqrt_of_sum;

    printf("%lld", sqrt_of_sum - sum_of_sqrt);

}
