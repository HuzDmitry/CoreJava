package org.exa.lesson4.DZ;

import java.util.Random;

public class MyArrayCorrect {
    private String [][] arrayData;
    private Random random = new Random();
    private boolean importChar =false;
    private int CorectSizeRandom = 0;
    private static final int intSize = 100;
    private static final int sizeX = 4;
    private static final int sizeY = 4;
    private int arrayX;
    private int arrayY;
    public void setCorectSizeRandom(int corectSizeRandom) {
        this.CorectSizeRandom = corectSizeRandom;
    }

    public void setImportChar(boolean importChar) {
        this.importChar = importChar;
    }

    public void createIntArray() {
        arrayY = random.nextInt(sizeY,sizeY+1+ CorectSizeRandom);
        arrayX = random.nextInt(sizeX,sizeX+1+ CorectSizeRandom);
        arrayData = new String[arrayY][arrayX];
        for (int i=0; i<arrayY; i++){
            for (int j=0; j<arrayX; j++){
                arrayData[i][j] = String.valueOf(random.nextInt(intSize));
            }
        }
        if (importChar){
            int y = random.nextInt(arrayY);
            int x = random.nextInt(arrayX);

            arrayData[y][x]="stop";
        }
    }
    public void printArray(){
        for (int i=0; i<arrayY; i++){
            for (int j=0; j<arrayX; j++){
                System.out.printf(" [%s] ",arrayData[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public int sumIntMyArray() throws MyArrayException{
        int x;
        int y;
        if (arrayY != sizeY || arrayX != sizeX){
            throw new MyArraySizeException("Массив не соответствует ", arrayX, arrayY);
        }
        int sum=0;
        for (int i=0; i<arrayY; i++){
            for (int j=0; j<arrayX; j++){
                if (isDigits(arrayData[i][j])){
                    sum += Integer.parseInt(arrayData[i][j]);
                }else {
                    throw new MyArrayDataException("Строка не является числом ", j+1, i+1);
                }
            }
        }
        return sum;
    }
    private boolean isDigits(String num)throws NumberFormatException{
        try {
            Integer.parseInt(num);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
