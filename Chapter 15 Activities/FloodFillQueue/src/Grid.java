import java.util.*;
public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    Stack<Pair> flood = new Stack<>();

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        Pair pair1;
        Pair pair = new Pair(row,column);
        flood.push(pair); 
        int x = 1;

        while(flood.size() > 0){
            pair1 = flood.pop();
            if(pixels[pair1.getRow()][pair1.getColumn()] == 0){
                pixels[pair1.getRow()][pair1.getColumn()] = x;
                x++;
            }
            if(pair.getRow() - 1 > 0 && pixels[pair1.getRow() - 1][pair1.getColumn()] == 0){
                flood.push(new Pair(pair1.getRow() - 1, pair1.getColumn()));
            }
            if(pair.getRow() + 1 < SIZE && pixels[pair1.getRow() + 1][pair1.getColumn()] == 0){
                flood.push(new Pair(pair1.getRow() + 1, pair1.getColumn()));
            }
            if(pair.getColumn()+1 < SIZE && pixels[pair1.getRow()][pair1.getColumn()+ 1] == 0){
                flood.push(new Pair(pair1.getRow(), pair1.getColumn()+1));
            }
            if(pair.getColumn()-1 > 0 && pixels[pair1.getRow()][pair1.getColumn()- 1] == 0){
                flood.push(new Pair(pair1.getRow(), pair1.getColumn()-1));
            }
        }
    }

    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%3d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
