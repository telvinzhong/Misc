#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define NTHREADS 40000

pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER;

// shared variables
int counter1 = 0;
int counter2 = 0;
int counter3 = 0;
int counter4 = 0;

// thread one adds one
void *thread1 (void *vargp) {
    pthread_mutex_lock(&mutex1);
        counter1 = counter1 + 1;
    pthread_mutex_unlock(&mutex1);
  return NULL;
}

// thread two adds five
void *thread2 (void *vargp) {
    pthread_mutex_lock(&mutex1);
        counter2 = counter2 + 5;
    pthread_mutex_unlock(&mutex1);
  return NULL;
}

// thread three subtracts two
void *thread3 (void *vargp) {
    pthread_mutex_lock(&mutex1);
        counter3 = counter3 - 2;
    pthread_mutex_unlock(&mutex1);
  return NULL;
}

// thread four subtracts 10
void *thread4 (void *vargp) {
    pthread_mutex_lock(&mutex1);
        counter4 = counter4 - 10;
    pthread_mutex_unlock(&mutex1);
  return NULL;
}

int main() {
  // Array to keep Pthread IDs of created threads.
  pthread_t tid[NTHREADS];
  int i;

  printf("Tests beginning.");
  
  // Create and run the threads.
  for (i=0; i < 10000; ++i){
    pthread_create(&(tid[i]), NULL, thread1, NULL);
    pthread_create(&(tid[i + 10000]), NULL, thread2, NULL);
    pthread_create(&(tid[i + 20000]), NULL, thread3, NULL);
    pthread_create(&(tid[i + 30000]), NULL, thread4, NULL);
  }

  // Wait until all threads are done
  for (i=0; i < NTHREADS; ++i){
    pthread_join(tid[i], NULL);
  }

  // Expecting 10000, 50000, -2000, -10000.
  printf("Counters end at %d, %d, %d, %d.\n", counter1, counter2, counter3, counter4);

  return 0;
}
