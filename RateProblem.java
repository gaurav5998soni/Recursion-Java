public class RateProblem {

    public static void main(String[] args) {

        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        boolean[][] visited = new boolean[4][4];

        String path = "";
        findPath(maze,visited,path, 0,0);

    }

    public static void findPath(int[][] maze, boolean[][] visited, String path, int row, int col) {

                if(row == maze.length-1 && col== maze.length-1){
                    System.out.println(path);
                    return;
                }

                //down
                if(!(row+1>=maze.length) && !visited[row+1][col] && maze[row+1][col]!=0) {
                    visited[row+1][col] = true;
                    path+="D";

                    findPath(maze, visited, path, row+1, col);
                    path=path.substring(0, path.length()-1);
                    visited[row+1][col] = false;
                }

                if(!(col-1<0) && !visited[row][col-1] && maze[row][col-1]!=0) {
                    visited[row][col-1] = true;
                    path+="L";

                    findPath(maze, visited, path, row, col-1);
                    path=path.substring(0, path.length()-1);
                    visited[row][col-1] = false;
                }

                if(!(col+1>=maze.length) && !visited[row][col+1] && maze[row][col+1]!=0) {
                    visited[row][col+1] = true;
                    path+="R";

                    findPath(maze, visited, path, row, col+1);
                    path=path.substring(0, path.length()-1);
                    visited[row][col+1] = false;
                }

                if(!(row-1<0) && !visited[row-1][col] && maze[row-1][col]!=0) {
                    visited[row-1][col] = true;
                    path+="U";

                    findPath(maze, visited, path, row-1, col);
                    path=path.substring(0, path.length()-1);
                    visited[row-1][col] = false;
                }
    }
}
