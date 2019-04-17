package Seminar.Sudoku;

import java.util.ArrayList;

public class Vertex
{
    // color = same thing as value
    private int color;
    private boolean isDone;
    private ArrayList<Vertex> neighbors;

    // for blank cells
    public Vertex()
    {
        color = 0;
        isDone = false;
        neighbors = new ArrayList<>();
    }

    // for cells given (solved) in the puzzle
    public Vertex(int c)
    {
        color = c;
        isDone = true;
        neighbors = new ArrayList<>();
    }

    public void addNeighbor(Vertex v)
    {
        neighbors.add(v);
    }

    public boolean isDone()
    {
        return isDone;
    }

    public int getColor()
    {
        return color;
    }

    public void setColor(int c)
    {
        color = c;
    }

    public int findColor()
    {
        ArrayList<Integer> options = new ArrayList<>();
        options.add(1);
        options.add(2);
        options.add(3);
        options.add(4);
        options.add(5);
        options.add(6);
        options.add(7);
        options.add(8);
        options.add(9);

        for (Vertex n : neighbors)
        {
            options.remove(n.getColor());
        }

        if (options.size() == 1)
        {
            return options.get(0).intValue();
        }
        return 0;
    }
}