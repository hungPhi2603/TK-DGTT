package Trial_and_Error;

import java.io.*;
import java.util.Scanner;

public class Giao_hang {

    private static int[][] distances;
    private static int optimalDistance = Integer.MAX_VALUE;
    private static String optimalPath = "";

    public static void main(String args[]) throws IOException{

       
        Scanner input = new Scanner(System.in);
        
        String file = "dat/data.txt";

      
        System.out.println("Kich thuoc mang");
        int size = input.nextInt();

      
        distances = new int[size][size];

       
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);


        for (int row = 0 ; row < size ; row++) {

            String line = b.readLine();
            String[] values = line.trim().split("\\s+");

            for (int col = 0; col < size; col++) {
                distances[row][col] = Integer.parseInt(values[col]);
            }
        }

        b.close();

        String path = "";
        int[] vertices = new int[size - 1];

        for (int i = 1; i < size; i++) {
            vertices[i - 1] = i;
        }

        procedure(0, vertices, path, 0);

        System.out.print("Duong di: " + optimalPath + ". Quang duong = " + optimalDistance);
    }

    private static int procedure(int initial, int vertices[], String path, int costUntilHere) {

        path = path + Integer.toString(initial) + " - ";
        int length = vertices.length;
        int newCostUntilHere;


        if (length == 0) {
            newCostUntilHere = costUntilHere + distances[initial][0];

            if (newCostUntilHere < optimalDistance){
                optimalDistance = newCostUntilHere;
                optimalPath = path + "0";
            }

            return (distances[initial][0]);
        }


        else if (costUntilHere > optimalDistance){
            return 0;
        }


        else {

            int[][] newVertices = new int[length][(length - 1)];
            int costCurrentNode, costChild;
            int bestCost = Integer.MAX_VALUE;

            for (int i = 0; i < length; i++) {

                for (int j = 0, k = 0; j < length; j++, k++) {

                    if (j == i) {
                        k--;
                        continue;
                    }
                    newVertices[i][k] = vertices[j];
                }

                costCurrentNode = distances[initial][vertices[i]];

                newCostUntilHere = costCurrentNode + costUntilHere;

                costChild = procedure(vertices[i], newVertices[i], path, newCostUntilHere);

                int totalCost = costChild + costCurrentNode;

                if (totalCost < bestCost) {
                    bestCost = totalCost;
                }
            }

            return (bestCost);
        }
    }
}