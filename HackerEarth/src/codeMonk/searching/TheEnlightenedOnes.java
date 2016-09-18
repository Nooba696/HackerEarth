/*
    There are N temples in a straight line and K monks who want to spread their 
    enlightening power to the entire road of temples. 
    All the monks have an enlightenment value, which denotes the range of 
    enlightenment which they can spread in both the directions. 
    Since, they do not want to waste their efficiency on trivial things of 
    the world, they want to keep their range minimum.

    Also, when we say that the N temples are in a straight line, we mean that 
    that all the temples lie on something like an X-axis in a graph.

    Find the minimum enlightenment value such that all the temples 
    can receive it.

    Input Format:
    The first line contains two integers, N and K - denoting the number of 
    temples and number of monks. The next line contains N integers denoting 
    the position of the temples in the straight line.

    Output format:
    Print the answer in a new line.

    Constraints:
    1 <= N <= 105
    1 <= K < N 
    1 <= Positioni <= 107

    Update: 
    The enlightenment value is an integer.

    SAMPLE INPUT 
    3 2
    1 5 20
    SAMPLE OUTPUT 
    2
    Explanation
    The optimal answer is 2. A monk positioned at 3, can serve temples at 1 and 5. The other monk can be placed at 18, to serve temple at 20.

    Time Limit:	2.0 sec(s) for each input file.
    Memory Limit:	256 MB
    Source Limit:	1024 KB
    Marking Scheme:	Marks are awarded if any testcase passes.
    Allowed Languages:	C, CPP, CLOJURE, CSHARP, D, ERLANG, FSHARP, GO, GROOVY, 
                        HASKELL, JAVA, JAVA8, JAVASCRIPT, JAVASCRIPT_NODE, LISP,
                        LISP_SBCL, LUA, OBJECTIVEC, OCAML, OCTAVE, PASCAL, PERL,
                        PHP, PYTHON, PYTHON3, R, RACKET, RUBY, RUST, SCALA, 
                        SWIFT, VB
      
*/

package codeMonk.searching;

import fastio.Fio;
import java.util.Arrays;

/**
 *
 * @author Nooba
 */
public class TheEnlightenedOnes {
    public static void main(String args[]){
        int N = Fio.fin.readInt();
        int K = Fio.fin.readInt();
        int A[] = new int[N];
        for(int i=0;i<N;i++)
            A[i]=Fio.fin.readInt();
        Arrays.sort(A);
        int l = 0;
        int h = A[N-1];
        int ans = 0;
        while(l<=h){
            int m = l + (h-l)/2;
            if(isRngValid(A,m,K)){
                ans = m;
                h=m-1;
            }
            else{
                l=m+1;
            }
        }
        Fio.fout.println(ans);
    }
    public static boolean isRngValid(int[] A, int m,int K){
        int pos = A[0]+m;
        K--;
        for(int i=1;i<A.length;i++){
            if(pos+m>=A[i])
                continue;
            if(K==0)
                return false;
            pos = A[i]+m;
            K--;
        }
        return true;
    }
}
