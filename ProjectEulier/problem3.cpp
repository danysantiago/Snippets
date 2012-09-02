#include <stdio.h>

#include "eulier_problems.h"
#include "my_functions.h"

void problem3(){
    //max unsigned int value is 4294967295
    unsigned long long int cnum = 600851475143;
    for(unsigned long long int i = 1; i*i < cnum; i++){
        if(cnum%i==0 && primeNumCheck(i)==1){
            printf("%lld\n", i);
        }
    }

}
