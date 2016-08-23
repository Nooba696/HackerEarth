/*
    The Monk wants to buy some cities. To buy two cities, he needs to buy the road 
    connecting those two cities. Now, you are given a list of roads, 
    bought by the Monk. You need to tell how many cities did the Monk buy.

    Input:
    First line contains an integer T, denoting the number of test cases. 
    The first line of each test case contains an integer E,
    denoting the number of roads. The next E lines contain two space separated 
    integers X and Y, denoting that there is an road between city X and city Y.

    Output:
    For each test case, you need to print the number of cities the Monk bought.

    Constraint:
    1 <= T <= 100
    1 <= E <= 1000
    1 <= X, Y <= 10000

    SAMPLE INPUT 
    1
    3
    1 2
    2 3
    1 3
    SAMPLE OUTPUT 
    3
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
package codeMonk.graphI;

import fastio.Fio;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author Nooba
 */
public class MonkInRealEstate {

    private static List<Integer>[] adjLists;

    public static void main(String args[]) {

        int T = Fio.fin.readInt();
        while (T-- > 0) {
            adjLists = new List[10001];
            int E = Fio.fin.readInt();
            while (E-- > 0) {
                int u = Fio.fin.readInt();
                int v = Fio.fin.readInt();
                if (adjLists[u] == null) {
                    adjLists[u] = new ArrayList();
                }
                if (adjLists[v] == null) {
                    adjLists[v] = new ArrayList();
                }
                adjLists[u].add(v);
                adjLists[v].add(u);
            }
            answerByVoid();
        }
    }
    private static int cities = 0;

    private static void answerByVoid() {
        boolean[] vis = new boolean[adjLists.length];
        for (int i = 1; i < adjLists.length; i++) {
            if (adjLists[i] != null && !vis[i]) {
                dfsI(i, vis);
            }
        }
        Fio.fout.println(cities);
        cities = 0;
    }

    //Itertative Void dfs
    public static void dfsI(int i, boolean[] vis) {

        Deque<Integer> stack = new ArrayDeque();
        stack.push(i);
        vis[i] = true;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            cities++;
            for (int v : adjLists[u]) {
                if (!vis[v]) {
                    stack.push(v);
                    vis[v] = true;
                }
            }
        }
    }
}
