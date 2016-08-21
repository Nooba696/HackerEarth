/*

    This is the story in Zimbo, the kingdom officially made for monkeys. 
    Our Code Monk visited Zimbo and declared open a challenge in the kingdom, 
    thus spoke to all the monkeys :

    You all have to make teams and go on a hunt for Bananas. 
    The team that returns with the highest number of Bananas will be rewarded
    with as many gold coins as the number of Bananas with them. May the force
    be with you! Given there are N monkeys in the kingdom. 
    Each monkey who wants to team up with another monkey has to perform a ritual.
    Given total M rituals are performed. Each ritual teams up two monkeys. 
    If Monkeys A and B teamed up and Monkeys B and C teamed up, 
    then Monkeys A and C are also in the same team.

    You are given an array A where Ai is the number of 
    bananas i'th monkey gathers.

    Find out the number of gold coins that our Monk should
    set aside for the prize.

    Input:
    First line contains an integer T. T test cases follow. 
    First line of each test case contains two space-separated N and M. 
    M lines follow. Each of the M lines contains two integers Xi and Yi, 
    the indexes of monkeys that perform the i'th ritual. 
    Last line of the testcase contains N space-separated integer
    constituting the array A.

    Output:
    Print the answer to each test case in a new line.

    Constraints:
    1 ≤ T ≤ 10
    1 ≤ N ≤ 10^5
    0 ≤ M ≤ 10^5
    0 ≤ Ai ≤ 10^12

    SAMPLE INPUT 
    1
    4 3
    1 2
    2 3
    3 1
    1 2 3 5
    SAMPLE OUTPUT 
    6
    Explanation
    Monkeys 1,2 ,3 are in the same team. They gather 1+2+3=6 bananas.
    Monkey 4 is a team. It gathers 5 bananas.
    Therefore, number of gold coins (highest number of bananas by a team) = 6.

    Time Limit:	3.0 sec(s) for each input file.
    Memory Limit:	256 MB
    Source Limit:	1024 KB
    Marking Scheme:	Marks are awarded if any testcase passes.
    Allowed Languages:	C, CPP, CLOJURE, CSHARP, D, ERLANG, FSHARP, GO, GROOVY, 
                        HASKELL, JAVA, JAVA8, JAVASCRIPT, JAVASCRIPT_NODE, LISP,
                        LISP_SBCL, LUA, OBJECTIVEC, OCAML, OCTAVE, PASCAL, PERL,
                        PHP, PYTHON, PYTHON3, R, RACKET, RUBY, RUST, SCALA, 
                        SWIFT, VB

 */
package codeMonk.graphI;

import fastio.Fio;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;

/**
 *
 * @author Pratick
 */
public class KingdomOfMoneys {

    private static List<Integer>[] adjLists;
    private static long[] A;

    public static void main(String args[]) {

        int T = Fio.fin.readInt();
        while (T-- > 0) {
            A = new long[Fio.fin.readInt() + 1];
            adjLists = new List[A.length];
            for (int i = 1; i < adjLists.length; i++) {
                adjLists[i] = new ArrayList();
            }

            int M = Fio.fin.readInt();
            while (M-- > 0) {
                int u = Fio.fin.readInt();
                int v = Fio.fin.readInt();
                adjLists[u].add(v);
                adjLists[v].add(u);
            }
            for (int i = 1; i < A.length; i++) {
                A[i] = Fio.fin.readLong();
            }
            answerByVoid();
            //answerByLong();
        }
    }

    private static void answerByVoid() {
        boolean[] vis = new boolean[A.length];
        long maxBananas = 0;
        for (int i = 1; i < A.length; i++) {
            if (!vis[i]) {
                dfsI(vis);
                maxBananas = (bananas > maxBananas) ? bananas : maxBananas;
                bananas = 0;
            }
        }
        Fio.fout.println(maxBananas);
    }

    private static void answerByLong() {
        boolean[] vis = new boolean[A.length];
        long maxBananas = 0;
        for (int i = 1; i < A.length; i++) {
            
            if (!vis[i]) {
                long bananas = dfs(i, vis, 0);
                maxBananas = (bananas > maxBananas) ? bananas : maxBananas;
            }
        }
        Fio.fout.println(maxBananas);
    }
    
    // Void dfs way
    private static long bananas = 0;
    public static void dfs(int u, boolean[] vis) {
        vis[u] = true;
        for (int v : adjLists[u]) {
            if (!vis[v]) {
                dfs(v, vis);
            }
        }
        bananas = bananas + A[u];
    }
    
    //Ittertative Void dfs
    public static void dfsI(boolean[] vis) {
        
        Deque<Integer> stack = new ArrayDeque();
        stack.push(1);
        vis[1]=true;
        while(!stack.isEmpty()){
            int u = stack.pop();
            bananas = bananas + A[u];
            for(int v : adjLists[u]){
                if(!vis[v]){
                    stack.push(v);
                    vis[v]=true;
                }
            }
        }        
    }

    // long dfs way
    public static long dfs(int u, boolean[] vis, long bananas) {

        boolean noUnvisAdj = true;
        vis[u] = true;
        for (int v : adjLists[u]) {
            if (!vis[v]) {
                noUnvisAdj = false;
                bananas = dfs(v, vis, bananas + A[u]);
            }
        }
        if (noUnvisAdj) {
            return bananas + A[u];
        }
        return bananas;
    }
}
