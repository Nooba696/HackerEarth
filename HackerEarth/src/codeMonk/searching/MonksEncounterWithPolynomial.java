/*
    Our monk, while taking a stroll in the park, stumped upon a polynomial 
    ( A X2 + B X +C ) lying on the ground. The polynomial was dying! 
    Being considerate, our monk tried to talk and revive the polynomial. 
    The polynomial said: 
    I have served my purpose, and shall not live anymore. Please fulfill my 
    dying wish. Find me the least non-negative integer Xo, that shall make my 
    value atleast K i.e., A Xo2 + B Xo + C >= K . 
    Help our Monk fulfill the polynomial's dying wish!

    Input: 
    The first line contains an integer T. T test cases follow. 
    Each test case consists of four space-separated integers A, B, C and K. 

    Output:
    For each test case, output the answer in a new line.

    Constraints:
    1 ≤ T ≤ 105
    1 ≤ A,B,C ≤ 105
    1 ≤ K ≤ 1010

    SAMPLE INPUT 
    3
    3 4 5 6
    3 4 5 5
    3 4 5 150
    SAMPLE OUTPUT 
    1
    0
    7
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

/**
 *
 * @author Nooba
 */
public class MonksEncounterWithPolynomial {

    public static void main(String args[]){
        
        int T = Fio.fin.readInt();
        while(T-->0){
            int A = Fio.fin.readInt();
            int B = Fio.fin.readInt();
            int C = Fio.fin.readInt();
            long K = Fio.fin.readLong();
            
            if(C>=K)
                Fio.fout.println(0);
            else
                Fio.fout.println((int)Math.ceil((-B+Math.sqrt(Math.pow(B,2)-4*A*(C-K)))/(2*A)));
        }
    }
}
