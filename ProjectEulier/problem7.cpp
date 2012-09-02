#include <stdio.h>

#include "eulier_problems.h"
#include "my_functions.h"

void problem7(){
    int i = 2;
    int n = 0;
    while(0==0){
        if(primeNumCheck(i)==1){
            n++;
        }
        if(n==10001){
            break;
        }
        i++;
    }

    printf("%d", i);
}
