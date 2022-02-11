import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {
    //Main
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        //Run Question 1
        Question_1(input);
        //Run Question 2
        Question_2(input);
        //Run Question 3
        Question_3(input);


        //Run Question 1 ALT (HASHMAP)
        Question_1_ALT(input);
        //Run Question 2 ALT (HASHMAP)
        Question_2_ALT(input);
        //Run Question 2 ALT (HASHMAP)
        Question_3_ALT(input);
    }

    //Question 1
    public static void Question_1(Scanner input)
    {
        //Declare linked list for integer
        LinkedList<Integer> list1 = new LinkedList<>();

        //Add in the default elements
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(9);
        list1.add(11);

        //Print default list
        System.out.println("List Before:<"+list1+">");
        //User input
        System.out.print("Number to insert: ");
        AddAndSort(list1, input.nextInt());
        //Print sorted list
        System.out.println("List After:<"+list1+">");
    }
    //Question 1
    public static void Question_1_ALT(Scanner input)
    {
        //Declare Hashmap for integer
        HashMap<Integer, Integer> map = new HashMap<>();

        //Add in the default elements
        map.put(0,1);
        map.put(1,3);
        map.put(2,5);
        map.put(3,7);
        map.put(4,9);
        map.put(5,11);

        //Print default list
        System.out.println("Hashmap Before:<"+map+">");
        //User input
        System.out.print("Number to insert: ");
        AddAndSortHashmap(map, input.nextInt());
        //Print sorted list
        System.out.println("Hashmap After:<"+map+">");
    }
    //Question 2
    public static void Question_2(Scanner input)
    {
        //Declare linked list for integer
        LinkedList<Integer> list2 = new LinkedList<>();

        //Add in the default elements
        list2.add(1);
        list2.add(3);
        list2.add(5);
        list2.add(7);
        list2.add(9);
        list2.add(11);

        //Print default list
        System.out.println("List Before:<"+list2+">");
        //User input
        System.out.println("Enter number to swap separate by enter: ");
        SwapValue(list2, input.nextInt(), input.nextInt());
        //Print sorted list
        System.out.println("List After:<"+list2+">");
    }
    //Question 2
    public static void Question_2_ALT(Scanner input)
    {
        //Declare linked list for integer
        HashMap<Integer,Integer> map = new HashMap<>();

        //Add in the default elements
        map.put(0,1);
        map.put(1,3);
        map.put(2,5);
        map.put(3,7);
        map.put(4,9);
        map.put(5,11);

        //Print default list
        System.out.println("Map Before:<"+map+">");
        //User input
        System.out.println("Enter number to swap separate by enter: ");
        SwapValueHashMap(map, input.nextInt(), input.nextInt());
        //Print sorted list
        System.out.println("Map After:<"+map+">");
    }

    //Question 3
    public static void Question_3(Scanner input)
    {
        //Declare linked list for integer
        LinkedList<Integer> list3 = new LinkedList<>();
        //Generate 500 rand values into the list
        for(int i = 0; i < 500; ++i)
        {
            list3.add((int)((Math.random() * (9999-1000))+1000));
        }
        //Print out list value
        System.out.println("List Val: " + list3);
        //Ask user input to find
        System.out.print("Enter value to find: " );
        int num = FindValue(list3, input.nextInt());
        System.out.println(num==-1?"Value not found -1":"Value found at: "+num);
    }

    //Question 3
    public static void Question_3_ALT(Scanner input)
    {
        //Declare linked list for integer
        HashMap<Integer,Integer> map = new HashMap<>();
        //Generate 500 rand values into the list
        for(int i = 0; i < 500; ++i)
        {
            map.put(i,(int)((Math.random() * (9999-1000))+1000));
        }
        //Print out list value
        System.out.println("Map Val: " + map);
        //Ask user input to find
        System.out.print("Enter value to find: " );
        int num = FindValueHashMap(map, input.nextInt());
        System.out.println(num==-1?"Value not found -1":"Value found at: "+num);
    }

    //Question 1 Functions
    public static void AddAndSort(LinkedList<Integer> list, int value)
    {
        //Store the index at where to insert the value
        int indexVal = 0;
        //Iterate through the list to find the value
        for(int i = 0; i < list.size(); ++i)
        {
            //If value in list is lower than value skip to next
            if(list.get(i) < value)
            {
                indexVal = i+1;
                continue;
            }
            //Found value store index and break loop
            indexVal = i;
            break;
        }
        //Insert into list
        list.add(indexVal, value);
    }

    public static void AddAndSortHashmap(HashMap<Integer, Integer> map, int value)
    {
        //Store the index at where to insert the value
        int indexVal = 0;
        //Iterate through the list to find the value
        for(int i = 0; i < map.size(); ++i)
        {
            //If value in list is lower than value skip to next
            if(map.get(i) < value)
            {
                indexVal = i+1;
                continue;
            }
            //Found value store index and break loop
            indexVal = i;
            break;
        }
        //Insert into list
        map.put(indexVal, value);
    }

    public static void SwapValue(LinkedList<Integer> list, int indexOne, int indexTwo)
    {
        //Safety!
        if(indexOne > list.size() || indexTwo > list.size())
        {
            System.out.println("One of the index is too large");
            return;
        }

        //Container to keep
        int temp = list.get(indexOne);
        list.set(indexOne,list.get(indexTwo));
        list.set(indexTwo,temp);
    }

    public static void SwapValueHashMap(HashMap<Integer,Integer> map, int indexOne, int indexTwo)
    {
        //Safety!
        if(indexOne > map.size() || indexTwo > map.size())
        {
            System.out.println("One of the index is too large");
            return;
        }

        //Container to keep
        int temp = map.get(indexOne);
        map.put(indexOne,map.get(indexTwo));
        map.put(indexTwo,temp);
    }

    public static int FindValue(LinkedList<Integer> list, int searchVal)
    {
        //Default Number
        int index = -1;
        //Iterate through to find value
        for (int i = 0; i < list.size(); ++i)
        {
            //Found item
            if(list.get(i) == searchVal)
            {
                return i;
            }
        }
        //Return the index number
        return index;
    }

    public static int FindValueHashMap(HashMap<Integer,Integer> list, int searchVal)
    {
        //Default Number
        int index = -1;
        //Iterate through to find value
        for (int i = 0; i < list.size(); ++i)
        {
            //Found item
            if(list.get(i) == searchVal)
            {
                return i;
            }
        }
        //Return the index number
        return index;
    }
}
