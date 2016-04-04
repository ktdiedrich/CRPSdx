# Program: Complex Regional Pain Syndrome (CRPS) 1 Diagnostic Tool


## Author: Karl T. Diedrich <ktdiedrich@gmail.com>



## Files:  
* diedrich.crpsdx.sh, 
* diedrich.crpsdx.bat, 
* doc/diedrich.bmi6300.crpsdx.doc, 
* README.md
* Requirements: Java 1.6+
* Compile: from CRPSdx/  ```ant compile```
  * builds ```../CRPSdx-build``` 
  specified in ```build.properties```
   
* Run: from ```../CRPSdx-build``
  * ```java ktdiedrich.crpsdx.ui.CRPSdxMain``` 
  * Also see scripts diedrich.crpsdx.sh on UNIX and MacOS X, diedrich.crpsdx.bat on Windows



### Description:

The program is Complex Regional Pain Syndrome 1, CRPS 1 Diagnostic Tool, created by Karl Diedrich. The files that came with this distribution are diedrich.crpsdx.jar, diedrich.crpsdx.sh, diedrich.crpsdx.bat, diedrich.bmi6300.crpsdx.doc, and README.diedrich.crpsdx.doc. To run the program you need Java 1.6 on your executable path. If the program doesn’t run check the PATH environment variable on UNIX or MacOS X with: 
```which java 
> echo $PATH  
java –version ```
On windows try:
```java –version
path```

If you do not have java installed, it is available from http://www.java.com/en/.

 
## Guide to run the program:

1. There are two choices on the top of the program. “Diagnose by signs for clinicians” and “Diagnose by symptoms for patients”.
1. Select one that you want to try.
1. Select Yes or No for the question “Present?”
1. If your hold the mouse over a label or button, more information will appear.
1. The values in the column “Probability given CRPS 1” are from the literature and don’t need to be changed, but can be changed if desired (A decimal number greater than 0 and less than 1).
1. The values “Probability given no CRPS 1” are only assumptions that the user may change to see the affect on disease probability.
1. Pressing the button “Diagnose disease probability” calculates the probability of the disease using the values in the columns.