# Peaks-detection-algorithm

This algorithm is a solution for the problem of finding local maxima and minima in noisy signals. 
The well known Zero-derivate methode may not work well because of the noise in the signal so it will detect some meaningless peaks.
With the zero-derivate method you have to apply a low-pass filter to the signal in purpose of getting rid of the noise but this will 
kill somehow the original signal and give usually horrible results. 
So in this algorithm we didn't think about the problem in a mathematical way, the logique is simple to detect a peak we just need
to detect a lower points around it in both sides of the x axis.
.
.
.
This work is a conversion from a matlab script to a java
http://billauer.co.il/peakdet.html

Hope it helps !
