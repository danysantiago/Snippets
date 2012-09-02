#include <stdio.h>

#include "eulier_problems.h"

void problem5(){
    int sum;
    int i = 1;
    while(0==0){
        sum = 0;
        for(int j = 1; j <= 20; j++){
            if(i%j!=0){
                break;
            } else {
                sum++;
            }
        }
        if(sum==20){
            break;
        }
    //printf("%d\t%d\n", i, sum);
    i++;
    }
    printf("%d", i);
}
