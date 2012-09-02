#include <stdio.h>

#include "eulier_problems.h"
#include "my_functions.h"

void problem4(){
    int pal = 0;
    for(int i = 999; i > 900; i--){
        for(int j = 999; j > 900; j--){
            //printf("%d * %d\n", i, j);
            if(palindromeCheck(i*j)==1){

                if(i*j > pal){
                    pal = i*j;
                }
            }
        }
    }
    printf("%d", pal);
}
