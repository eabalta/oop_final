# OOP Final Exam
## Q1.
- Explanation of problem:
  * Multiplying an MxN matrix with another matrix of NxP size is done with Java Threads.
  * A part of the result matrix will be created by giving a row of the first matrix and the entire second matrix to thread.
  * In this way, the multiplication process will be completed by creating as many threads as the number of rows of the first matrix.
  * The resulting matrix will have been obtained by creating the relevant part of each thread in a buffer field whose respective methods are defined synchronously.
- Details:
  * Matrices will be given in text files named matrix1.txt and matrix2.txt, with a space between the numbers:
    * Matris1.txt (2x3)<br>
     2 8 9<br>
     1 3 5<br>
    * Matris2.txt (3x2)<br>
    6 5<br>
    8 7<br>
    3 5<br>
  * Write a Buffer class for the buffer zone. Let the Buffer class take the number of rows and columns for the result matrix in the constructor method and create the two dimensional array in which the result will be placed according to the number of rows and columns. There must be a put method in the buffer class. The put method can be used by the relevant thread to write a result into a cell of the result matrix. Define the put method as synchronized. You can specify the parameters of the put method accordingly. Also add a print method to print the entire result matrix.
  * Write a thread which name is MultiplyWorker. As parameters to this thread's constructor method, the buffer can take the corresponding row of the first matrix, the second matrix and any other variables you need. In the run method, partial results will be obtained within the task of the relevant workpiece and will be transferred to the relevant places in the buffer.
  * In the test program's main method, take the two matrix that comes from the files as input, create the buffer object and create the thread as the number of rows of the first matrix as and start the threads. Then, after waiting for all the threads to finish, print the buffer to terminate the main method.
## Q2.
- We have integer values that you can keep in the data structure you want. You can think that the maximum number of data for the exam is 100, and you can set this data by generating a random number. We want to sort this data using three different algorithms, so we want to have the chance to choose the algorithm at runtime. These three algorithms are "BubbleSort", "QuickSort (recursive)" and "InsertionSort". Perform this application using the design patterns. Write this application using the design patterns. In the design pattern you will use, show the implementation of all three algorithms for experimental purposes and also measure the runtime for each sorting algorithm.
