#include <stdio.h>
#include <math.h>

#include "eulier_problems.h"

void problem9(){
    int a;
    int b;
    int c;
    for(b = 1; b < 1000; b++){
        for(a = 1; a < b; a++){
            c = sqrt(a*a+b*b);
            if((a*a+b*b) == (c*c) && a+b+c == 1000 && a < b && b < c && a < c){
                goto END;
            }
        }
    }

    END:
    printf("a=%d\tb=%d\tc=%d\n", a, b, c);
    printf("a*b*c=%d", a*b*c);
}
