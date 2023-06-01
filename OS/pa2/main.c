#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

int arr[100001] = {};
int number_size = 0;
int number_avg = 0;
int number_max = 0;
int number_min = 0;

void *avg_runner() {
	int sum = 0;
	for (int i = 0; i < number_size; i++) {
		sum += arr[i];
	}
	number_avg = sum / number_size;
	pthread_exit(0);
}

void *min_runner() {
	int min = 99999999;
	for (int i = 0; i < number_size; i++) {
		if (arr[i] < min) min = arr[i];
	}
	number_min = min;
	pthread_exit(0);
}

void *max_runner() {
	int max = -1;
	for (int i = 0; i < number_size; i++) {
		if (arr[i] > max) max = arr[i];
	}
	number_max = max;
	pthread_exit(0);
}

int main(int argc, char* argv[]) {
	pthread_t tid1, tid2, tid3;
	pthread_attr_t attr;

	pthread_attr_init(&attr);

	number_size = argc - 1;
	for (int i = 0; i < number_size; i++) {
		arr[i] = atoi(argv[i+1]);
	}

	pthread_create(&tid1, &attr, avg_runner, NULL);
	pthread_create(&tid2, &attr, min_runner, NULL);
	pthread_create(&tid3, &attr, max_runner, NULL);

	pthread_join(tid1, NULL);
	pthread_join(tid2, NULL);
	pthread_join(tid3, NULL);

	printf("The average value is %d\n", number_avg);
	printf("The minimum value is %d\n", number_min);
	printf("The maximum value is %d\n", number_max);

	return 0;
}
