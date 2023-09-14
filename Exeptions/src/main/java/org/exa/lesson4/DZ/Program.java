package org.exa.lesson4.DZ;

public class Program {
    public static void main(String[] args) {
        MyArrayCorrect myArrayCorrect = new MyArrayCorrect();
        myArrayCorrect.createIntArray();
        myArrayCorrect.printArray();
        myArrayCorrect.setImportChar(true);
        myArrayCorrect.setCorectSizeRandom(1);
        myArrayCorrect.createIntArray();
        myArrayCorrect.printArray();
        try {
           int sum = myArrayCorrect.sumIntMyArray();
            System.out.printf("Сумма чисел в массиве = %d",sum);
        }catch (MyArrayDataException e){
            System.out.printf("на позиции: X= %d Y= %d, %s",e.getX(), e.getY(), e.getMessage());
        }
        catch (MyArrayException e) {
            System.out.printf("%s . ваш размер массива: X=%d Y=%d", e.getMessage(), e.getX(), e.getY());
        }
    }
}
