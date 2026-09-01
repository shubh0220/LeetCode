class Solution {
    static class State {
        int row;
        int col;
        int energyLeft;
        int collectedMask;
        State(int row, int col, int energyLeft, int collectedMask) {
            this.row = row;
            this.col = col;
            this.energyLeft = energyLeft;
            this.collectedMask = collectedMask;
        }
    }
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int maxEnergy = energy;
        int[][] bit = new  int[20][20];
        int litterCount = 0;
        int startRow = 0;
        int startColumn = 0;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                bit[r][c] = -1;
                if(classroom[r].charAt(c) == 'S'){
                    startRow = r;
                    startColumn = c;
                }
                else if(classroom[r].charAt(c) == 'L') bit[r][c] = litterCount++;
            }
        }
        if(litterCount == 0) return 0;
        int all = (1<<litterCount) - 1;
        boolean[][][][] seen = new boolean[m][n][maxEnergy+1][all+1];
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<State> q = new LinkedList<>();
        q.add(new State(startRow,startColumn,maxEnergy,0));
        seen[startRow][startColumn][maxEnergy][0] = true;
        int moves = 0;
        while(!q.isEmpty()){
            int len = q.size();
            while(len-- > 0){
                State curr = q.poll();
                if(curr.collectedMask == all) return moves;
                if(curr.energyLeft == 0) continue;
                for(int[] x : directions){
                    int nextRow = curr.row + x[0];
                    int nextColumn = curr.col + x[1];
                    if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n) continue;
                    char cell = classroom[nextRow].charAt(nextColumn);
                    if(cell == 'X') continue;
                    int nextEnergy = curr.energyLeft - 1;
                    int newMask = curr.collectedMask;
                    if(cell == 'R') nextEnergy = maxEnergy;
                    else if(cell == 'L') newMask |= (1<<bit[nextRow][nextColumn]);
                    if (!seen[nextRow][nextColumn][nextEnergy][newMask]) {
                        seen[nextRow][nextColumn][nextEnergy][newMask] = true;
                        q.add(new State(nextRow, nextColumn, nextEnergy, newMask));
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}