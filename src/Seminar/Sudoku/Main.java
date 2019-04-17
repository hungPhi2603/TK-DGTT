package Seminar.Sudoku;

import java.util.*;

public class Main
{
	
	public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Sudoku sud = new Sudoku();

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                int m = s.nextInt();
                if (m == 0)
                {
                    sud.addCell(new Vertex(), i, j);
                }
                else
                {
                    sud.addCell(new Vertex(m), i, j);
                }
            }
        }
    }
}