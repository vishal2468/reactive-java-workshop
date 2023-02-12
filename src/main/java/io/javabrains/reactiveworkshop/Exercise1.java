package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        StreamSources.intNumbersStream().forEach((i)->System.out.println(i));
        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        StreamSources.intNumbersStream().filter((i)->i<5).forEach((i->System.out.println(i)));
        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        StreamSources.intNumbersStream().filter((i)->i>5).skip(1).limit(2).forEach((i)->System.out.println(i));
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        StreamSources.intNumbersStream().filter((i)->i>5).findFirst().ifPresentOrElse((i)->System.out.println(i), ()->System.out.println(-1));
        // Print first names of all users in userStream
        // TODO: Write code here
        StreamSources.userStream().forEach((user)->System.out.println(user.getFirstName()));
        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        
    }

}
