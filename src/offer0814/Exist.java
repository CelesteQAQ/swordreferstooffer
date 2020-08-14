package offer0814;

/**
 * @author: celeste
 * @create: 2020-08-14 16:22
 * @description:
 * 题目：剑指 Offer 12. 矩阵中的路径
 * 描述：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
 * 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，
 * 那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入这个格子。
 **/
public class Exist {
    /**
     * 矩阵遍历是不是都是dfs或者是动态规划问题？
     * dfs问题，并且是很简单的就是搜索，没有使用其他的算法
     */
    boolean[][] marked;
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int m;
    int n;
    char[][] board;
    String word;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0){
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (dfs(i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param i : board中遍历到的横坐标
     * @param j ： board中遍历到的纵坐标
     * @param start ：word中开始匹配的位置
     * @return
     */
    private boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1){
            return board[i][j] == word.charAt(start);//如果搜索完成整个字符串返回true
        }
        if (board[i][j] == word.charAt(start)){
            marked[i][j] = true;//记得不访问该位置记得置为false
            for (int k = 0; k < 4; k++){
                int newX = i + direction[k][0];//更新位置
                int newY = j + direction[k][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !marked[newX][newY]){
                    if (dfs(newX, newY, start + 1)){
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }
}
