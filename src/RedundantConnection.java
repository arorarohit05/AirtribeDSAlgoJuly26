public class RedundantConnection {

    public static class UnionFind {

        int[] parent;
        int[] size;

        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public boolean isConnected(int a, int b){
            return find(a) == find(b);
        }

        // find the parent of x
        // path compression makes future calls faster
        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int a, int b){
            int roota = find(a);
            int rootb = find(b);

            if(roota == rootb){
                return false; // union was not successfull
            }

            int sizea = size[roota];
            int sizeb = size[rootb];

            // merge smaller one in bigger
            if(sizea < sizeb){
                int temp = roota;
                roota = rootb;
                rootb = temp;
            }

            parent[rootb] = roota; // merge b into a
            size[roota] += size[rootb];
            return true;
        }

        static int[] findRedundantConnection(int[][] edges){
            int n = edges.length;

            UnionFind unionFind = new UnionFind(n+1);

            for(int[] edge: edges){
                int u = edge[0];
                int v = edge[1];

                if(!unionFind.union(u,v)){ // they are part of same group
                    return edge;
                }
            }
            return new int[0];
        }

        // n nodes
        // n-1 edges

        static void main() {
            int n = 6;

            UnionFind unionFind = new UnionFind(n); // 0 1 2 3 4 5
//            unionFind.union(0,2);// 02 1 3 4 5
//
//            System.out.println(unionFind.isConnected(0,5));// false // usecase
//            System.out.println(unionFind.isConnected(1,4));// false
//            System.out.println(unionFind.isConnected(0,0));// true
//
//            System.out.println(unionFind.find(2)); // 0
//
//            unionFind.union(1,3);// 02 13 4 5
//            unionFind.union(2,5);//025 13 4
//            unionFind.union(0,3);//02513 4
//
//            System.out.println(unionFind.find(2)); // 0
//
//            System.out.println(unionFind.isConnected(0,5));// true // usecase
//            System.out.println(unionFind.isConnected(1,4));// false
//            System.out.println(unionFind.isConnected(0,0));// true
//
//            unionFind.union(0,4);//025134
//
//            System.out.println(unionFind.isConnected(0,5));// true // usecase
//            System.out.println(unionFind.isConnected(1,4));// true
//            System.out.println(unionFind.isConnected(0,0));// true

            // 1 2
            // 1 3
            // 2 3
            //..

            int[][] edges = new int[3][2];
            edges[0][0] = 1;
            edges[0][1] = 2;

            edges[1][0] = 1;
            edges[1][1] = 3;

            edges[2][0] = 2;
            edges[2][1] = 3;

            int[] connection = findRedundantConnection(edges);
            System.out.println(connection[0] + " "+ connection[1]);
        }
    }
}
