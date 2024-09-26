package PracticeQuestions.DP;

public class MountainRanges_Tabulation {
    // The code is exact similar to Number of BSTs and Catalan's number. The thing is you just
    // need to know that it is related to Catalan and all the rest is sorted for you.
    // The question is like: You are given a number of pairs of upStroke and DownStroke ("/\").
    // You need to tell the number of mountain ranges possible through rearrangement of strokes.
    // At any given point, the number of downStrokes can not be greater than upStrokes.
    // ie the mountain can not go down the Earth.


    //Solution: Imagine one pair and you have the choice of adding other pairs next to it or into it.
    //       eg: x= 3;
    /*
              / \
               ^          ^            you can insert other pairs at these 2 locations
               |    or    |
               1          2
     */
    /*
       The possible ranges are:

                                                  /\
                         /\            /\        /  \         /\/\
            /\/\/\      /  \/\      /\/  \      /    \       /    \                 These are the five ways.

            The situation is like: 1. You added both pairs on the right side.                C0*C2 ways
                                   2. You added one on the side and one into the 1st pair.   C1*C1 ways
                                   3. You added both the pairs into the fixed pair.          C2*C0 ways
     */
}
