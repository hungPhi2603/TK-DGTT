package Seminar.Sudoku;

import java.util.ArrayList;

public class Sudoku
{
    ArrayList<ArrayList<Vertex>> cells;

    // initializing Sudoku Game Board
    public Sudoku()
    {
        cells = new ArrayList<>();
    }

    public void addCell(Vertex v, int x, int y)
    {
        cells.get(x).add(y, v);
    }

    public boolean isSolved()
    {
        for (int i = 0; i < cells.size(); i++)
        {
            for (int j = 0; j < cells.get(i).size(); j++)
            {
                if (!cells.get(i).get(j).isDone())
                {
                    return false;
                }
            }
        }
        return true;
    }

    public void solve()
    {
        while (!isSolved())
        {
            for (int i = 0; i < cells.size(); i++)
            {
                for (int j = 0; j < cells.get(i).size(); j++)
                {
                    Vertex v = cells.get(i).get(j);
                    int c = v.findColor();
                    if (c != 0)
                    {
                        v.setColor(c);
                    }
                }
            }
        }

        System.out.println("Done solving!");
    }

}