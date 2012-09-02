#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#include "my_functions.h"

int fib(int num){
    int fib;
    int j = 1;
    int k = 0;
    for(int i=0; i < num; i++){
        fib = j + k;
        k = j;
        j = fib;
    }
    return fib;
}

unsigned long long int primeNumCheck(unsigned long long int num){
    for(unsigned long long int i = sqrt((double) num); i > 1; i--){
        if(num%i==0){
            return 0;
        }
    }
    return 1;
}

int palindromeCheck(int num){
    char snum[20];
    //itoa convert int to string: itoa(int num, char[] buffer, int radix)
    itoa(num, snum, 10);
    int slength = strlen(snum);
    for(int i = 0; i < slength/2; i++ ){
        if(snum[i] != snum[slength - 1 - i]){
            return 0;
        }
    }
    return 1;
}

int getMaxFromPair(int num1, int num2){
    if(num1 > num2)
        return num1;
    else
        return num2;
}

