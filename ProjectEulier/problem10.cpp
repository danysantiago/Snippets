#include <stdio.h>
#include <math.h>

#include"eulier_problems.h"
#include"my_functions.h"

void problem10(){
    unsigned long long int sum = 0;
    for(int i = 2; i < 2000000; i++){
        if(primeNumCheck(i)==1){
            //printf("%d\n", i);
            sum += i;
        }
    }

    printf("%lld", sum);
}
