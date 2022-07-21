import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import smile.timeseries;


/**
 * Peaks Detection!
 * https://github.com/b-elamine
 */
public class peaks_detection{

 

    public static void main(String[] args) {
    

        List<Float> data = new ArrayList<>();
        List<Integer> index = new ArrayList<>(); 
        float delta;
        List<Float> result = new ArrayList<>();
        float random;

        for (int i = 0; i<50; i++){
            random = (float) Math.random(); 
            data.add((float)random);
            index.add(i);
        }
        peaks_detection p_det = new peaks_detection();
        //p_det.peaksDetect(data, (float)0.1, index);
        for (int i=0;i<p_det.peaksDetect(data, (float)0.1, index).size();i++){
            System.out.println(p_det.peaksDetect(data, (float)0.1, index).get(i));
        }
    
    }
    
    public List<Float> peaksDetect(List<Float> data, float delta, List<Integer> index){
        // Initializing needed variables
        List<Float> maxPeaks = new ArrayList<>(); // Maximum peaks values 
        List<Float> minPeaks = new ArrayList<>(); // Minimum peaks values
        List<Float> positionMax = new ArrayList<>(); // Index of every max peak 
        List<Float> positionMin = new ArrayList<>(); // Index of every min peak
        // Helpers for manipulation
        float min, max, minPos, maxPos, val; 
        boolean lookingForMax=true;
            
        if (data.size()!=index.size()) {
            System.out.println("Data and index size must be the equal!");
            System.exit(0);
        }
        if (delta <= 0) {
            System.out.println("Delta have to be positive not null scalar number");
            System.exit(0);
        }

        min = Float.POSITIVE_INFINITY; 
        max = Float.NEGATIVE_INFINITY;
        minPos = Float.NaN;
        maxPos = Float.NaN;

        for (int i = 0 ; i < data.size() ; i++){
            val = data.get(i);
            if (val > max) {
                max = val;
                maxPos = index.get(i);
            }

            if (val < min){
                min = val;
                minPos = index.get(i);
            }
            if (lookingForMax){
                if (val < max-delta){
                    maxPeaks.add(max);
                    positionMax.add(maxPos);
                    min = val;
                    minPos = index.get(i);
                    lookingForMax = false;
                }
            } else {
                if (val > min+delta){
                    minPeaks.add(min);
                    positionMin.add(minPos);
                    max = val;
                    maxPos = index.get(i);
                    lookingForMax = true;
                }
            }
        }
        
        /**
            * Here i'm returning just the maxPeaks (the ones i need for my work)
            * you can just change maxPeaks by minPeaks if you need the minimum 
            * you can also change the return type of the function and return both maxPeaks and minPeaks  
        */

        return maxPeaks;
    }

}
