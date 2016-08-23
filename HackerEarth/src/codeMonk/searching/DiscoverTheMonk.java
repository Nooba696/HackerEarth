/*
    You are given an array A of size N, and Q queries to deal with. 
    For each query, you are given an integer X, and you're supposed to find out
    if X is present in the array A or not.

    Input:
    The first line contains two integers, N and Q, denoting the size of array A
    and number of queries. The second line contains N space separated integers,
    denoting the array of elements Ai.
    The next Q lines contain a single integer X per line.

    Output:
    For each query, print YES if the X is in the array, otherwise print NO.

    Constraints:
    1 <= N, Q <= 105
    1 <= Ai <= 109
    1 <= X <= 109

    SAMPLE INPUT 
    5 10
    50 40 30 20 10
    10
    20
    30
    40
    50
    60
    70
    80
    90
    100
    SAMPLE OUTPUT 
    YES
    YES
    YES
    YES
    YES
    NO
    NO
    NO
    NO
    NO
    Time Limit:	1.0 sec(s) for each input file.
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
import java.util.HashSet;

/**
 *
 * @author Pratick
 */
public class DiscoverTheMonk {
    
    public static void main(String args[]){
        
        //solveBySortBinSearch();
        solveBySortHashing();
    }
    public static void solveBySortBinSearch(){
        
        int A[] = new int[Fio.fin.readInt()];
        int Q = Fio.fin.readInt();
        for(int i=0;i<A.length;i++)
            A[i]=Fio.fin.readInt();
        Arrays.sort(A);
        while(Q-->0){
            if(Arrays.binarySearch(A, Fio.fin.readInt())>=0)
                Fio.fout.println("YES");
            else
                Fio.fout.println("NO");
        }
    }
    public static void solveBySortHashing(){
        
        int N = Fio.fin.readInt();
        HashSet<Integer> h = new HashSet(N); 
        int Q = Fio.fin.readInt();
        for(int i=0;i<N;i++){
            Fio.fout.println("Called");
            h.add(Fio.fin.readInt());}
        while(Q-->0){
            if(h.contains(Fio.fin.readInt()))
                Fio.fout.println("YES");
            else
                Fio.fout.println("NO");
        }
    }
}
