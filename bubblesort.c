#include <stdio.h>

/* bubble sort*/

void show(int * arr,int n){
    for(int i =0;i<n; i++){
        printf("\n%d",arr[i]);
    }
}
void sort(int * arr,int n){
    int temp;
    for(int i =0; i<n-1; i++){
        for(int j =0; j<n-1-i; j++){
            if(arr[j]>arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}
int main(){
    int arr[] = {8,90,67,54,3};
    int n = 5;
    //show(&arr,n);
    sort(&arr,n);
    show(&arr,n);
    return 0;
}
