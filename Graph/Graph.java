class Graph {
    int[][] graphMatrix = new int[10][10];
    int length = 0;
    public void addNode(int num) {
        if(num < graphMatrix.length - 1) {
            graphMatrix[num][num] = 1;
            length++;
        } else {
            expandMatrix();
            this.addNode(num);
        }
    }
    public void addConnection(int node1, int node2, boolean bothWays) {
        if(bothWays) {
            graphMatrix[node1][node2] = 1;
            graphMatrix[node2][node1] = 1;
        } else {
            graphMatrix[node1][node2] = 1;
        }
    }
    public void changeWeight (int node1, int node2,int weight) {
        graphMatrix[node1][node2] = weight;
    }
    public void expandMatrix() {
        int[][] copyMatrix = new int[graphMatrix.length * 10][graphMatrix.length * 10];
        for(int i = 0; i < graphMatrix.length; i++) {
            for(int j = 0; j < graphMatrix[i].length; j++) {
                copyMatrix[i][j] = graphMatrix[i][j];
            }
        }
        graphMatrix = copyMatrix;
    }
    public int Djikstras(int node1, int node2) {
        int[] values = new int[length];
        boolean[] done = new boolean[length];
        for(int i = 0; i < length; i++) {
            values[i] = Integer.MAX_VALUE;
            done[i] = false;
        }
        values[0] = 0;
        for(int i = 0; i > -1; i++) {
            int min = Integer.MAX_VALUE;
            int pos = Integer.MAX_VALUE;
            for(int j = 0; j < values.length; j++) {
                if(!done[j]) {
                    if(values[j] < min) {
                        min = values[j];
                        pos = j;
                    }
                }
            }
            done[pos] = true;
            for(int k = 0; k < values.length; k++) {
                System.out.print(values[k] + " ");
            }
            System.out.println();
            for(int k = 0; k < values.length; k++) {
                System.out.print(done[k] + " ");
            }
            System.out.println();
            int[] connections = graphMatrix[pos];
            for(int j = 0; j < connections.length; j++) {
                if(connections[j] != 0) {
                    if(values[j] > (connections[j] + values[pos])&& !done[j]) {
                        values[j] = connections[j] + values[pos];
                    }
                }
            }
            if(done[node2] == true) {
                break;
            }
        }
        return values[node2];
    }

    public static void main(String[] args) {
        System.out.println(graph.Djikstras(0,9) + " ans");
    }
}